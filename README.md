## IN PROGRESS
# Image Editing App with Spring Boot

# Project Goal
The goal of this project is to create an application for remote image editing using Spring Boot.

# Task Details
  1. POST /image
     - Accepts an image in binary format.
     - Saves the image in the application's memory.
     - Returns a unique identifier.
  2.DELETE /image/{id}
     - Deletes the image with the given identifier {id} from the application's memory.
  3. GET /image/{id}/size
     - Returns data in JSON format with the dimensions of the loaded image.
  4. GET /image/{id}/histogram
     - Returns data in JSON format containing the histogram of the image.
  5. GET /image/{id}/crop
      - Returns a cropped image.
