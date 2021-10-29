package com.sayildiz.Songify.song;

import com.sayildiz.Songify.song.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
