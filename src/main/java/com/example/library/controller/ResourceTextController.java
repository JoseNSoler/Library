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
import java.util.Set;

@RestController
@RequestMapping("/resources")
public class ResourceTextController {
    @Autowired
    private ResourceTextServiceImpl resourceTextService;

    @PostMapping("/save")
    public ResponseEntity<ResourceTextDTO> save(@RequestBody ResourceTextDTO resourceTextDTO){
        return new ResponseEntity(resourceTextService.save(resourceTextDTO), HttpStatus.CREATED);
    }

    @GetMapping("/getByID/{id}")
    public ResponseEntity<ResourceTextDTO> getById(@PathVariable("id") String id){
        return new ResponseEntity(resourceTextService.getById(id), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteByID/{id}")
    public ResponseEntity<ResourceTextDTO> deleteById(@PathVariable("id") String id){
        return new ResponseEntity(resourceTextService.deleteById(id), HttpStatus.CREATED);
    }


    @GetMapping("/getAll")
    public List<ResourceTextDTO> findAll(){
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


    @GetMapping("/getRecommended/query")
    public List<ResourceTextDTO> recommendedResource(
            @RequestParam("type") Optional<String> type,
            @RequestParam("subject") Optional<String> subject
    ){
        if(type.isPresent() && subject.isPresent())
            return resourceTextService.recommendedResource(type.get(), subject.get());
        if(type.isPresent() && !(subject.isPresent()))
            return resourceTextService.recommendedResource(type.get(), null);
        if(!(type.isPresent()) && subject.isPresent()){
            return resourceTextService.recommendedResource(null, subject.get());
        }

        return null;
    }



}
