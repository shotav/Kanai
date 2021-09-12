#include <string>
#include <iostream>
#include <CLI/CLI.hpp>
#include "window.h"

#ifdef _WIN32
    #include <Windows.h>
#endif

const std::string VERSION = "0.1.0";

int main(int argc, char* argv[]) {
    CLI::App app{"A lightweight cross-platform OpenGL text editor."};
    bool version{false};
    app.add_flag("-v,--version", version, "Print version");
    std::string path;
    app.add_option("PATH", path, "Path to open")->check(CLI::ExistingPath);
    CLI11_PARSE(app, argc, argv);
    if (version) {
        std::cout << "Kanai " << VERSION << std::endl;
        return 0;
    }

    #ifdef _WIN32
        FreeConsole();
    #endif

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