package com.onlineshop.alraeaei.services;

import com.onlineshop.alraeaei.models.Photo;
import com.onlineshop.alraeaei.repositories.PhotoRepository;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
@AllArgsConstructor
@Service
public class PhotoService {
    private final PhotoRepository photoRepository;


    public String saveImage(MultipartFile image) throws IOException {
        Photo img = new Photo(UUID.randomUUID().toString(), image.getContentType(),
                compressBytes(image.getBytes()));
        photoRepository.save(img);
        return img.getId();
    }
    public byte [] getImage(String imageId) throws NotFoundException {
        try {
            return decompressBytes(photoRepository.findById(imageId).get().getImage());
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Image Id " + imageId + " id not found!");
        }
    }
    public String updateImage(String imageId, MultipartFile image) throws IOException {
        photoRepository.deleteById(imageId);
        Photo img = new Photo(UUID.randomUUID().toString(), image.getContentType(),
                compressBytes(image.getBytes()));
        photoRepository.save(img);
        return img.getId();

    }
    public void deleteImage(String imageId){
        photoRepository.deleteById(imageId);
    }








    // compress the image bytes before storing it in the database
    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
        }
        return outputStream.toByteArray();
    }
    // uncompress the image bytes before returning it to the front-end application
    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException ioe) {
        } catch (DataFormatException e) {
        }
        return outputStream.toByteArray();
    }
}
