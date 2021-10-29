const path = require("path");
const HtmlWebpackPlugin = require("html-webpack-plugin");
const ESLintPlugin = require("eslint-webpack-plugin");
const StylelintPlugin = require("stylelint-webpack-plugin");

module.exports = {
  entry: "./src/renderer/main.ts",
  target: "electron-renderer",
  devtool: "source-map",
  output: {
    path: path.join(__dirname, "build", "renderer"),
    filename: "bundle.js"
  },
  resolve: {
      modules: [
        path.resolve(__dirname, "node_modules"),
        path.resolve(__dirname, "src", "renderer")
      ],
      extensions: [ ".js", ".jsx" , ".ts", ".tsx" ]
  },
  devServer: {
    static: path.join(__dirname, "src", "renderer", "public")
  },
  module: {
    rules: [
      {
        test: /\.(js|jsx|ts|tsx)$/,
        exclude: /node_modules/,
        use: [ "babel-loader" ]
      },
      {
        test: /\.(css|less)$/,
        use: [ "style-loader", "css-loader", "postcss-loader", "less-loader" ]
      }
    ]
  },
  plugins: [
    new HtmlWebpackPlugin({
      template: "src/renderer/assets/views/index.ejs"
    }),
    new ESLintPlugin({
      extensions: [ "js", "jsx", "ts", "tsx" ]
    }),
    new StylelintPlugin({
      extensions: [ "css", "less" ]
    })
  ]
};