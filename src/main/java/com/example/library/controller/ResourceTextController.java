package com.example.library.controller;

import com.example.library.dto.ResourceTextDTO;
import com.example.library.model.ResourceText;
import com.example.library.service.ResourceTextServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/resources")
public class ResourceTextController {
    @Autowired
    private ResourceTextServiceImpl resourceTextService;
/*
    @PostMapping("/save")
    public ResponseEntity<ResourceTextDTO> save(@RequestBody ResourceTextDTO resourceTextDTO){
        return new ResponseEntity(resourceTextService.save(resourceTextDTO), HttpStatus.CREATED);
    }*/

    @GetMapping("/getAll")
    public List<ResourceText> findAll(){
        return resourceTextService.findAll();
    }

    @PutMapping("/reserveResource/{id}")
    public ResponseEntity<String>  reserveResource(@PathVariable("id") String id){
        return resourceTextService.reserveResource(id);
    }

    @PutMapping("/returnResource/{id}")
    public ResponseEntity<String> returnResource(@PathVariable("id") String id){
        return resourceTextService.returnResource(id);
    }


}
