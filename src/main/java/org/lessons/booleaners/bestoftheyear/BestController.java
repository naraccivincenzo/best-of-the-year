package org.lessons.booleaners.bestoftheyear;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping
public class BestController {

    //mapping time
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("name", "Vincenzo");
        return "home";
    }

    @GetMapping("/movies")
    public String movies(Model model) {
        model.addAttribute("movies",getBestMovies());
        return "movies";
    }

    @GetMapping("/songs")
    public String songs(Model model) {
        model.addAttribute("songs",getBestSongs());
        return "songs";
    }

    @GetMapping("/movies/{id}")
    public String movies(@PathVariable int id, Model model) {
        model.addAttribute("movies", id);
        for (Movies movie : getBestMovies()){
            if (movie.getId() == id){
                model.addAttribute("title", movie.getTitle());
            }
        }
        return "details";
    }

    @GetMapping("/songs/{id}")
    public String songs(@PathVariable int id, Model model) {
        model.addAttribute("songs", id);
        for (Songs song : getBestSongs()){
            if (song.getId() == id){
                model.addAttribute("title", song.getTitle());
            }
        }
        return "details";
    }

    private ArrayList<Movies> getBestMovies(){
        ArrayList<Movies> movies = new ArrayList<>();
        movies.add(new Movies(1, "Burnout"));
        movies.add(new Movies(2, "Turn me on"));
        return movies;
    }


    private ArrayList<Songs> getBestSongs(){
        ArrayList<Songs> songs = new ArrayList<>();
        songs.add(new Songs(1, "Thunderstruck"));
        songs.add(new Songs(2, "Thunder"));
        return songs;
    }
}
