package com.example.demoapi.service;

import com.example.demoapi.model.Movie;
import com.example.demoapi.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie getMovie(Long id) {
        return movieRepository.findById(id).get();
    }

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

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

    public Boolean deleteMovie(Long id) {
        try {
            movieRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            return false;
        }
    }

    public Boolean updateMovie(Long id) {
        movieRepository.findById(id);
        return true;
    }
}
