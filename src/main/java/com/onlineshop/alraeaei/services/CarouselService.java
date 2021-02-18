package com.onlineshop.alraeaei.services;

import com.onlineshop.alraeaei.dtos.CarouselImageDTO;
import com.onlineshop.alraeaei.models.CarouselImage;
import com.onlineshop.alraeaei.repositories.CarouselRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class CarouselService {
    CarouselRepository carouselRepository;
    PhotoService photoService;


    public CarouselImage addCarouselImage(MultipartFile image) throws IOException {
       return carouselRepository.save(new CarouselImage(photoService.saveImage(image)));
    }

    public CarouselImage updateCarouselImage(String carouselImageId, MultipartFile image) throws IOException {
        carouselRepository.deleteById(carouselImageId);
        return carouselRepository.save(new CarouselImage(photoService.updateImage(carouselImageId, image)));
    }

    public List<CarouselImage> getCarouselImages() {
        return carouselRepository.findAll();
    }

    public void deleteCarouselImage(String carouselImageId) {
        carouselRepository.deleteById(carouselImageId);
        photoService.deleteImage(carouselImageId);
    }
}
