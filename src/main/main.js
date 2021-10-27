const path = require("path");
const fs = require("fs");
const { app, BrowserWindow, Menu, MenuItem, ipcMain, dialog } = require("electron");
const isDev = require("electron-is-dev");
const serve = require("electron-serve");
const loadURL = serve({ directory: "build" });

let win;

const createWindow = () => {
  win = new BrowserWindow({
    width: 1280,
    height: 720,
    show: false,
    icon: path.join(process.cwd(), "src", "renderer", "public", "favicon.png"),
    autoHideMenuBar: true,
    webPreferences: {
      nodeIntegration: true,
      contextIsolation: false,
      spellcheck: false,
      preload: path.join(__dirname, "preload.js")
    }
  });

  const menu = new Menu();
  menu.append(new MenuItem({
    label: "File",
    submenu: [
      { label: "New File", accelerator: "CTRL+N", enabled: false },
      { label: "New Window", accelerator: "CTRL+SHIFT+N", enabled: false },
      { type: "separator" },
      { label: "Open File...", accelerator: "CTRL+O", click: () => {
        dialog.showOpenDialog(win, { title: "Kanai", properties: [ "openFile", "showHiddenFiles" ] }).then((result) => {
          if (!result.canceled) {
            win.webContents.send("open", result.filePaths[0]);
          }
        });
      }},
      { label: "Open Folder...", accelerator: "CTRL+SHIFT+O", enabled: false },
      { type: "separator" },
      { label: "Save", accelerator: "CTRL+S", click: () => {
        win.webContents.send("save");
      }},
      { label: "Save As...", accelerator: "CTRL+SHIFT+S", click: () => {
        win.webContents.send("saveAs");
      }},
      { type: "separator" },
      { role: "quit" }
    ]
  }));
  menu.append(new MenuItem({
    label: "Edit",
    submenu: [
      { role: "undo" },
      { role: "redo" },
      { type: "separator" },
      { role: "cut" },
      { role: "copy" },
      { role: "paste" },
      { role: "selectAll" }
    ]
  }));
  menu.append(new MenuItem({
    label: "View",
    submenu: [
      { role: "togglefullscreen" },
      { role: "toggleDevTools" },
      { type: "separator" },
      { label: "Increase Font Size", accelerator: "CTRL+PLUS", enabled: false },
      { label: "Decrease Font Size", accelerator: "CTRL+-", enabled: false },
      { label: "Reset Font Size", accelerator: "CTRL+0", enabled: false }
    ]
  }));
  Menu.setApplicationMenu(menu);

  win.setMenuBarVisibility(false);
  win.once("ready-to-show", () => win.show());

  if (isDev) {
    process.env.ELECTRON_DISABLE_SECURITY_WARNINGS = "true";
    win.loadURL("http://localhost:8080");
    win.webContents.openDevTools({ mode: "detach" });
  } else {
    loadURL(win);
  }
}

app.whenReady().then(() => {
  createWindow();

  app.on("activate", () => {
    if (BrowserWindow.getAllWindows().length === 0) createWindow();
  });
});

app.on("window-all-closed", () => {
  if (process.platform !== "darwin") app.quit();
});

ipcMain.handle("read", (_, file) => {
  return {
    name: path.basename(file),
    content: fs.readFileSync(file, "utf-8")
  };
});
ipcMain.on("write", (event, file, content, hash) => {
  fs.writeFile(file, content, (error) => {
    if (!error) {
      event.reply("saved", hash);
    }
  });
});
ipcMain.on("writeAs", (event, content) => {
  dialog.showSaveDialog(win, { title: "Kanai", properties: [ "showHiddenFiles" ] }).then((result) => {
    if (!result.canceled) {
      const file = result.filePath;
      fs.writeFileSync(file, content);
      event.reply("open", file);
    }
  });
});