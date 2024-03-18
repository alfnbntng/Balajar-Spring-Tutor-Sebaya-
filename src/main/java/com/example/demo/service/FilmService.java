package com.example.demo.service;

import com.example.demo.dto.FilmDTO;
import com.example.demo.dto.FilmRequestDTO;
import com.example.demo.dto.GenreDTO;
import com.example.demo.model.*;
import com.example.demo.repository.FilmRepository;
import com.example.demo.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmService {
    @Autowired
    private FilmRepository movieRepository;

    @Autowired
    private GenreRepository genreRepository;

    public List<FilmDTO> getAllMovies() {
        List<FilmModel> movies = movieRepository.findAll();
        return movies.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public FilmDTO getMovieById(Long id) {
        FilmModel movie = movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));
        return mapToDTO(movie);
    }

    public FilmDTO createMovie(FilmRequestDTO movieRequestDTO) {
        FilmModel movie = new FilmModel();
        movie.setTitle(movieRequestDTO.getTitle());

        GenreModel genre = genreRepository.findById(movieRequestDTO.getGenreId())
                .orElseThrow(() -> new RuntimeException("Genre not found"));
        movie.setGenre(genre);

        movie = movieRepository.save(movie);
        return mapToDTO(movie);
    }

    public FilmDTO updateMovie(Long id, FilmRequestDTO movieRequestDTO) {
        FilmModel movie = movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));
        movie.setTitle(movieRequestDTO.getTitle());

        GenreModel genre = genreRepository.findById(movieRequestDTO.getGenreId())
                .orElseThrow(() -> new RuntimeException("Genre not found"));
        movie.setGenre(genre);

        movie = movieRepository.save(movie);
        return mapToDTO(movie);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    private FilmDTO mapToDTO(FilmModel movie) {
        FilmDTO dto = new FilmDTO();
        dto.setId(movie.getId());
        dto.setTitle(movie.getTitle());

        GenreDTO genreDTO = new GenreDTO();
        genreDTO.setId(movie.getGenre().getId());
        genreDTO.setName(movie.getGenre().getName());
        dto.setGenre(genreDTO);

        return dto;
    }

    public List<FilmDTO> getFilmsByGenre(Long genreId) {
        List<FilmModel> movies = movieRepository.findByGenreId(genreId);
        return movies.stream().map(this::mapToDTO).collect(Collectors.toList());
    }
}
