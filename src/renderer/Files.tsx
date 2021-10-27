import React from "react";
import { ipcRenderer } from "electron";
import { FaFolder, FaFile } from "react-icons/fa";
import "./assets/less/Files.less";

export default class Files extends React.Component {
  handleClick(event: React.MouseEvent<HTMLElement>) {
    ipcRenderer.send("openFile", event.currentTarget.dataset.name);
  }
  render() {
    return (
      <div id="files">
        <ul>
          <li onClick={this.handleClick.bind(this)} data-name="Test 1"><a><FaFolder/> Test 1</a></li>
          <li onClick={this.handleClick.bind(this)} data-name="Test 1"><a><FaFolder/> Test 2</a></li>
          <li onClick={this.handleClick.bind(this)} data-name="Test 1"><a><FaFolder/> Test 3</a></li>
          <li onClick={this.handleClick.bind(this)} data-name="Test1.txt"><a><FaFile/> Test1.txt</a></li>
          <li onClick={this.handleClick.bind(this)} data-name="Test2.txt"><a><FaFile/> Test2.txt</a></li>
          <li onClick={this.handleClick.bind(this)} data-name="Test3.txt"><a><FaFile/> Test3.txt</a></li>
          <li onClick={this.handleClick.bind(this)} data-name="Test4.txt"><a><FaFile/> Test4.txt</a></li>
          <li onClick={this.handleClick.bind(this)} data-name="Test5.txt"><a><FaFile/> Test5.txt</a></li>
        </ul>
      </div>
    );
  }
}