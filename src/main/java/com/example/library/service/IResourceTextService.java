package com.example.library.service;

import com.example.library.dto.ResourceTextDTO;
import com.example.library.model.ResourceText;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface IResourceTextService {

    List<ResourceTextDTO> findAll();

    ResponseEntity<String>  reserveResource(String id);
    ResponseEntity<String> returnResource(String id);
    List<ResourceTextDTO> recommendedResource(String type, String subject);

    ResourceTextDTO save(ResourceTextDTO resourceTextDTO);
    ResourceTextDTO getById(String id);
    ResourceTextDTO deleteById(String id);


}
