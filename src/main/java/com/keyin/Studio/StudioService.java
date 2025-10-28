package com.keyin.Studio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudioService {

    @Autowired
    private StudioRepository studioRepository;

    public void saveNewStudio(Studio studio){
        studioRepository.save(studio);
    }
    public Iterable<Studio> getAllStudiosInSystem(){
        return studioRepository.findAll();
    }

}
