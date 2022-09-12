package ch.bbw.m151.kleinprojekt;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongsRepository extends JpaRepository<SongsEntity, SongsID> {

    List<SongsEntity> findAllByTopYearIs(int topYear);
}
