.PHONY: all

all:
	cmake -S . -B build
	cmake --build build --config release