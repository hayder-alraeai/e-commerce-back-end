package com.onlineshop.alraeaei.controllers;

import com.onlineshop.alraeaei.dtos.CarouselImageDTO;
import com.onlineshop.alraeaei.models.CarouselImage;
import com.onlineshop.alraeaei.services.CarouselService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/carousel-images")
@AllArgsConstructor
public class CarouselImageController {
    CarouselService carouselService;

    @PostMapping
    public CarouselImage addCarouselImage(@RequestParam("image") MultipartFile image) throws IOException {
        return carouselService.addCarouselImage(image);
    }
    @PostMapping("/{carouselImageId}")
    public CarouselImage updateCarouselImage(@PathVariable("carouselImageId") String carouselImageId, @RequestParam("image") MultipartFile image) throws IOException {
        return carouselService.updateCarouselImage(carouselImageId, image);
    }
    @GetMapping
    public List<CarouselImage> getCarouselImages(){
        return carouselService.getCarouselImages();
    }
    @DeleteMapping("/{carouselImageId}")
    public void deleteCarouselImage(@PathVariable("carouselImageId") String carouselImageId){
        carouselService.deleteCarouselImage(carouselImageId);
    }


}
