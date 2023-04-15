package lt.viltiesziedas.Filmoteka.controller;

import lt.viltiesziedas.Filmoteka.model.entity.FilmoZanras;
import lt.viltiesziedas.Filmoteka.model.repository.FilmoZanrasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class KategorijuController {
    @Autowired
    FilmoZanrasRepository filmoZanrasRepository;

    @GetMapping("/test/visos_kategorijos")
    String rodytiVisusZanrus(Model model) {
        List<FilmoZanras> visosKetgorijos = filmoZanrasRepository.findAll();
        model.addAttribute("visiZanrai", visosKetgorijos);
        return "visos_kategorijos.html";
    }

    @GetMapping("/zanras/rodyti_pavadinimus")
    String rodytiZanroFilmus(@RequestParam long id,Model model) {
        FilmoZanras zanras = filmoZanrasRepository.findById(id);
        model.addAttribute("zanroFilmai", zanras.getFilmai());
        return "Visi_zanro_filmai.html";

    }
    @GetMapping("zanras/zanro_idejimas")
    String zanroPridejimas(Model model) {
        return "Zanro ivedimas.html";
    }

    @PostMapping("/zanras/idetas_zanras")
    String idetiZanra(@RequestParam String pavadinimas,Model model) {
        FilmoZanras naujasZanras = new FilmoZanras();
        FilmoZanras ieskomasZanras = filmoZanrasRepository.findByPavadinimas(pavadinimas);
        String pranesimasVartotojui;
        if (ieskomasZanras != null) {
            pranesimasVartotojui = "Toks zanras jau ivestas ";
        }
        else {
            pranesimasVartotojui = "Sekmingai ivedete zanra";
            naujasZanras.setPavadinimas(pavadinimas);
            filmoZanrasRepository.save(naujasZanras);

        }
        model.addAttribute("PranesimasVartotojui",pranesimasVartotojui);

        return "idetas_zanras.html";
    }

}
