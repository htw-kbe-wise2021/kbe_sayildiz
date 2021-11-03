package com.sayildiz.Songify.song.exceptions;

public class SongAlreadyExistsException extends RuntimeException{
    public SongAlreadyExistsException(Long id){
        super("already exists at Songify/songs/" + id);
    }
}

