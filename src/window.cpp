#include "window.h"

namespace window {

    const GLuint WIDTH = 1280, HEIGHT = 720;

    void key_callback(GLFWwindow* window, int key, int scancode, int action, int mode) {
        if (key == GLFW_KEY_ESCAPE && action == GLFW_PRESS)
            glfwSetWindowShouldClose(window, GL_TRUE);
    }

    GLFWwindow* setup() {
        glfwInit();
        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);

        GLFWwindow* window = glfwCreateWindow(WIDTH, HEIGHT, "Kanai", NULL, NULL);
        glfwMakeContextCurrent(window);

        glfwSetKeyCallback(window, key_callback);
        glfwSwapInterval(1);

        GLFWimage icons[1];
        // icons[0].pixels = ;
        glfwSetWindowIcon(window, 1, icons);

        gladLoadGLLoader((GLADloadproc) glfwGetProcAddress);

        glViewport(0, 0, WIDTH, HEIGHT);

        return window;
    }

}