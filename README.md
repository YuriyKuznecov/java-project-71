### Hexlet tests and linter status:
#### [![Actions Status](https://github.com/YuriyKuznecov/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/YuriyKuznecov/java-project-71/actions)
#### [![Maintainability](https://api.codeclimate.com/v1/badges/869990a3dcfaf8e27124/maintainability)](https://codeclimate.com/github/YuriyKuznecov/java-project-71/maintainability)
#### [![Test Coverage](https://api.codeclimate.com/v1/badges/869990a3dcfaf8e27124/test_coverage)](https://codeclimate.com/github/YuriyKuznecov/java-project-71/test_coverage)

## Проект представляет собой утилиту "genDiff" , которая сравнивает два файла из командной строки.Результат Выводится в 3 форматах: "stylish"(формат по умолчанию), "plain", "json.

#### Демонстрация вывода справки:
[![asciicast](https://asciinema.org/a/675112.svg)](https://asciinema.org/a/675112)
#### Демонстрация работы программы в режиме "stylish":
[![asciicast](https://asciinema.org/a/674885.svg)](https://asciinema.org/a/674885)
#### Демонстрация работы программы в режиме "plain":
[![asciicast](https://asciinema.org/a/674929.svg)](https://asciinema.org/a/674929)
#### Демонстрация работы прграммы в режиме "json":
[![asciicast](https://asciinema.org/a/675104.svg)](https://asciinema.org/a/675104)

## Setup

```bash
make -C app build
```

## Run tests

```bash
make -C app test
```

## Run checkstyle

```bash
make -C app lint
```

