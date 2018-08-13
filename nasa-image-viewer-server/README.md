# nasa-image-viewer-server

This is a Spring Boot application written with Java 8. It exposes a set of REST APIs that allow a user to retrieve images captured by the Mars rovers Opportunity, Curiousity, and Spirit via the NASA open API for the dates specified above.

When an image is requested, the application will check the cache to see if the image has already been downloaded, if it hasn't, it will request the image from NASA, save it to disk in the /tmp directory, and then serve that image back to the requestor. Caching of images is done by taking the src_url of the image returned from NASA and using it to generate a sha512 hash as the image file name and saving it to the /tmp directory.

This application can be run either as a stand alone jar file or in a Docker container.

## Exposed REST Endpoints

- GET list of dates: `/api/v1/dates`
  - http://localhost:8080/api/v1/dates
- GET list of rovers: `/api/v1/rovers`
  - http://localhost:8080/api/v1/rovers
- GET list of photos for a given date: `/api/v1/rovers/{name}/photos?{earth_date}`
  - http://localhost:8080/api/v1/rovers/opportunity/photos?earth_date=2018-06-02
- GET an individual photo: `/api/v1/rovers/{name}/photos/{id}?{img_src}`
  - http://localhost:8080/api/v1/rovers/Curiosity/photos/617694?img_src=http%3A%2F%2Fmars.jpl.nasa.gov%2Fmsl-raw-images%2Fmsss%2F01622%2Fmcam%2F1622MR0083260010801245I01_DXXX.jpg

### Prerequisites

- Java SDK 8
- Docker (only if you want to run as Docker container)

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

## Built With

* [Java 8](https://www.oracle.com/technetwork/java/javase/overview/java8-2100321.html) - Language
* [Spring Boot](https://spring.io/projects/spring-boot) - Servlet Container, Depency Injection, REST Framework, and much more
* [Gradle](https://gradle.org/) - Dependency Management and Build Tools
* [JUnit](https://junit.org/junit4/) - Testing framework
* [PMD](https://pmd.github.io/) - Static Analysis
* [Docker](https://www.docker.com/) - Container Platform
