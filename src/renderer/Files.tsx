import React from "react";
import { ipcRenderer } from "electron";
import { FaFolder, FaFile, FaAngleRight, FaAngleDown, FaFileAlt } from "react-icons/fa";
import { SiMarkdown, SiJson, SiJavascript, SiTypescript, SiCss3, SiLess, SiSass, SiHtml5, SiPython, SiRust, SiC, SiCplusplus, SiRuby, SiCsharp, SiJava, SiGo, SiReact, SiKotlin, SiLua, SiCoffeescript, SiDart } from "react-icons/si";
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
  getIcon() {
    if (this.props.name.includes(".")) {
      switch (this.props.name.split(".").pop().toLocaleLowerCase()) {
        case "c": case "h": return <SiC/>;
        case "coffee": return <SiCoffeescript/>;
        case "cpp": case "hpp": return <SiCplusplus/>;
        case "cs": return <SiCsharp/>;
        case "css": return <SiCss3/>;
        case "dart": return <SiDart/>;
        case "go": return <SiGo/>;
        case "html": return <SiHtml5/>;
        case "java": return <SiJava/>;
        case "js": return <SiJavascript/>;
        case "json": return <SiJson/>;
        case "jsx": case "tsx": return <SiReact/>;
        case "kt": return <SiKotlin/>;
        case "less": return <SiLess/>;
        case "lua": return <SiLua/>;
        case "md": return <SiMarkdown/>;
        case "py": return <SiPython/>;
        case "rb": return <SiRuby/>;
        case "rs": return <SiRust/>;
        case "sass": case "scss": return <SiSass/>;
        case "ts": return <SiTypescript/>;
        case "txt": return <FaFileAlt/>;
      }
    }
    return <FaFile/>;
  }
  handleClick(event: React.MouseEvent<HTMLElement>) {
    subject.next(event.currentTarget.dataset.path);
  }
  render() {
    return (
      <li>
        {this.props.files ?
          <Folder {...this.props}/> :
          <span onClick={this.handleClick.bind(this)} data-path={this.props.path} className="file">{this.getIcon()} {this.props.name}</span>
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