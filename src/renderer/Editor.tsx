import React from "react";
import "./assets/less/Editor.less";

export default class Editor extends React.Component {
  lines = React.createRef<HTMLDivElement>();
  state = {
    lines: 1
  };
  handleScroll = (event: React.UIEvent<HTMLElement>) => {
    this.lines.current.scrollTop = event.currentTarget.scrollTop;
  }
  handleChange = (event: React.FormEvent<HTMLTextAreaElement>) => {
    const lines = event.currentTarget.value.split(/\r|\r\n|\n/);
    this.setState({ lines: lines.length });
  }
  render() {
    return (
      <div id="editor">
        <div ref={this.lines}>
          {Array(this.state.lines).fill(0).map((_, i) => (
            <span key={i}/>
          ))}
        </div>
        <textarea spellCheck="false" onScroll={this.handleScroll.bind(this)} onChange={this.handleChange.bind(this)}/>
      </div>
    );
  }
}