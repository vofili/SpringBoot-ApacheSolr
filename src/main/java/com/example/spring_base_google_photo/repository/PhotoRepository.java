package com.example.spring_base_google_photo.repository;

import com.example.spring_base_google_photo.model.Photoz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends CrudRepository<Photoz,Integer> {
}
