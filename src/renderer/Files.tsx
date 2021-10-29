import React from "react";
import { ipcRenderer } from "electron";
import { FaFolder, FaFile, FaAngleRight, FaAngleDown } from "react-icons/fa";
import { subject } from "./bridge";
import "./assets/styles/Files.less";

type Entity = {
  name: string,
  path: string,
  files?: Entity[]
};

export default class Files extends React.Component<{ workspace: string }, { files: Entity[] }> {
  constructor(props) {
    super(props);
    this.state = {
      files: []
    };
  }
  componentDidMount() {
    ipcRenderer.invoke("list", this.props.workspace).then((data) => {
      this.setState({ files: data.files })
    });
  }
  render() {
    return (
      <div id="files">
        <ul>
          {this.state.files.map((e, i) => (
            <File key={i} {...e}/>
          ))}
        </ul>
      </div>
    );
  }
}

class File extends React.Component<Entity, unknown> {
  handleClick(event: React.MouseEvent<HTMLElement>) {
    subject.next(event.currentTarget.dataset.path);
  }
  render() {
    return (
      <li>
        {this.props.files ?
          <Folder {...this.props}/> :
          <span onClick={this.handleClick.bind(this)} data-path={this.props.path} className="file"><FaFile/> {this.props.name}</span>
        }
      </li>
    );
  }
}

class Folder extends React.Component<Entity, { collapsed: boolean }> {
  constructor(props) {
    super(props);
    this.state = {
      collapsed: true
    }
  }
  handleClick() {
    this.setState({ collapsed: !this.state.collapsed })
  }
  render() {
    return (
      <>
        <span className="caret">{this.state.collapsed ? <FaAngleRight/> : <FaAngleDown/>}</span> 
        <span className="folder" onClick={this.handleClick.bind(this)}><FaFolder/> {this.props.name}</span>
        {this.state.collapsed ? "" : 
          <ul>
            {this.props.files.map((e, i) => (
              <File key={i} {...e}/>
            ))}
          </ul>
        }
      </>
    );
  }
}