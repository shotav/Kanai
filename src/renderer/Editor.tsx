import React from "react";
import { ipcRenderer } from "electron";
import { Helmet } from "react-helmet";
import "./assets/less/Editor.less";

export default class Editor extends React.Component<{ file: string }, { lines: number }> {
  private lines: React.RefObject<HTMLDivElement>;
  private text: React.RefObject<HTMLTextAreaElement>;
  constructor(props) {
    super(props);
    this.lines = React.createRef();
    this.text = React.createRef();
    this.state = {
      lines: 1
    };
  }
  handleScroll = (event: React.UIEvent<HTMLElement>) => {
    this.lines.current.scrollTop = event.currentTarget.scrollTop;
  }
  handleChange = (event: React.FormEvent<HTMLTextAreaElement>) => {
    this.setState({ lines: event.currentTarget.value.split(/\r|\r\n|\n/).length });
  }
  componentDidUpdate(prevProps) {
    if (this.props.file !== prevProps.file && this.props.file) {
      ipcRenderer.invoke("read", this.props.file).then((data) => {
        this.text.current.value = data;
        this.setState({ lines: this.text.current.value.split(/\r|\r\n|\n/).length });
        this.lines.current.scrollTop = this.text.current.scrollTop;
      });
    }
  }
  componentDidMount() {
    ipcRenderer.on("saveAs", () => ipcRenderer.send("saveAs", this.text.current.value));
    ipcRenderer.on("save", () => {
      if (this.props.file) {
        ipcRenderer.send("write", this.props.file, this.text.current.value);
      } else {
        ipcRenderer.send("saveAs", this.text.current.value);
      }
    });
  }
  render() {
    return (
      <>
        <Helmet>
          <title>{this.props.file || "Untitled"}</title>
        </Helmet>
        <div id="editor">
          <div ref={this.lines}>
            {Array(this.state.lines).fill(0).map((_, i) => (
              <span key={i}/>
            ))}
          </div>
          <textarea ref={this.text} spellCheck="false" onScroll={this.handleScroll.bind(this)} onChange={this.handleChange.bind(this)}/>
        </div>
      </>
    );
  }
}