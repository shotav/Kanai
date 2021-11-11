.PHONY: all install build dev clean

all: install build

install:
	npm install

build:
	npx webpack --mode=production
	dotnet build --configuration Release

dev:
	npx webpack --mode=development
	dotnet run --configuration Debug

clean:
	rm -rf bin
	rm -rf build
	rm -rf elm-stuff
	rm -rf node_modules
	rm -rf obj