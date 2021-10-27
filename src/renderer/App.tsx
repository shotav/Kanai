import React from "react";
import { ipcRenderer } from "electron";
// import Files from "./Files";
import Editor from "./Editor";
import "./assets/less/App.less";
import "./assets/less/Fonts.less";

export default class App extends React.Component<unknown, { path: string }> {
  constructor(props) {
    super(props);
    this.state = {
      path: ""
    };
  }
  componentDidMount() {
    ipcRenderer.on("open", (_, path) => {
      this.setState({ path: "" });
      this.setState({ path });
    });
  }
  render() {
    return (
      <>
        {/* <Files/> */}
        <Editor file={this.state.path}/>
      </>
    );
  }
}