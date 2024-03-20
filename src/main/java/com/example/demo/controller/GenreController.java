package com.example.demo.controller;

import com.example.demo.dto.GenreDTO;
import com.example.demo.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/belajar-spring/api/genre")
public class GenreController {
    @Autowired
    private GenreService genreService;

    @GetMapping("/all")
    public ResponseEntity<List<GenreDTO>> getAllGenres() {
        List<GenreDTO> genres = genreService.getAllGenres();
        return ResponseEntity.ok(genres);
    }

    @GetMapping("/by-id/{id}")
    public ResponseEntity<GenreDTO> getGenreById(@PathVariable Long id) {
        GenreDTO genre = genreService.getGenreById(id);
        return ResponseEntity.ok(genre);
    }

    @PostMapping("/add")
    public ResponseEntity<GenreDTO> createGenre(@RequestBody GenreDTO genreDTO) {
        GenreDTO createdGenre = genreService.createGenre(genreDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGenre);
    }

    @PutMapping("/ubah/{id}")
    public ResponseEntity<GenreDTO> updateGenre(@PathVariable Long id, @RequestBody GenreDTO genreDTO) {
        GenreDTO updatedGenre = genreService.updateGenre(id, genreDTO);
        return ResponseEntity.ok(updatedGenre);
    }

    @DeleteMapping("/hapus/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable Long id) {
        genreService.deleteGenre(id);
        return ResponseEntity.noContent().build();
    }
}
