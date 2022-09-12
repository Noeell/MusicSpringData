package ch.bbw.m151.kleinprojekt;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SongsID implements Serializable {
    private String title;
    private String artist;
    private String added;
}


