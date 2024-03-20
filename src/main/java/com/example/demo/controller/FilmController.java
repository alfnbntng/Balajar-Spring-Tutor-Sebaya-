package com.example.demo.controller;

import com.example.demo.dto.FilmDTO;
import com.example.demo.dto.FilmRequestDTO;
import com.example.demo.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/belajar-spring/api/movies")
public class FilmController {
    @Autowired
    private FilmService movieService;

    @GetMapping("/all")
    public ResponseEntity<List<FilmDTO>> getAllMovies() {
        List<FilmDTO> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/by-id/{id}")
    public ResponseEntity<FilmDTO> getMovieById(@PathVariable Long id) {
        FilmDTO movie = movieService.getMovieById(id);
        return ResponseEntity.ok(movie);
    }

    @PostMapping("/add")
    public ResponseEntity<FilmDTO> createMovie(@RequestBody FilmRequestDTO movieRequestDTO) {
        FilmDTO createdMovie = movieService.createMovie(movieRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMovie);
    }

    @PutMapping("/ubah/{id}")
    public ResponseEntity<FilmDTO> updateMovie(@PathVariable Long id, @RequestBody FilmRequestDTO movieRequestDTO) {
        FilmDTO updatedMovie = movieService.updateMovie(id, movieRequestDTO);
        return ResponseEntity.ok(updatedMovie);
    }

    @DeleteMapping("/hapus/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/byGenre/{genreId}")
    public ResponseEntity<List<FilmDTO>> getFilmsByGenre(@PathVariable Long genreId) {
        List<FilmDTO> movies = movieService.getFilmsByGenre(genreId);
        return ResponseEntity.ok(movies);
    }
}
