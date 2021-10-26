cmake_minimum_required(VERSION 3.0.0)
project(Kanai)

file(GLOB SOURCES "src/main/*.cpp")
add_executable(${PROJECT_NAME} WIN32 ${SOURCES})
set_property(TARGET ${PROJECT_NAME} PROPERTY CXX_STANDARD 11)

include_directories(lib/webview)