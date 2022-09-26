package ch.bbw.m151.kleinprojekt;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Entity(name = "artists")
public class ArtistsEntity {

    @Id
    private String artistMb;

    @OneToMany(mappedBy = "artist", fetch = FetchType.EAGER)
    private List<SongsEntity> songs;

    @Column
    private String countryMb;

    @Column
    private String listenersLastfm;


    public String getArtistMb() {
        return artistMb;
    }

    public List<SongsEntity> getSongs() {
        return songs;
    }

    public String getCountryMb() {
        return countryMb;
    }

    public String getListenersLastfm() {
        return listenersLastfm;
    }
}
