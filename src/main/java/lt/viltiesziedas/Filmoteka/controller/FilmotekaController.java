package lt.viltiesziedas.Filmoteka.controller;

import lt.viltiesziedas.Filmoteka.model.entity.Filmai;
import lt.viltiesziedas.Filmoteka.model.entity.FilmoZanras;
import lt.viltiesziedas.Filmoteka.model.entity.Komentaras;
import lt.viltiesziedas.Filmoteka.model.entity.Vartotojas;
import lt.viltiesziedas.Filmoteka.model.repository.FilmaiRepository;
import lt.viltiesziedas.Filmoteka.model.repository.FilmoZanrasRepository;
import lt.viltiesziedas.Filmoteka.model.repository.KomentarasRepository;
import lt.viltiesziedas.Filmoteka.model.repository.VartotojasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class FilmotekaController {
    @GetMapping("/FilmoNuoroda/")
    String filmoAtvaizdavimoFunkcija(Model model) {
        return "filmo_atvaizdavimas.html";

    }
    @Autowired
    FilmoZanrasRepository filmoZanrasRepository;
    @Autowired
    FilmaiRepository filmaiRepository;

    @Autowired
    VartotojasRepository vartotojasRepository;

    @Autowired
    KomentarasRepository komentarasRepository;
    @GetMapping("/test/sveikinimas")
    String testineFunkcija(Model model, @RequestParam String vardas) {
        model.addAttribute("vardas", vardas);
        return "testinis_puslapis.html";
    }

        @GetMapping("/test/filmoteka")
        String testFilmoteka(Model model) {
        return "parodyti_filma.html";


    }
    @GetMapping("/test/filmas")
    String testReceptas(Model model, @RequestParam String pavadinimas) {

        Filmai filmas = filmaiRepository.findByPavadinimas(pavadinimas);
        model.addAttribute("pavadinimas", filmas.getPavadinimas());
        model.addAttribute("zanras",filmas.getZanras().getPavadinimas());
        model.addAttribute("IMDBReitingas",filmas.getIMDBReitingas());
        model.addAttribute("filmoKomentaras", filmas.getKomentarai());
        model.addAttribute("id",filmas.getId());

        return "filmo_atvaizdavimas.html";

}
    @GetMapping ("/filmo/paieska")
    String filmoPaieska(Model model) {

        return "Filmo_paieska_pagal_pavadinima.html";
    }

    @GetMapping("/filmas/idejimas")
    String filmoIdejimas(Model model) {
        Filmai idedamasFilmas = new Filmai();
        model.addAttribute("filmas",idedamasFilmas);
        List<FilmoZanras> visosKategorijos = filmoZanrasRepository.findAll();
        model.addAttribute("zanrai", visosKategorijos);
        return "Filmo_idejimas.html";
    }
    @PostMapping("/filmas/idejo_filma")
    String pridetiFilma(@ModelAttribute Filmai ivedamasFilmas) {
        filmaiRepository.save(ivedamasFilmas);
        return  "idetas_filmas.html";

    }
    @GetMapping("/filmas/redaguoti_filma/{id}")
    String filmoRedagavimas(Model model, @PathVariable long id) {
        Filmai redaguojamasFilmas = filmaiRepository.findById(id);
        model.addAttribute("filmas", redaguojamasFilmas);
        List<FilmoZanras> visiZanrai = filmoZanrasRepository.findAll();
        model.addAttribute("zanrai",visiZanrai);

        return "Filmo_redagavimas.html";
    }

    @PostMapping("filmas/istrinti_filma/{id}")
    String istrintiFilma(Model model, @PathVariable long id) {
        filmaiRepository.delete(filmaiRepository.findById(id));
        return "istrintas_filmas.html";
    }
    @PostMapping("vartotojas/komentuoti_filma/{id}")
    String komentuotiFilma(Model model,@PathVariable long id, @RequestParam String komentaras){
        Filmai filmas = filmaiRepository.findById(id);
        Komentaras vartotojoKomentaras = new Komentaras();
        Vartotojas vartotojas = vartotojasRepository.findById(1);
        vartotojoKomentaras.setTekstas(komentaras);
        vartotojoKomentaras.setFilmas(filmas);
        vartotojoKomentaras.setVartotojas(vartotojas);
        komentarasRepository.save(vartotojoKomentaras);


        return "filmo_komentaras.html";
    }


}







