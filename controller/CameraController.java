package com.example.cms.controller;

import com.example.cms.model.entity.Account;
import com.example.cms.model.entity.Camera;
import com.example.cms.model.repository.CameraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CameraController {

    @Autowired
    private final CameraRepository repository;

    public CameraController(CameraRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/cameras")
    List<Camera> retrieveAllCameras() {
        return repository.findAll();
    }

    @PostMapping("/cameras")
    Camera createcamera(@RequestBody Camera newCamera) {
        return repository.save(newCamera);
    }

}
