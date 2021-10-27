import React from "react";
import "./assets/less/Editor.less";

export default class Editor extends React.Component {
  lines = React.createRef<HTMLDivElement>();
  state = {
    lines: 1
  };
  handleKeyStrokes = (event: KeyboardEvent) => {
    if (event.ctrlKey){
      switch (event.key.toLowerCase()) {
        case "s":
          event.preventDefault();
          if (event.shiftKey) {
            console.log("TODO: Open Save Dialog");
          } else {
            console.log("TODO: Save File");
          }
          break;
      }
    }
  }
  handleScroll = (event: React.UIEvent<HTMLElement>) => {
    this.lines.current.scrollTop = event.currentTarget.scrollTop;
  }
  handleChange = (event: React.FormEvent<HTMLTextAreaElement>) => {
    const lines = event.currentTarget.value.split(/\r|\r\n|\n/);
    this.setState({ lines: lines.length });
  }
  componentDidMount() {
    document.addEventListener("keydown", this.handleKeyStrokes);
  }
  render() {
    return (
      <div id="editor">
        <div id="lines" ref={this.lines}>
          {Array(this.state.lines).fill(0).map((_, i) => (
            <span key={i}/>
          ))}
        </div>
        <textarea id="text" spellCheck="false" onScroll={this.handleScroll.bind(this)} onChange={this.handleChange.bind(this)}/>
      </div>
    );
  }
}