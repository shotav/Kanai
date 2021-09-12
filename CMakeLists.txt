cmake_minimum_required(VERSION 3.0.0)
project(kanai)

file(GLOB SOURCES "src/*.cpp")
add_executable(${PROJECT_NAME} WIN32 ${SOURCES})
set_property(TARGET ${PROJECT_NAME} PROPERTY CXX_STANDARD 11)

file(GLOB RESOURCES "res/**.*")
add_subdirectory(libs/cmrc)
cmrc_add_resource_library(resources ALIAS res::rc NAMESPACE res ${RESOURCES})
target_link_libraries(${PROJECT_NAME} PRIVATE res::rc)

add_subdirectory(libs/cli11)
target_link_libraries(${PROJECT_NAME} PRIVATE CLI11)

file(GLOB LUA "libs/lua/*.c")
include_directories(libs/lua)
add_library(lua STATIC ${LUA})
target_link_libraries(${PROJECT_NAME} PRIVATE lua)

add_subdirectory(libs/glfw)
target_link_libraries(${PROJECT_NAME} PRIVATE glfw)

add_subdirectory(libs/glad)
target_link_libraries(${PROJECT_NAME} PRIVATE glad)

add_subdirectory(libs/glm)
target_link_libraries(${PROJECT_NAME} PRIVATE glm)

add_subdirectory(libs/freetype)
target_link_libraries(${PROJECT_NAME} PRIVATE freetype)

add_subdirectory(libs/json)
target_link_libraries(${PROJECT_NAME} PRIVATE nlohmann_json)

add_subdirectory(libs/curl)
target_link_libraries(${PROJECT_NAME} PRIVATE libcurl)