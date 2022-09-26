package ch.bbw.m151.kleinprojekt;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongsService {

    private final SongsRepository repository;

    public SongsService(SongsRepository repository) {
        this.repository = repository;
    }

    public List<SongsEntity> findAllByTopYearIs(int topYear) {
        return repository.findAllByTopYearIs(topYear);
    }

    public List<SongsEntity> findAllByYearReleasedAfterAndTitleStartsWith(int year, String title) {
        return repository.findAllByYearReleasedAfterAndId_TitleStartsWith(year, title);
    }

    public long deleteByTopYear(int topYear) {
        return repository.deleteByTopYearIs(topYear);
    }

    Pageable pageable = PageRequest.of(0, 5);

    public Page<SongsEntity> findByTopYearIsPageable(int topYear) {
        return repository.findByTopYearIs(topYear, pageable);
    }

    public List<Object> getByTitle(String title) {
        return repository.getByTitle(title);
    }

    public List<Object> joinTwoTables() {
        return repository.joinTwoTables();
    }
}
