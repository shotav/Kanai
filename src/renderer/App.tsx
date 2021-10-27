import React from "react";
import { ipcRenderer } from "electron";
import Files from "./Files";
import Editor from "./Editor";
import "./assets/less/App.less";
import "./assets/less/Fonts.less";

export default class App extends React.Component {
  handleKeyStrokes = (event: KeyboardEvent) => {
    if (event.ctrlKey){
      switch (event.key.toLowerCase()) {
        case "o":
          event.preventDefault();
          if (event.shiftKey) {
            ipcRenderer.send("openDialogDir");
          } else {
            ipcRenderer.send("openDialog");
          }
          break;
      }
    }
  }
  componentDidMount() {
    document.addEventListener("keydown", this.handleKeyStrokes);
  }
  render() {
    return (
      <>
        <Files/>
        <Editor/>
      </>
    );
  }
}