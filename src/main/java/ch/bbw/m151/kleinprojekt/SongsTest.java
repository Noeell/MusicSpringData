package ch.bbw.m151.kleinprojekt;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SongsTest implements WithAssertions {

    @Autowired
    SongsRepository songsRepository;

    @Test
    void findAllByTopYear() {
        List<SongsEntity> songsEntities = songsRepository.findAllByTopYearIs(2000);

        for (SongsEntity song : songsEntities) {
            assertThat(song.getTop_year()).isEqualTo(2000);
        }
    }
}
