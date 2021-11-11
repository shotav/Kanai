.PHONY: all install build dev clean

all: install build

install:
	npm install --force

build:
	npx webpack --mode=production
	dotnet publish -c Release -r linux-x64 --self-contained

dev:
	make -j 2 dev-serve dev-run

dev-serve:
	npx webpack serve --mode=development

dev-run:
	dotnet watch run -c Debug

clean:
	rm -rf bin
	rm -rf build
	rm -rf elm-stuff
	rm -rf node_modules
	rm -rf obj