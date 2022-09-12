package ch.bbw.m151.kleinprojekt;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name = "songs")
public class SongsEntity {
    @EmbeddedId
    private SongsID id;
    @Column
    private String topGenre;
    @Column
    private int yearReleased;
    @Column
    private String dur;
    @Column
    private int topYear;
    @Column
    private String artist_type;

    public SongsID getId() {
        return id;
    }

    public String getTopGenre() {
        return topGenre;
    }

    public int getYearReleased() {
        return yearReleased;
    }

    public String getDur() {
        return dur;
    }

    public int getTop_year() {
        return topYear;
    }

    public String getArtist_type() {
        return artist_type;
    }
}


