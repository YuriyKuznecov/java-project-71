.DEFAULT_GOAL := build-run

setup:
	./gradlew wrapper --gradle-version 8.7

clean:
	./gradlew clean

build:
	./app/gradlew build

install:
	./gradlew clean install

run-dist:
	./app/build/install/app/bin/app

run:
	./app/gradlew run

test:
	./app/gradlew test

report:
	./app/gradlew jacocoTestReport

lint:
	./app/gradlew checkstyleMain
	./app/gradlew checkstyleTest

check-deps:
	./gradlew dependencyUpdates -Drevision=release


build-run: build run

.PHONY: build
