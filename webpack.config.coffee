path = require "path"
HtmlWebpackPlugin = require "html-webpack-plugin"
ESLintPlugin = require "eslint-webpack-plugin"
StylelintPlugin = require "stylelint-webpack-plugin"

module.exports =
  entry: [
    "./src/renderer/Main.coffee"
    "./src/renderer/assets/styles/Main.styl"
  ]
  output:
    path: path.join __dirname, "build"
    filename: "bundle.js"
  resolve:
    modules: [
      path.resolve __dirname, "node_modules"
      path.resolve __dirname, "src", "renderer"
    ]
    extensions: [ ".js", ".coffee", ".elm" ]
  module:
    rules: [
      {
        test: /\.pug$/
        loader: "pug-loader" 
      }
      {
        test: /\.js$/
        loader: "babel-loader" 
      }
      {
        test: /\.coffee$/
        use: [
          "babel-loader"
          "coffee-loader"
        ] 
      }
      { 
        test: /\.elm$/
        use: [
          "babel-loader"
          "elm-webpack-loader"
        ] 
      }
      {
        test: /\.styl$/
        use: [
          "style-loader"
          "css-loader"
          "postcss-loader"
          "stylus-loader"
        ]
      }
    ]
  plugins: [
    new HtmlWebpackPlugin(
      template: "src/renderer/assets/views/index.pug"
    )
    new ESLintPlugin(
      extensions: [ "js", "coffee" ]
    )
    new StylelintPlugin(
      extensions: [ "styl" ]
    )
  ]