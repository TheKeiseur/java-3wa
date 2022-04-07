package com.example.demoapi.service;

import com.example.demoapi.model.Movie;
import com.example.demoapi.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SaveMovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Boolean saveMovie(String title, Integer duration, String description) {
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setDuration(duration);
        movie.setDescription(description);
        try {
            movieRepository.save(movie);
            return true;
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            return false;
        }

    }
}
