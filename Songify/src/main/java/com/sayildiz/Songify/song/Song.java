package com.sayildiz.Songify.song;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Song implements Comparable<Song>{
    private @Id
    @GeneratedValue Long id;
    private String title;
    private String artist;
    private String label;
    private int released;

    public Song(Long id, String title, String artist, String label, int released) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.label = label;
        this.released = released;
    }

    public Song() {

    }


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getLabel() {
        return label;
    }

    public int getReleased() {
        return released;
    }


    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", label='" + label + '\'' +
                ", released=" + released +
                '}';
    }

    @Override
    public int compareTo(Song o) {
        return Long.compare(this.id, o.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return released == song.released && Objects.equals(id, song.id) && Objects.equals(title, song.title) && Objects.equals(artist, song.artist) && Objects.equals(label, song.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, artist, label, released);
    }
}
