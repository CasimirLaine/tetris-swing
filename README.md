# Tetris Swing

<b>Java Swing</b> implementation of the popular <i>tetris</i> game using the [tetris-base](https://github.com/CasimirLaine/Tetris-Base) library.

## Documentation

- [User Manual](./docs/manual.md)
- [Project Architecture](./docs/architecture.md)
- [Test Document](./docs/testing.md)

## First steps

1. Clean build cache:

```bash
./gradlew clean
```

2. Build and fetch dependencies:

```bash
./gradlew build
```

## Run configurations

### Run

To run the program:

```bash
./gradlew run
```

### Testing

To run unit tests:

```bash
./gradlew test
```

### Generate Test Coverage

To generate and view test coverage:

1. Run tests:

```bash
./gradlew test
```

2. Generate coverage report:

```bash
./gradlew jacocoTestReport
```

3. View java-base test coverage:

```bash
./tetris-base/build/jacoco/html/index.html
```

### Generate Javadoc

To generate and view API documentation:

1. Generate Javadoc:

```bash
./gradlew javadoc
```

2. View the generated Javadoc:

```bash
./tetris-base/build/docs/javadoc/index.html
```
