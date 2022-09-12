package ch.bbw.m151.kleinprojekt;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "artists")
public class ArtistsEntity {

    @Id
    private String mbid;

    @Column(columnDefinition = "LONGTEXT")
    private String artistMb;

    @Column
    private String countryMb;

    @Column
    private String listenersLastfm;

}
