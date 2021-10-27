const path = require("path");
const { app, BrowserWindow, ipcMain, dialog } = require("electron");
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
    webPreferences: {
      nodeIntegration: true,
      contextIsolation: false,
      preload: path.join(__dirname, "preload.js")
    }
  });

  win.removeMenu();
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

ipcMain.on("openDialog", () => {
  dialog.showOpenDialog(win, { title: "Kanai", properties: [ "openFile", "showHiddenFiles" ] });
});

ipcMain.on("openDialogDir", () => {
  dialog.showOpenDialog(win, { title: "Kanai", properties: [ "openDirectory" ] });
});