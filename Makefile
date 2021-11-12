.PHONY: all install build dev clean

all: install build

install:
	npm install --force

build:
	npx webpack --mode=production
	cabal build

dev:
	make -j 2 dev-serve dev-run

dev-serve:
	npx webpack serve --mode=development

dev-run:
	echo TODO

clean:
	rm -rf build
	rm -rf dist-newstyle
	rm -rf elm-stuff
	rm -rf node_modules
	rm -rf obj