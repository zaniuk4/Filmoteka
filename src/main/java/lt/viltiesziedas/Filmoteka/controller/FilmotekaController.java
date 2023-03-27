package lt.viltiesziedas.Filmoteka.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class FilmotekaController {
    @GetMapping("/FilmoNuoroda/")
    String filmoAtvaizdavimoFunkcija(Model model) {
        return "filmo_atvaizdavimas.html";

    }





}
