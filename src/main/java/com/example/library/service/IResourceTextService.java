package com.example.library.service;

import com.example.library.dto.ResourceTextDTO;
import com.example.library.model.ResourceText;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;

public interface IResourceTextService {

    List<ResourceText> findAll();

    ResponseEntity<String>  reserveResource(String id);
    ResponseEntity<String> returnResource(String id);
    //public ResourceDTO findByID(String id) throws Exception;
    //public ResourceTextDTO save(ResourceTextDTO resourceTextDTO);
    //public ResourceDTO update(ResourceDTO resourceDTO);
    //public void deleteByID(String id) throws Exception;

}
