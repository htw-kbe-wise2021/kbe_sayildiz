package com.sayildiz.Songify.song.exceptions;

public class SongNotFoundException extends RuntimeException{
    public SongNotFoundException(Long id){
        super("Could not find song with Id: " + id);
    }
}
