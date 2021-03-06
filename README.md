## API Demo Application [![Build Status](https://travis-ci.com/misoboy/misoboy-api.svg?branch=master)](https://travis-ci.com/misoboy/misoboy-api) [![Coverage Status](https://coveralls.io/repos/github/misoboy/misoboy-api/badge.svg?branch=master)](https://coveralls.io/github/misoboy/misoboy-api?branch=master)


## Requirements
* Java 8+ above compatible

## Usage
1. Git clone
```bash
$ git clone https://github.com/misoboy/misoboy-api.git
```

2. Maven Build
```bash
$ export JAVA_HOME=Java Home Path
$ ./mvnw clean package
$ java -jar target/api-0.0.1-SNAPSHOT.jar
```

Alternatively, you can run the app directly without packaging it like so
```bash
$ ./mvnw spring-boot:run
```

Then open link in the browser [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## Unit testing
```bash
$ ./mvnw clean test
```

