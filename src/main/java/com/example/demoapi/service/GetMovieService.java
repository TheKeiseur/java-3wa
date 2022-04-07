package com.example.demoapi.service;

import com.example.demoapi.model.Movie;
import com.example.demoapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetMovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie getMovie(Long id) {
        return movieRepository.findById(id).get();
    }

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }
}
