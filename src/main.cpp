#include <string>
#include <imgui.h>
#include <backends/imgui_impl_glfw.h>
#include <backends/imgui_impl_opengl3.h>
#include "plugin.h"
#include "window.h"

const std::string VERSION = "0.1.0";

int main(int argc, char* argv[]) {
    std::string path = (argc > 1) ? argv[1] : "";

    plugin::load();
    GLFWwindow* window = window::setup();
    ImGui::CreateContext();
    ImGuiIO& io = ImGui::GetIO(); (void)io;
    ImGui::StyleColorsDark();   
    ImGui_ImplGlfw_InitForOpenGL(window, true);
    ImGui_ImplOpenGL3_Init("#version 330 core");
    while (!glfwWindowShouldClose(window)) {
        glfwPollEvents();
 
        ImGui_ImplOpenGL3_NewFrame();
        ImGui_ImplGlfw_NewFrame();
        ImGui::NewFrame();

        int width, height;
        glfwGetWindowSize(window, &width, &height);

        ImGui::SetNextWindowPos(ImVec2(0, 0));
        ImGui::SetNextWindowSize(ImVec2(width, height));
        ImGui::Begin("Plane", NULL, ImGuiWindowFlags_NoMove | ImGuiWindowFlags_NoBackground | ImGuiWindowFlags_NoTitleBar | ImGuiWindowFlags_NoResize);

        /*
        if (ImGui::BeginMenuBar()) {
            if (ImGui::BeginMenu("File")) {
                if (ImGui::MenuItem("New File")) {}
                if (ImGui::MenuItem("Open File")) {}
                if (ImGui::MenuItem("Open Folder")) {}
                ImGui::EndMenu();
            }
            if (ImGui::BeginMenu("Edit")) {
                if (ImGui::MenuItem("Undo")) {}
                if (ImGui::MenuItem("Redo")) {}
                ImGui::EndMenu();
            }
            ImGui::EndMenuBar();
        }
        */ 

        {
            ImGui::SetNextWindowPos(ImVec2(0, 0));
            ImGui::SetNextWindowSize(ImVec2(300, height));
            ImGui::BeginChild("File Hierarchy");
            ImGui::Text("File Hierarchy");
            ImGui::End();
        }

        {
            ImGui::SetNextWindowPos(ImVec2(300, 0));
            ImGui::SetNextWindowSize(ImVec2(width - 300, height));
            ImGui::BeginChild("Text Editor");
            ImGui::Text("Text Editor");
            ImGui::End();
        }

        ImGui::End();

        ImGui::Render();
        int display_w, display_h;
        glfwGetFramebufferSize(window, &display_w, &display_h);
        glViewport(0, 0, display_w, display_h);
        glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        glClear(GL_COLOR_BUFFER_BIT);
        ImGui_ImplOpenGL3_RenderDrawData(ImGui::GetDrawData());

        glfwSwapBuffers(window);
    }
    ImGui_ImplOpenGL3_Shutdown();
    ImGui_ImplGlfw_Shutdown();
    ImGui::DestroyContext();

    glfwDestroyWindow(window);
    glfwTerminate();
    return 0;
}

#ifdef _WIN32
    #include <Windows.h>

    int CALLBACK WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance, LPSTR lpCmdLine, int nShowCmd) {
        return main(__argc, __argv);
    }
#endif