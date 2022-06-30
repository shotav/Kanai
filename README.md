<p align="center">
    <a href="https://github.com/shotav/Kanai/tags"><img alt="Version" src="https://img.shields.io/github/v/release/shotav/Kanai?label=Version"></a>
    <a href="https://github.com/shotav/Kanai/actions/workflows/windows.yml"><img alt="Windows" src="https://github.com/shotav/Kanai/actions/workflows/windows.yml/badge.svg"></a>
    <a href="https://github.com/shotav/Kanai/actions/workflows/macos.yml"><img alt="MacOS" src="https://github.com/shotav/Kanai/actions/workflows/macos.yml/badge.svg"></a>
    <a href="https://github.com/shotav/Kanai/actions/workflows/linux.yml"><img alt="Linux" src="https://github.com/shotav/Kanai/actions/workflows/linux.yml/badge.svg"></a>
    <a href="https://github.com/shotav/Kanai/blob/master/LICENSE"><img alt="License" src="https://img.shields.io/github/license/shotav/Kanai?label=License"></a>
</p>

# <a href="https://github.com/shotav/Kanai/blob/master/src/main/resources/icon/icon.svg"><img src="https://github.com/shotav/Kanai/raw/master/src/main/resources/icon/icon.png" alt="Icon" width="30" height="auto"></a> Kanai Editor

A hackable code editor.

## Download

[Releases](https://github.com/shotav/Kanai/releases)

## Plugins

```java
public class MyPlugin extends Plugin {

    @Override
    public void onEnable() {
        System.out.println("Hello World!");
    }

}
```

A full example can be found [here](https://github.com/shotav/Kanai/tree/master/api/src/test).

## Build

```bash
$ git clone https://github.com/shotav/Kanai.git
$ cd Kanai
$ chmod +x gradlew
$ ./gradlew build
```

## License

[Apache License 2.0](https://github.com/shotav/Kanai/blob/master/LICENSE)
