package lt.viltiesziedas.Filmoteka.model.repository;

import lt.viltiesziedas.Filmoteka.model.entity.Filmai;
import lt.viltiesziedas.Filmoteka.model.entity.Privilegija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegijaRepository extends JpaRepository<Privilegija, Long> {

    Privilegija findByName (String name);


}
