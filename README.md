## API Demo Application


## Requirements
* Java 8+ above compatible

## Usage
1. Git clone
```bash
$ git clone 블라블라
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

## Unit testing
```bash
$ ./mvnw clean test
```

