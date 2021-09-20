.PHONY: all windows

all:
	cmake -S . -B build
	cmake --build build --config release

windows: all
	cd build && cpack -G WIX -C Release