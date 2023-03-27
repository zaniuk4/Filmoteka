package lt.viltiesziedas.Filmoteka.model.repository;

import lt.viltiesziedas.Filmoteka.model.entity.Vartotojas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface VartotojasRepository extends JpaRepository <Vartotojas, Long> {
    Vartotojas findById (long id);


}
