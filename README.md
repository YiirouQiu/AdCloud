# AdCloud: An Advertisement Delivery & Retrieval System

## Project Description

AdCloud is a distributed advertisement delivery and retrieval system built using Spring Boot version 2.7.14 and Spring Cloud version 2021.0.8. The system utilizes Eureka server for service discovery and registration. Additionally, it leverages Spring Cloud OpenFeign and Spring Cloud Hystrix for providing fault tolerance and resilience.

This system facilitates the uploading, searching, and delivery of advertisements. Sponsors can upload the advertisements they want to deliver, and the system takes care of distributing, retrieving, and delivering the ads.

## Project Structure

The project directory structure is as follows:

- AdCloud (Project)
    - ad-eureka: This runs the Eureka server with configurations for three instances.
    - ad-gateway: This is the gateway responsible for routing incoming requests to appropriate services.
    - AdCloud-ad-service: This module contains the main functionalities of the system.
        - ad-common: This package contains common classes and utilities shared between the sponsor project and search project.
        - ad-dashboard: This module is responsible for providing a dashboard to monitor and manage the system.
        - ad-sponsor: This module handles the advertisement delivery functionality for sponsors.
        - ad-search: This module is responsible for advertisement retrieval and searching.

## Installation

To install the AdCloud project, follow these steps:

1. Ensure you have Maven installed on your system.
2. Clone the project repository from [GitHub link].
3. Open a terminal or command prompt and navigate to the project's root directory.
4. Run the following command to build and install the project:



Similarly, you can start other modules by running their respective jar files.

## Usage

The AdCloud project provides backend functionalities for advertisement delivery and retrieval. It does not have a frontend component. To interact with the system, you will need to use HTTP requests or integrate it with other applications.

For example, to upload an advertisement, you can send a POST request to the ad-sponsor module's endpoint. To retrieve advertisements, you can send GET requests to the ad-search module's endpoint.

For detailed usage instructions and API documentation, refer to the project's documentation or consult the respective module's source code.

Please note that this is a backend project, and frontend components need to be developed separately to interact with the system's functionalities.

If you have any questions or need further assistance, feel free to reach out!


