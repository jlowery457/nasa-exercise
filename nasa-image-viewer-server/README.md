# nasa-image-viewer-server

project description

### Prerequisites

Java SDK 8
Docker (only if you want to run as Docker container)

### Installing

- Clone or download this repository
- Enter your local directory, and build for first time

```bash
./gradlew build
```
This will download all dependencies needed, run the tests, and generate a jar file.

## Running the tests

There are a variety of unit and integration tests in the project.  They can be run outside of a build via:

```bash
./gradlew test
```

## Build

### Build as a jar
To build the application as a stand alone jar file, run the following command:

```bash
./gradlew build
```

### Build as a Docker container
To build the jar and packge up in a Docker container, run the following command:

```bash
./gradlew docker
```

## Running as a stand alone jar

After running `.gradlew build`, a jar file named `nasa-image-viewer-server-0.0.1-SNAPSHOT.jar` will be located in the `build/libs` directory.
To run the jar from the root of the project, use the following command:

```bash
java -jar build/libs/nasa-image-viewer-server-0.0.1-SNAPSHOT.jar
```

Spring Boot will start up the server at port **8080**.  The APIs will be accessible at `http://localhost:8080`

## Running in a Docker container

After running `./gradlew docker`, run the following command to start the docker container:

```bash
docker run -p 8080:8080 -t jlowery/nasa-image-viewer-server -d
```

Spring Boot will start up the server in the Docker container at port **8080**.  The APIs will be accessible at `http://localhost:8080`
