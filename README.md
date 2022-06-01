<p align="center">
    <a href="https://github.com/PryosCode/Kanai/tags"><img alt="Version" src="https://img.shields.io/github/v/release/PryosCode/Kanai?label=Version"></a>
    <a href="https://github.com/PryosCode/Kanai/actions/workflows/windows.yml"><img alt="Windows" src="https://github.com/PryosCode/Kanai/actions/workflows/windows.yml/badge.svg"></a>
    <a href="https://github.com/PryosCode/Kanai/actions/workflows/macos.yml"><img alt="MacOS" src="https://github.com/PryosCode/Kanai/actions/workflows/macos.yml/badge.svg"></a>
    <a href="https://github.com/PryosCode/Kanai/actions/workflows/linux.yml"><img alt="Linux" src="https://github.com/PryosCode/Kanai/actions/workflows/linux.yml/badge.svg"></a>
    <a href="https://github.com/PryosCode/Kanai/blob/master/LICENSE"><img alt="License" src="https://img.shields.io/github/license/PryosCode/Kanai?label=License"></a>
</p>

# <a href="https://github.com/PryosCode/Kanai/blob/master/src/main/resources/img/icon.svg"><img src="https://github.com/PryosCode/Kanai/raw/master/src/main/resources/img/icon.png" alt="Icon" width="30" height="auto"></a> Kanai Editor

A hackable code editor.

## Download

[Releases](https://github.com/PryosCode/Kanai/releases)

## Plugins

```java
public class MyPlugin extends Plugin {

    @Override
    public void onEnable() {
        System.out.println("Hello World!");
    }

}
```

A full example can be found [here](https://github.com/PryosCode/Kanai/tree/master/sdk/src/test).

## Build

```bash
$ git clone https://github.com/PryosCode/Kanai.git
$ cd Kanai
$ chmod +x gradlew
$ ./gradlew build
```

## License

[Apache License 2.0](https://github.com/PryosCode/Kanai/blob/master/LICENSE)
