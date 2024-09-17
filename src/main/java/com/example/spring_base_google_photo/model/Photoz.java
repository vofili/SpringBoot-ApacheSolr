package com.example.spring_base_google_photo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Getter
@Setter
public class Photoz {

    @Id
    @SequenceGenerator(name="photos_sequence",sequenceName="photos_sequence")
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="photos_sequence")
    Integer id;

    String contentType;
    @NotEmpty
    String fileName;
    String description;
    @JsonIgnore
    byte[] rawData;


    public String getContentType() {

        return contentType;
    }


}
