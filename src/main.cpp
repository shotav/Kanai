#include <iostream>
#include "resource.h"
#include "window.h"

int main(int argc,char *argv[]) {
    std::cout << resource::load("res/test.txt") << std::endl;

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