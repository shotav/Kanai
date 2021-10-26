import React from "react";
import "./App.css";

export default class App extends React.Component {
  handleClick(e) {
    console.log(e.currentTarget.dataset.name);
  }
  render() {
    return (
      <>
        <div id="files">
          <ul>
            <li onClick={this.handleClick.bind(this)} data-name="1.txt"><a>Test</a></li>
            <li onClick={this.handleClick.bind(this)} data-name="2.txt"><a>Test</a></li>
            <li onClick={this.handleClick.bind(this)} data-name="3.txt"><a>Test</a></li>
            <li onClick={this.handleClick.bind(this)} data-name="4.txt"><a>Test</a></li>
            <li onClick={this.handleClick.bind(this)} data-name="5.txt"><a>Test</a></li>
          </ul>
        </div>
        <div className="editor">
          Test<br/>
          Test<br/>
          Test
        </div>
      </>
    );
  }
}