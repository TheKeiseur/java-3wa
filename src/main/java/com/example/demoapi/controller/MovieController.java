package com.example.demoapi.controller;

import com.example.demoapi.model.Movie;
import com.example.demoapi.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("catalog")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/movies")
    public String getMovies(Model model) {

        List<Movie> movies = movieRepository.findAll();
        model.addAttribute("movies", movies);

        return "home";
    }

    @GetMapping("/about")
    public String getAbout() {
        return "about";
    }

    @PostMapping("/movie")
    public String saveMovie(@RequestParam String title, @RequestParam Integer duration, @RequestParam String description) {
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setDuration(duration);
        movie.setDescription(description);

        movieRepository.save(movie);

        return "home";
    }

    @DeleteMapping("/about/{id}")
    public String deleteById(@PathVariable Long id) {
        movieRepository.deleteById(id);

        return "home";
    }
}
