import React from "react";
import { ipcRenderer } from "electron";
import { Helmet } from "react-helmet";
import CryptoJS from "crypto-js";
import Prism from "prismjs";
import "./assets/less/Editor.less";
import "./assets/less/Syntax.less";

export default class Editor extends React.Component<{ file: string }, { name: string, lines: number, currentHash: string, savedHash: string, preview: string }> {
  private lines: React.RefObject<HTMLDivElement>;
  private preview: React.RefObject<HTMLDivElement>;
  private text: React.RefObject<HTMLTextAreaElement>;
  constructor(props) {
    super(props);
    this.lines = React.createRef();
    this.preview = React.createRef();
    this.text = React.createRef();
    this.state = {
      name: undefined,
      currentHash: "",
      savedHash: undefined,
      lines: 1,
      preview: ""
    };
  }
  handleScroll = (event: React.UIEvent<HTMLElement>) => {
    this.preview.current.scrollTop = event.currentTarget.scrollTop;
    this.preview.current.scrollLeft = event.currentTarget.scrollLeft;
    this.lines.current.scrollTop = event.currentTarget.scrollTop;
  }
  handleChange = (event: React.FormEvent<HTMLTextAreaElement>) => {
    this.setState({
      currentHash: CryptoJS.SHA1(event.currentTarget.value).toString(),
      lines: event.currentTarget.value.split(/\r|\r\n|\n/).length,
      preview: Prism.highlight(event.currentTarget.value, Prism.languages["html"], "html")
    });
  }
  componentDidUpdate(prevProps) {
    if (this.props.file !== prevProps.file) {
      if (this.props.file) {
        ipcRenderer.invoke("read", this.props.file).then((data) => {
          const hash = CryptoJS.SHA1(data.content).toString();
          this.text.current.value = data.content;
          this.setState({
            name: data.name,
            currentHash: hash,
            savedHash: hash,
            lines: this.text.current.value.split(/\r|\r\n|\n/).length,
            preview: Prism.highlight(data.content, Prism.languages["html"], "html")
          });
          this.preview.current.scrollTop = this.text.current.scrollTop;
          this.preview.current.scrollLeft = this.text.current.scrollLeft;
          this.lines.current.scrollTop = this.text.current.scrollTop;
        });
      } else {
        this.text.current.value = "";
        this.setState({
          name: undefined,
          currentHash: "",
          savedHash: undefined,
          lines: 1,
          preview: ""
        });
        this.preview.current.scrollTop = this.text.current.scrollTop;
        this.preview.current.scrollLeft = this.text.current.scrollLeft;
        this.lines.current.scrollTop = this.text.current.scrollTop;
      }
    }
  }
  componentDidMount() {
    ipcRenderer.on("saved", (_, hash) => this.setState({ savedHash: hash }));
    ipcRenderer.on("saveAs", () => ipcRenderer.send("saveAs", this.text.current.value));
    ipcRenderer.on("save", () => {
      const hash = CryptoJS.SHA1(this.text.current.value).toString();
      if (this.props.file) {
        ipcRenderer.send("write", this.props.file, this.text.current.value, hash);
      } else {
        ipcRenderer.send("writeAs", this.text.current.value, hash);
      }
    });
  }
  render() {
    return (
      <>
        <Helmet>
          <title>{this.state.currentHash === this.state.savedHash ? "" : "\u2022"} {this.state.name ? this.state.name : "Untitled"} - Kanai Editor</title>
        </Helmet>
        <div id="editor">
          <div id="numbers" ref={this.lines}>
            {Array(this.state.lines).fill(0).map((_, i) => (
              <span key={i}/>
            ))}
          </div>
          <div id="code">
            <div id="preview" ref={this.preview} dangerouslySetInnerHTML={{ __html: this.state.preview }}/>
            <textarea ref={this.text} onScroll={this.handleScroll.bind(this)} onChange={this.handleChange.bind(this)}/>
          </div>
        </div>
      </>
    );
  }
}