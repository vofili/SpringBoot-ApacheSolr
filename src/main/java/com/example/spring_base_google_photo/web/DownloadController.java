package com.example.spring_base_google_photo.web;


import com.example.spring_base_google_photo.model.Photoz;
import com.example.spring_base_google_photo.service.PhotozService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DownloadController {

    private final PhotozService photoService;

    public DownloadController(PhotozService photoService){
        this.photoService=photoService;
    }

    @GetMapping("download/{id}")
    public ResponseEntity<byte[]> downloadPhoto(@PathVariable Integer id){
        Photoz photo = photoService.get(id);
        byte[] data=photo.getRawData();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(photo.getContentType()));
        headers.setContentDisposition(ContentDisposition.builder("attachment")
                        .filename(photo.getFilename())
                .build());

        return new ResponseEntity(data,headers, HttpStatus.OK);
    }

}
