package com.sayildiz.Songify.song;

import com.sayildiz.Songify.song.exceptions.SongAlreadyExistsException;
import com.sayildiz.Songify.song.exceptions.SongNotFoundException;

import java.util.List;

public interface ISongService {
    /**
     * add a Song to Database
     * @param newSong new Song to be added
     * @return created Song Id
     * @throws SongAlreadyExistsException if song with Title and Artist already exists in Database
     */
    Long addSong(Song newSong);

    /**
     * delete a Song by Id from Database
     * (always returns 204 even if song doesn't exists)
     * @param id of Song
     */
    void deleteSongById(Long id);

    /**
     * get all Songs
     * @return List<Song> of all songs
     */
    List<Song> getAllSongs();

    /**
     * get a Song by Id
     * @param id of requested Song
     * @return Song
     * @throws SongNotFoundException if song not found
     */
    Song getSongById(Long id);

}
