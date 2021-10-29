package com.sayildiz.Songify;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SongController {

    /**
     * GET Request handling of Songs by ID
     * @return JSON with specific Song if correct request
     */
    @GetMapping("/Songify/songs/{id}")
    public String getSongById(){
        return "notImplemented";
    }

    /**
     * GET request for all Songs
     * @return JSON with all Songs if correct request
     */
    @GetMapping("/Songify/songs")
    public String getSongs(){
        return "notImplemented";
    }

    /**
     * POST request to add a song by JSON
     * @return 201 if correct request
     */
    @PostMapping("/Songify/songs")
    public String postSong(){
        return "notImplemented";
    }

    /**
     * DELETE Request to delete song by ID
     * @return 204 if correct request
     */
    @DeleteMapping("/Songify/songs/{id}")
    public String deleteSong(){
        return "notImplemented";
    }
}
