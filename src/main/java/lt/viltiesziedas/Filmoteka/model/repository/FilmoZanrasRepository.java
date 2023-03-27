package lt.viltiesziedas.Filmoteka.model.repository;


import lt.viltiesziedas.Filmoteka.model.entity.FilmoZanras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmoZanrasRepository extends JpaRepository <FilmoZanras,Long >{
    FilmoZanras findById (long id);


}
