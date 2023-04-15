package lt.viltiesziedas.Filmoteka.model.repository;

import lt.viltiesziedas.Filmoteka.model.entity.Privilegija;
import lt.viltiesziedas.Filmoteka.model.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {

    Roles findByName (String name);


}
