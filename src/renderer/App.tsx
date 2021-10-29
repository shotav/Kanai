import React from "react";
import { ipcRenderer } from "electron";
import Files from "./Files";
import Editor from "./Editor";
import { subject } from "./bridge";
import "./assets/styles/App.less";
import "./assets/styles/Fonts.less";

export default class App extends React.Component<unknown, { path: string }> {
  private subscription;
  constructor(props) {
    super(props);
    this.state = {
      path: ""
    };
  }
  componentDidMount() {
    ipcRenderer.on("open", (_, path) => this.setState({ path }));
    this.subscription = subject.subscribe((path) => this.setState({ path: path.toString() }));
  }
  componentWillUnmount() {
    this.subscription.unsubscribe();
  }
  render() {
    return (
      <>
        <Files workspace="."/>
        <Editor file={this.state.path}/>
      </>
    );
  }
}