package com.example.spring_base_google_photo.service;


import com.example.spring_base_google_photo.model.Photoz;
import com.example.spring_base_google_photo.repository.PhotoRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PhotozService {
    private final PhotoRepository photoRepository;
//    Map<String, Photoz> db;
//    public PhotozService(){
//        db=new HashMap<>(){{
//            put("1", new Photoz("1","helloworld.jpg","photo of the world",null));
//
//            put("2", new Photoz("2","hellodolphin.jpg","photo of grey dolphin",null));
//        }};
//    }


    public PhotozService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public Photoz get(Integer id){
        return photoRepository.findById(id).orElse(null);
    }

    public void remove(Integer id){
         photoRepository.deleteById(id);
    }

    public Photoz save(String fileName,String contentType,byte[] data) {
        Photoz newPhoto = new Photoz();
        newPhoto.setFilename(fileName);
        newPhoto.setRawData(data);
        newPhoto.setContentType(
                contentType
        );
        newPhoto.setDescription("");
       photoRepository.save(newPhoto);
        return newPhoto;
    }

    public Iterable<Photoz> get() {
        return photoRepository.findAll();
    }
}
