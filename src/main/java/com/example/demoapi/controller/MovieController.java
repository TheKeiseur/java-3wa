package com.example.demoapi.controller;

import com.example.demoapi.model.Movie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("catalog")
public class MovieController {

    @GetMapping("/movies")
    public String getMovies(Model model) {
        Movie movie = new Movie();
        movie.setDescription("Film d'action");
        movie.setDuration(120);
        movie.setTitle("Transformers");

        Movie movie2 = new Movie();
        movie2.setDescription("Film fantastique");
        movie2.setDuration(110);
        movie2.setTitle("Harry Potter");

        Movie movie3 = new Movie();
        movie3.setDescription("Film SF");
        movie3.setDuration(150);
        movie3.setTitle("Interstellar");

        Movie movie4 = new Movie();
        movie4.setDescription("Film comédie");
        movie4.setDuration(115);
        movie4.setTitle("Ace Ventura");

        Movie movie5 = new Movie();
        movie5.setDescription("Film d'animation");
        movie5.setDuration(110);
        movie5.setTitle("Dragon 2");

        List<Movie> movies = new ArrayList<>();
        movies.add(movie);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);
        movies.add(movie5);

        model.addAttribute("movies", movies);

        return "home";
    }

    @GetMapping("/about")
    public String getAbout() {
        return "about";
    }

    @PostMapping("/movie")
    public String postMovie() { return "movie"; }
}
