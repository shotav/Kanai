package main

import "github.com/webview/webview"

func main() {
	debug := true
	w := webview.New(debug)
	defer w.Destroy()
	w.SetTitle("Kanai")
	w.SetSize(1280, 720, webview.HintNone)
	w.Navigate("http://localhost:8080")
	w.Run()
}