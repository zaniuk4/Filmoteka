package lt.viltiesziedas.Filmoteka.model.repository;

import lt.viltiesziedas.Filmoteka.model.entity.Komentaras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KomentarasRepository extends JpaRepository <Komentaras,Long> {
    Komentaras findById (long id);

}
