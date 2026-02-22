package org.photo.flickralbum.auth;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController
{

    @GetMapping("/")
    public String welcome(){
        return "welcome to code buffer";
    }
}
