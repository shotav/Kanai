cmake_minimum_required(VERSION 3.0.0)
project(Kanai)

set(CPACK_RESOURCE_FILE_LICENSE ${CMAKE_CURRENT_SOURCE_DIR}/setup/license.rtf)

file(GLOB SOURCES "src/*.cpp")
add_executable(${PROJECT_NAME} WIN32 ${SOURCES})
set_property(TARGET ${PROJECT_NAME} PROPERTY CXX_STANDARD 11)

file(GLOB RESOURCES "res/**.*")
add_subdirectory(libs/cmrc)
cmrc_add_resource_library(resources ALIAS res::rc NAMESPACE res ${RESOURCES})
target_link_libraries(${PROJECT_NAME} PRIVATE res::rc)

file(GLOB LUA "libs/lua/*.c")
include_directories(libs/lua)
add_library(lua STATIC ${LUA})
target_link_libraries(${PROJECT_NAME} PRIVATE lua)

add_subdirectory(libs/glfw)
target_link_libraries(${PROJECT_NAME} PRIVATE glfw)

add_subdirectory(libs/glad)
target_link_libraries(${PROJECT_NAME} PRIVATE glad)

file(GLOB IMGUI "libs/imgui/*.cpp")
include_directories(libs/imgui libs/glfw/include)
add_library(imgui STATIC ${IMGUI} libs/imgui/backends/imgui_impl_glfw.cpp libs/imgui/backends/imgui_impl_opengl3.cpp)
target_link_libraries(${PROJECT_NAME} PRIVATE imgui)

add_subdirectory(libs/json)
target_link_libraries(${PROJECT_NAME} PRIVATE nlohmann_json)

add_subdirectory(libs/curl)
target_link_libraries(${PROJECT_NAME} PRIVATE libcurl)

include(CPack)