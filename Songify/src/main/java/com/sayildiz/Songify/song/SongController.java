package com.sayildiz.Songify.song;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
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
    public ResponseEntity<?> postSong(@Validated @RequestBody Song newSong){
        if(repository.existsByTitleAndArtist(newSong.getTitle(), newSong.getArtist())){
            Long existingId = repository.findByTitle(newSong.getTitle()).getId();
            return ResponseEntity.status(HttpStatus.CONFLICT).body("already exists at Songify/songs/" + existingId);
        }
        Long newId = repository.save(newSong).getId();
        return ResponseEntity.created(URI.create("/Songify/songs/" + newId)).build();
    }

    /**
     * DELETE Request to delete song by ID
     * @return HTTP Code 204
     */
    @DeleteMapping("/Songify/songs/{id}")
    public ResponseEntity<?> deleteSong(@PathVariable Long id){
        try{
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }catch (EmptyResultDataAccessException e) {
            return ResponseEntity.noContent().build();
        }
    }
}
