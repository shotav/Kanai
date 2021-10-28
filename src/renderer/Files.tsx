import React from "react";
import { FaFolder, FaFile, FaAngleRight, FaAngleDown } from "react-icons/fa";
import "./assets/less/Files.less";

type Entity = {
  name: string,
  path: string,
  files?: Entity[]
};

export default class Files extends React.Component<unknown, { files: Entity[] }> {
  constructor(props) {
    super(props);
    this.state = {
      files: [
        { name: "Test", path: "Test/", files: [
          { name: "Test", path: "Test/Test/", files: [] },
          { name: "Test", path: "Test/Test/", files: [
            { name: "Test", path: "Test/", files: [] },
            { name: "Test.txt", path: "Test/Test/Test.txt" }
          ]}
        ]},
        { name: "Test", path: "Test/", files: [
          { name: "Test.txt", path: "Test/Test.txt" }
        ]},
        { name: "Test", path: "Test/", files: [] },
        { name: "Test.txt", path: "Test.txt" },
        { name: "Test.txt", path: "Test.txt" },
        { name: "Test.txt", path: "Test.txt" }
      ]
    };
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
    console.log(event.currentTarget.dataset.path);
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