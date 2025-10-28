package com.keyin.Studio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class StudioController {
    @Autowired
    private StudioService studioService;

    @PostMapping("/addStudio")
    public void saveNewStudio(Studio studio){
        studioService.saveNewStudio(studio);
    }

    @GetMapping("getAllStudios")
    public Iterable<Studio> getAllStudios(){
        return studioService.getAllStudiosInSystem();
    }



}
