package org.lessons.booleaners.bestoftheyear;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

    private ArrayList getBestMovies(){
        ArrayList movies = new ArrayList();
        Movies a = new Movies(1, "Burnout");
        Movies b = new Movies(2, "Turn me on");
        movies.add(a);
        movies.add(b);
        return movies;
    }


    private ArrayList getBestSongs(){
        ArrayList songs = new ArrayList();
        Songs c = new Songs(1, "Thuderstruck");
        Songs d = new Songs(2, "Thuder");
        songs.add(c);
        songs.add(d);
        return songs;
    }
}
