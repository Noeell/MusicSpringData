package ch.bbw.m151.kleinprojekt;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/songs")
public class SongsController {

    private final SongsService service;

    public SongsController(SongsService service) {
        this.service = service;
    }

    @GetMapping("/{topYear}")
    public ResponseEntity<List<SongsEntity>> findAllByTopYearIs(@PathVariable("topYear") int topYear) {
        return ResponseEntity.ok(service.findAllByTopYearIs(topYear));
    }

    @GetMapping("/{title}/{year}")
    public ResponseEntity<List<SongsEntity>> findAllByYearReleasedAndTitleStartsWith(@PathVariable("title") String title, @PathVariable("year") int year) {
        return ResponseEntity.ok(service.findAllByYearReleasedAndTitleStartsWith(year, title));
    }

    @GetMapping("/pageable/{topYear}")
    public ResponseEntity<Page<SongsEntity>> findAllByTopYearIsPageable(@PathVariable("topYear") int topYear) {
        return ResponseEntity.ok(service.findByTopYearIsPageable(topYear));
    }

    @DeleteMapping("/delete/{topYear}")
    public ResponseEntity<Long> deleteByTitle(@PathVariable("topYear") int topYear) {
        return ResponseEntity.status(200).body(service.deleteByTitle(topYear));
    }

    @GetMapping("/query/{title}")
    public ResponseEntity<List<Object>> selectAddedDurAndTitle(@PathVariable("title") String title) {
        return ResponseEntity.ok(service.selectAddedDurAndTitle(title));
    }

    @GetMapping("/join")
    public ResponseEntity<List<Object>> joinTwoTables() {
        return ResponseEntity.ok(service.joinTwoTables());
    }
}
