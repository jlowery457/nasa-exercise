# nasa-excercise

This project is a coding exercise with the following parameters:

Using the API described here (https://api.nasa.gov/api.html ) build a project in GitHub that calls the Mars Rover API and selects a picture on a given day. We want your application to download and store each image locally.  
 
### Acceptance Criteria
* Use list of dates below to pull the images were captured on that day by reading in a .txt file
  * 02/27/17
  * June 2, 2018
  * Jul-13-2016
  * April 31, 2018
* Language should be C#, Python, Java, and/or JavaScript
* We should be able to build it locally after you submit it
* Include relevant documentation (.MD, etc) in the Repo
* Bonus -  Automated Test, Static Analysis and Performance test or other things you feel are important for DoD
* Double Bonus  - Create a Web Application that Displays the image in a Browser
* Triple Bonus – It runs in Docker or another container

## Scope of Solution

There are two projects included in this solution.  A backend server named **nasa-image-viewer-server** and a frontend web client named **nasa-image-viewer-client**.

Information regarding building, testing, and running each project are in the README documents located in the root of each respective project.

### nasa-image-viewer-server

This is a Spring Boot application written with Java 8.  It exposes a set of REST APIs that allow a user to retrieve images captured by the Mars rovers Opportunity, Curiousity, and Spirit via the NASA open API for the dates specified above.  **Please note that April 31, 2018 is an invalid date.  The server logs an error when parsing this date and excludes it from the list.**

When an image is requested, the application will check the cache to see if the image has already been downloaded, if it hasn't, it will request the image from NASA, save it to disk in the /tmp directory, and then serve that image back to the requestor.  Caching of images is done by taking the src_url of the image returned from NASA and using it to generate a sha512 hash as the image file name and saving it to the /tmp directory.

This application can be run either as a stand alone jar file or in a Docker container.

#### Known Limitations and Areas for Improvement

* There is currently not a mechanism in this solution to manage the size of the cache.
* Make the size of the cache high water mark configurable.
* Make the location of the cache configurable.
* Make the NASA API key configurable.
* Handling HTTP 302 Redirects from http to https.  A handful of the images that are served by the NASA API return an HTTP 302 redirect from a non-secure url (http://) to a secure (https://) url.  The Jersey Client used to communicate with the NASA API will automatically follow redirects, but not when the url scheme changes.  Currently, this solution does not handle this situation.

### nasa-image-viewer-client

This is a Vue.js single page application using Element UI for presentation and Axios for HTTP requests to the backend.
