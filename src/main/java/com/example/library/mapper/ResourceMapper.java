package com.example.library.mapper;

import com.example.library.dto.ResourceTextDTO;
import com.example.library.model.ResourceText;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ResourceMapper {

    public ResourceText fromDTO(ResourceTextDTO dto) {
        ResourceText resource = new ResourceText();
        resource.setId(dto.getId());
        resource.setTitle(dto.getTitle());
        resource.setSubject(dto.getSubject());
        resource.setType(dto.getType());
        resource.setFormat(dto.getFormat());
        resource.setDescription(dto.getDescription());
        resource.setAvailable(dto.isAvailable());
        resource.setBorrowTime(dto.getBorrowTime());

        return resource;
    }

    public ResourceTextDTO fromResource(ResourceText collection) {
        ResourceTextDTO empleadoDTO = new ResourceTextDTO();

        empleadoDTO.setId(collection.getId());
        empleadoDTO.setTitle(collection.getTitle());
        empleadoDTO.setSubject(collection.getSubject());
        empleadoDTO.setType(collection.getType());
        empleadoDTO.setFormat(collection.getFormat());
        empleadoDTO.setDescription(collection.getDescription());
        empleadoDTO.setAvailable(collection.isAvailable());
        empleadoDTO.setBorrowTime(collection.getBorrowTime());

        return empleadoDTO;
    }

    public List<ResourceTextDTO> fromCollectionList(List<ResourceText> collection) {
        if (collection == null) {
            return null;

        }
        List<ResourceTextDTO> list = new ArrayList(collection.size());
        Iterator listTracks = collection.iterator();

        while(listTracks.hasNext()) {
            ResourceText empleado = (ResourceText)listTracks.next();
            list.add(fromResource(empleado));
        }

        return list;
    }
}
