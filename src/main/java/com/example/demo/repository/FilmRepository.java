package com.example.demo.repository;

import com.example.demo.model.FilmModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<FilmModel, Long> {
    List<FilmModel> findByGenreId(Long genreId);
}
