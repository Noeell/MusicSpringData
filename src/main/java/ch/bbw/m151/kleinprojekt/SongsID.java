package ch.bbw.m151.kleinprojekt;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SongsID implements Serializable {
    private String title;
    private String added;
    private String dur;

    public String getTitle() {
        return title;
    }

    public String getAdded() {
        return added;
    }

    public String getDur() {
        return dur;
    }
}


