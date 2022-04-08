package com.example.demoapi.controller;

import com.example.demoapi.model.Movie;
import com.example.demoapi.service.MovieService;
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
    private MovieService movieService;

    @GetMapping("/movies")
    public String getMovies(Model model) {

        List<Movie> movies = movieService.getMovies();
        model.addAttribute("movies", movies);

        return "home";
    }

    @GetMapping("/about")
    public String getAbout() {
        return "about";
    }

    @PostMapping("/movie")
    public String saveMovie(@RequestParam String title, @RequestParam Integer duration, @RequestParam String description) {

        movieService.saveMovie(title, duration, description);

        return "redirect:movies";
    }

    @DeleteMapping("/about/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        movieService.deleteMovie(id);

        return "redirect:/catalog/movies";
    }

    @PutMapping("about/{id}")
    public String updateById(@PathVariable("id") Long id) {
        movieService.updateMovie(id);

        return "redirect:/catalog/movies";
    }
}
