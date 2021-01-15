package com.onlineshop.alraeaei.controllers;
import com.onlineshop.alraeaei.services.PhotoService;
import javassist.NotFoundException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
@CrossOrigin("*")
@RestController
@RequestMapping("images")
public class PhotoController {
    private final PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping(value = "/{id}", produces =  MediaType.IMAGE_JPEG_VALUE)
    public byte[] showImage(@PathVariable("id") String id) throws NotFoundException {
        return photoService.getImage(id);
    }


}
