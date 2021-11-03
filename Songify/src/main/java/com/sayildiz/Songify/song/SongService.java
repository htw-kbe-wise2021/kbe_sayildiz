package com.sayildiz.Songify.song;

import com.sayildiz.Songify.song.exceptions.SongAlreadyExistsException;
import com.sayildiz.Songify.song.exceptions.SongNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService{
    private final SongRepository repository;

    public SongService(SongRepository repository) {
        this.repository = repository;
    }


    @Override
    public Long addSong(Song newSong) {
        if(repository.existsByTitleAndArtist(newSong.getTitle(), newSong.getArtist())){
            Long existingId = repository.findByTitle(newSong.getTitle()).getId();
            throw new SongAlreadyExistsException(existingId);
        }
        return repository.save(newSong).getId();
    }

    @Override
    public void deleteSongById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Song> getAllSongs() {
        return repository.findAll();
    }

    @Override
    public Song getSongById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new SongNotFoundException(id));
    }
}
