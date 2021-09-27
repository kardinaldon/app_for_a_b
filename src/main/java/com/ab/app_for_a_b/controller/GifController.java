package com.ab.app_for_a_b.controller;

import com.ab.app_for_a_b.model.giphy.GiphyModel;
import com.ab.app_for_a_b.service.GifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
public class GifController {

    @Autowired
    GifService gifService;

    @GetMapping(value = "/gif_controller"
            ,produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity getGif(){
        Optional<GiphyModel> gifUrl =  gifService.getGif();
        if(!gifUrl.isEmpty()) {
            Map<String,Object> response = ((Map<String,Object>)gifUrl.get().getGifDataModel()
                    .getImages()
                    .get("original"));
            return ResponseEntity.ok().body(response.get("url"));
        }
        else{
            return ResponseEntity.internalServerError().body("service is unavailable, contact the administrator");
        }
    }
}
