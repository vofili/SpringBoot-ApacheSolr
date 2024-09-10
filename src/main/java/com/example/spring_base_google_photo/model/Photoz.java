package com.example.spring_base_google_photo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Table("photos")
public class Photoz {
    @Id
    Integer id;

    String contentType;
    @NotEmpty
    String fileName;

    String description;

    @JsonIgnore
    byte[] rawData;


    public Photoz(){

    }
//    public Photoz(String id, String filename, String description, byte[] rawData) {
//        this.id = id;
//        this.filename = filename;
//        this.description = description;
//        this.rawData = rawData;
//    }

    public String getContentType() {

        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilename() {
        return fileName;
    }

    public void setFilename(String filename) {
        this.fileName = filename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getRawData() {
        return rawData;
    }

    public void setRawData(byte[] rawData) {
        this.rawData = rawData;
    }

    @Override
    public String toString() {
        return "Photoz{" +
                "id=" + id +
                ", filename='" + fileName + '\'' +
                ", description='" + description + '\'' +
                ", rawData='" + rawData + '\'' +
                '}';
    }
}
