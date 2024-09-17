package com.example.spring_base_google_photo.web;

import com.example.spring_base_google_photo.model.Photoz;
import com.example.spring_base_google_photo.service.PhotozService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import java.io.IOException;
import java.util.*;

@RestController
public class PhotozController {


    private final PhotozService photoService;

    public PhotozController(PhotozService photoService){
        this.photoService = photoService;
    }

    @GetMapping("/")
    public String returnGreeting(){
        return "Hello World";
    }


    @GetMapping("/photos")
    public Iterable<Photoz> getPhotoz(){
        Iterable<Photoz> photozlist =new ArrayList<>();
        photozlist = photoService.get();
        return photozlist;
    }

    @GetMapping("/photos/{id}")
    public Photoz getPhotozById(@PathVariable Integer id){
       Photoz result = photoService.get(id);
       if (result == null){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND);
       }
       return result;
    }

    @DeleteMapping("/photos/{id}")
    public Photoz deletePhoto(@PathVariable Integer id){
        Photoz photo = photoService.get(id);
        if(photo == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else{
            photoService.remove(id);
        }
        return photo;
    }

    @PostMapping("/photos")
    public Photoz createPhoto(@RequestBody @Valid Photoz photo){
        //photo.setId(UUID.randomUUID().toString());
        photoService.save(photo.getFileName(),photo.getContentType(),photo.getRawData());
        return photo;
    }


    @PostMapping("/photos/upload")
    public Photoz createPhotoFromFile(@RequestPart("data") MultipartFile file) throws IOException {
        Photoz photo = new Photoz();
        photo = photoService.save(file.getOriginalFilename(), file.getContentType(),file.getBytes());
        return photo;
    }


}
