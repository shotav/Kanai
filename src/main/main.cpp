#include <iostream>
#include <webview.h>

int main(int argc, char* argv[]) {
  webview::webview w(true, nullptr);
  w.set_title("Kanai");
  w.set_size(1280, 720, WEBVIEW_HINT_NONE);
  w.navigate("https://example.com/");
  w.run();
}

#ifdef _WIN32
  #include <Windows.h>

  int CALLBACK WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance, LPSTR lpCmdLine, int nShowCmd) {
    return main(__argc, __argv);
  }
#endif