package com.sayildiz.Songify.song;

public class SongNotFoundException extends RuntimeException{
    SongNotFoundException(Long id){
        super("Could not find song with Id: " + id);
    }
}
