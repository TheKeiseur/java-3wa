package com.example.demoapi.controller;

import com.example.demoapi.model.Movie;
import com.example.demoapi.service.GetMovieService;
import com.example.demoapi.service.SaveMovieService;
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
    private GetMovieService getMovieService;
    @Autowired
    private SaveMovieService saveMovieService;

    @GetMapping("/movies")
    public String getMovies(Model model) {

        List<Movie> movies = getMovieService.getMovies();
        model.addAttribute("movies", movies);

        return "home";
    }

    @GetMapping("/about")
    public String getAbout() {
        return "about";
    }

    @PostMapping("/movie")
    public String saveMovie(@RequestParam String title, @RequestParam Integer duration, @RequestParam String description) {

        saveMovieService.saveMovie(title, duration, description);

        return "redirect:movies";
    }

    @DeleteMapping("/about/{id}")
    public String deleteById(@PathVariable Long id) {
        //getMovieService.deleteById(id);

        return "home";
    }
}
