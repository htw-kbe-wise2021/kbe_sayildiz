package com.sayildiz.Songify.song;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    @Bean
    CommandLineRunner initDatabase(SongRepository repository){
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            List<Song> songs = Arrays.asList(mapper.readValue(new File("./src/main/resources/songs.json"), Song[].class));
            Collections.sort(songs);
            songs.forEach(x ->log.info("loading songs " + repository.save(x)));
        };
    }
}
