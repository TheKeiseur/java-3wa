package com.example.demoapi.service;

import com.example.demoapi.model.Movie;
import com.example.demoapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie getMovie(Long id) {
        return movieRepository.findById(id).get();
    }
}
