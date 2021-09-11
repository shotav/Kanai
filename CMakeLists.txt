cmake_minimum_required(VERSION 3.0.0)
project(kanai CXX)

file(GLOB SOURCES "src/*.cpp")
add_executable(${PROJECT_NAME} ${SOURCES})
set_property(TARGET ${PROJECT_NAME} PROPERTY CXX_STANDARD 11)
target_compile_options(${PROJECT_NAME} PRIVATE -Wall)

add_subdirectory(libs/glfw EXCLUDE_FROM_ALL)
target_link_libraries(${PROJECT_NAME} PRIVATE glfw)

add_subdirectory(libs/glad)
target_link_libraries(${PROJECT_NAME} PRIVATE glad)

add_subdirectory(libs/freetype)
target_link_libraries(${PROJECT_NAME} PRIVATE freetype)

add_subdirectory(libs/json)
target_link_libraries(${PROJECT_NAME} PRIVATE nlohmann_json)

add_subdirectory(libs/curl)
target_link_libraries(${PROJECT_NAME} PRIVATE libcurl)