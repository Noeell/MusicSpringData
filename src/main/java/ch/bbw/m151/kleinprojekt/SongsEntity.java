package ch.bbw.m151.kleinprojekt;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import javax.transaction.Transactional;

@Transactional
@Entity(name = "songs")
public class SongsEntity {
    @EmbeddedId
    private SongsID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "ARTIST_MB")
    private ArtistsEntity artist;
    @Column
    private String topGenre;
    @Column
    private int yearReleased;
    @Column
    private int topYear;
    @Column
    private String artist_type;

    public SongsID getId() {
        return id;
    }

    public ArtistsEntity getArtist() {
        return artist;
    }

    public String getTopGenre() {
        return topGenre;
    }

    public int getYearReleased() {
        return yearReleased;
    }

    public int getTop_year() {
        return topYear;
    }

    public String getArtist_type() {
        return artist_type;
    }
}


