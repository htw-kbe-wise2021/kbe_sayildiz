package com.sayildiz.Songify.song;

import com.sayildiz.Songify.song.exceptions.SongAlreadyExistsException;
import com.sayildiz.Songify.song.exceptions.SongNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class SongControllerAdvice {
    @ResponseBody
    @ExceptionHandler(SongNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String songNotFoundHandler(SongNotFoundException ex){
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(SongAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String songAlreadyExistsHandler(SongAlreadyExistsException ex) { return ex.getMessage();}
}
