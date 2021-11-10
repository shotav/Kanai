const path = require("path");
const HtmlWebpackPlugin = require("html-webpack-plugin");
const ESLintPlugin = require("eslint-webpack-plugin");
const StylelintPlugin = require("stylelint-webpack-plugin");

module.exports = {
  entry: [
    "./src/renderer/main.coffee",
    "./src/renderer/assets/styles/styles.sass"
  ],
  output: {
    path: path.join(__dirname, "build"),
    filename: "bundle.js"
  },
  resolve: {
      modules: [
        path.resolve(__dirname, "node_modules"),
        path.resolve(__dirname, "src", "renderer")
      ],
      extensions: [ ".coffee" ]
  },
  devServer: {
    static: path.join(__dirname, "src", "renderer", "public")
  },
  module: {
    rules: [
      {
        test: /\.pug$/,
        loader: "pug-loader"
      },
      {
        test: /\.elm$/,
        loader: "elm-webpack-loader"
      },
      {
        test: /\.coffee$/,
        loader: "coffee-loader"
      },
      {
        test: /\.(sass)$/,
        use: [ "style-loader", "css-loader", "postcss-loader", "sass-loader" ]
      }
    ]
  },
  plugins: [
    new HtmlWebpackPlugin({
      template: "src/renderer/assets/views/index.pug"
    }),
    new ESLintPlugin({
      extensions: [ "coffee" ]
    }),
    new StylelintPlugin({
      extensions: [ "sass" ]
    })
  ]
};