const path = require("path");
const { app, BrowserWindow, ipcMain } = require("electron");
const isDev = require("electron-is-dev");
const serve = require("electron-serve");
const loadURL = serve({ directory: "build" });

const createWindow = () => {
  const win = new BrowserWindow({
    width: 1280,
    height: 720,
    show: false,
    icon: path.join(process.cwd(), "public/favicon.png"),
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