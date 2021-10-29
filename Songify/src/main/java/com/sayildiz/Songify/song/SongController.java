package com.sayildiz.Songify.song;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SongController {
    private final SongRepository repository;

    SongController(SongRepository repository){
        this.repository = repository;
    }

    /**
     * GET Request handling of Songs by ID
     * @return JSON with specific Song if correct request
     */
    @GetMapping("/Songify/songs/{id}")
    public Song getSongById(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new SongNotFoundException(id));
    }

    /**
     * GET request for all Songs
     * @return JSON with all Songs if correct request
     */
    @GetMapping("/Songify/songs")
    public List<Song> getSongs(){
        return repository.findAll();
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
