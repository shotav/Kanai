import React from "react";
import Files from "./Files";
import Editor from "./Editor";
import "./assets/less/App.less";
import "./assets/less/Fonts.less";

export default class App extends React.Component {
  render() {
    return (
      <>
        <Files/>
        <Editor/>
      </>
    );
  }
}