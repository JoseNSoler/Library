package com.example.library.service;


import com.example.library.model.ResourceText;
import com.example.library.repository.ResourceTextRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class ResourceTextServiceImpl implements IResourceTextService {

    @Autowired
    private ResourceTextRepository resourceTextRepository;

    @Override
    public List<ResourceText> findAll() {

        return resourceTextRepository.findAll();
    }

    @Override
    public ResponseEntity<String> reserveResource(String id) {
        return resourceTextRepository.findById(id).map((resource) -> {
            System.out.println(resource);
            if(resource.isAvailable()) {
                resource.setAvailable(false);
                resource.setBorrowTime(new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z").format(new Date()));
                resourceTextRepository.save(resource);
                return new ResponseEntity("Se presto el recurso" + resource, HttpStatus.ACCEPTED);
                //new ResponseEntity(resource + " fue prestado", HttpStatus.ACCEPTED);
            };
           // new ResponseEntity(resource + " no puede ser prestado", HttpStatus.ACCEPTED);
            return new ResponseEntity("NO SE PRESTO EL RECURSO, YA ESTA PRESTADO!!" + resource, HttpStatus.ACCEPTED);

        }).get();
    }

    @Override
    public ResponseEntity<String> returnResource(String id) {
        return resourceTextRepository.findById(id).map((resource) -> {
            System.out.println(resource);
            if(!resource.isAvailable()) {
                resource.setAvailable(true);
                resource.setBorrowTime(new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z").format(new Date()));
                resourceTextRepository.save(resource);
                return new ResponseEntity("Se a devuelto el recurso exitosamente" + resource, HttpStatus.ACCEPTED);
                //new ResponseEntity(resource + " fue prestado", HttpStatus.ACCEPTED);
            };
            // new ResponseEntity(resource + " no puede ser prestado", HttpStatus.ACCEPTED);
            return new ResponseEntity("NO SE PUEDE DEVOLVER EL RECURSO, ESTE NO ESTA PRESTADO!!" + resource, HttpStatus.ACCEPTED);

        }).get();
    }







    /*
    @Override
    public ResourceTextDTO save(ResourceTextDTO resourceTextDTO) {
        resourceTextDTO.setAvailable(true);
        ResourceText resourceText = resourceTextMapper.fromDTO(resourceTextDTO);
        return resourceTextMapper.fromResourceText(
                resourceTextRepository.save(resourceText)
        );
    }

     */
}
