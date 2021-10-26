const path = require("path");
const CopyPlugin = require("copy-webpack-plugin");

module.exports = {
  entry: "./src/renderer/main.js",
  target: "electron-renderer",
  output: {
    path: path.join(__dirname, "build"),
    filename: "bundle.js"
  },
  resolve: {
      modules: [
        path.resolve(__dirname, "node_modules"),
        path.resolve(__dirname, "src", "renderer")
      ],
      extensions: [ ".jsx", ".js" ]
  },
  devServer: {
    static: path.join(__dirname, "src", "renderer", "public")
  },
  module: {
    rules: [
      {
        test: /\.(js|jsx)$/,
        exclude: /node_modules/,
        use: [ "babel-loader" ]
      },
      {
        test: /\.css$/,
        use: [ "style-loader", "css-loader", "postcss-loader" ]
      }
    ]
  },
  plugins: [
    new CopyPlugin({
      patterns: [{ context: path.join(__dirname, "src", "renderer"), from: "public", to: "." }]
    })
  ]
};