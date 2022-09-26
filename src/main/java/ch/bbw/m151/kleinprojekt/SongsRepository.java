package ch.bbw.m151.kleinprojekt;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface SongsRepository extends JpaRepository<SongsEntity, SongsID> {

    List<SongsEntity> findAllByTopYearIs(int topYear);

    List<SongsEntity> findAllByYearReleasedAfterAndId_TitleStartsWith(int year, String title);


    long deleteByTopYearIs(int topYear);

    Page<SongsEntity> findByTopYearIs(int topYear, Pageable pageable);

    @Query(value = "SELECT s.id.dur, s.id.title from songs s where s.id.title in :title")
    @Modifying
    List<Object> getByTitle(@Param("title") String title);

    @Query(value = "select s.artist_mb, s.country_mb ,s.listeners_lastfm, s2.title from ARTISTS as s inner join SONGS as S2 on s.ARTIST_MB = S2.ARTIST_MB", nativeQuery = true)
    List<Object> joinTwoTables();

}
