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

# Example (using Postman)
  1. Upload image
     ![image](https://github.com/xKaiLee/ImageApp/assets/70294169/cd3c5014-1f7c-44a2-ab4f-f6a6825c87f0)
     ![image](https://github.com/xKaiLee/ImageApp/assets/70294169/5543d4eb-1321-4489-90a5-0cfc3a9aab07)
  2. Crop Image
     ![image](https://github.com/xKaiLee/ImageApp/assets/70294169/b35221a5-452f-44d5-a8c1-0e315c8ed3bc)
     ![image](https://github.com/xKaiLee/ImageApp/assets/70294169/df3ddf2d-0061-4ed9-b4db-d18379d00bdb)


  
