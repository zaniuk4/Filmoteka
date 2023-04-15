package lt.viltiesziedas.Filmoteka.model.repository;

import lt.viltiesziedas.Filmoteka.model.entity.Filmai;
import lt.viltiesziedas.Filmoteka.model.entity.FilmoZanras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FilmaiRepository  extends JpaRepository <Filmai, Long> {

    Filmai findById(long id);

    Filmai findByPavadinimas(String pavadinimas);

}
