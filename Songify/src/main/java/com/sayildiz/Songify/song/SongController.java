package com.sayildiz.Songify.song;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/Songify")
public class SongController {
    //private final SongRepository repository;
    private final SongService songService;

    SongController(SongService songService){
        this.songService = songService;
    }

    /**
     * GET Request handling of Songs by ID
     * @return JSON with specific Song if correct request
     */
    @GetMapping("/songs/{id}")
    public Song getSongById(@PathVariable Long id){
        return songService.getSongById(id);
    }

    /**
     * GET request for all Songs
     * @return JSON with all Songs if correct request
     */
    @GetMapping("/songs")
    public List<Song> getSongs(){
        return songService.getAllSongs();
    }

    /**
     * POST request to add a song by JSON
     * @return 201 if correct request
     */
    @PostMapping("/songs")
    public ResponseEntity<?> postSong(@Validated @RequestBody Song newSong){
        if(newSong.getId() != null){
            return ResponseEntity.badRequest().body("Don't send a custom Id inside body");
        }
        Long newId = songService.addSong(newSong);
        return ResponseEntity.created(URI.create("/Songify/songs/" + newId)).build();
    }

    /**
     * DELETE Request to delete song by ID
     * @return HTTP Code 204
     */
    @DeleteMapping("/songs/{id}")
    public ResponseEntity<?> deleteSong(@PathVariable Long id){
        try{
            songService.deleteSongById(id);
            return ResponseEntity.noContent().build();
        }catch (EmptyResultDataAccessException e) {
            return ResponseEntity.noContent().build();
        }
    }
}
