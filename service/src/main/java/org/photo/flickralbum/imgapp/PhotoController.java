package org.photo.flickralbum.imgapp;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhotoController {

    @GetMapping
    public String getPhotos(){
        return "photos";
    }
}
