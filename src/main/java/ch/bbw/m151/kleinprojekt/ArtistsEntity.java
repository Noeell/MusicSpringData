package ch.bbw.m151.kleinprojekt;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "artists")
public class ArtistsEntity {

    @Id
    private String artistMb;

    @OneToMany(mappedBy = "artist")
    private List<SongsEntity> songs;

    @Column
    private String countryMb;

    @Column
    private String listenersLastfm;

}
