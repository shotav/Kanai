#include <string>
#include "window.h"

const std::string VERSION = "0.1.0";

int main(int argc, char* argv[]) {
    std::string path = (argc > 1) ? argv[1] : "";

    GLFWwindow* window = window::setup();
    while (!glfwWindowShouldClose(window)) {
        glfwPollEvents();

        glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
        glClear(GL_COLOR_BUFFER_BIT);

        glfwSwapBuffers(window);
    }

    glfwTerminate();
    return 0;
}

#ifdef _WIN32
    #include <Windows.h>

    int CALLBACK WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance, LPSTR lpCmdLine, int nShowCmd) {
        return main(__argc, __argv);
    }
#endif