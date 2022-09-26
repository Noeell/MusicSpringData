package ch.bbw.m151.kleinprojekt;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

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

    @Test
    void selectWithTwoWhere() {
        List<SongsEntity> songsEntities = songsRepository.findAllByYearReleasedAfterAndId_TitleStartsWith(2010, "Tal");

        for (SongsEntity song : songsEntities) {
            assertThat(song.getYearReleased()).isGreaterThan(2010);
            assertThat(song.getId().getTitle()).startsWith("Tal");
        }
    }

    @Test
    void deleteByTopYear() {
        songsRepository.deleteByTopYearIs(2010);
        List<SongsEntity> allSongs = songsRepository.findAll();

        for (SongsEntity song : allSongs) {
            assertThat(song.getTop_year()).isNotEqualTo(2010);
        }
    }

    @Test
    void selectWithPaging() {
        Pageable pageable = PageRequest.of(0, 5);
        Page<SongsEntity> songsEntityPage = songsRepository.findByTopYearIs(2010, pageable);
        List<SongsEntity> allSongsWithTopYear = songsRepository.findAllByTopYearIs(2010);

        assertThat(songsEntityPage.getSize()).isEqualTo(5);
        assertThat(songsEntityPage.stream().findFirst().get().getId().getTitle()).isEqualTo(allSongsWithTopYear.get(0).getId().getTitle());
    }

    @Test
    void joinTwoTables() {
        List<Object> list = songsRepository.joinTwoTables();
        Object result = list.get(0);
        Object[] expectedResult = new Object[]{"Justin Timberlake", "United States", "2821887", "Mirrors"};

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void query() {
        List<Object> starvingList = songsRepository.getByTitle("Starving");

        assertThat(starvingList.size()).isEqualTo(1);

        List<Object> noEntries = songsRepository.getByTitle("Starv");

        assertThat(noEntries.size()).isEqualTo(0);
    }

   /* @Test
    void sqlInjection(){
        List list = nativeQueryService.findAllSongsByTitle("'' OR 1=1");
        System.out.println(list.size());
    }*/
}
