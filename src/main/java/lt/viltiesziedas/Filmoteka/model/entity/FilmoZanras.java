package lt.viltiesziedas.Filmoteka.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity

public class FilmoZanras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long ID;
    private String pavadinimas;

    @OneToMany(mappedBy = "zanras")
    Set<Filmai> filmai;

    public FilmoZanras() {

    }

    public FilmoZanras(long ID, String pavadinimas, Set<Filmai> filmai) {
        this.ID = ID;
        this.pavadinimas = pavadinimas;
        this.filmai = filmai;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public Set<Filmai> getFilmai() {
        return filmai;
    }

    public void setFilmai(Set<Filmai> filmai) {
        this.filmai = filmai;
    }

    @Override
    public String toString() {
        return "FilmoZanras{" +
                "ID=" + ID +
                ", pavadinimas='" + pavadinimas + '\'' +
                ", filmai=" + filmai +
                '}';
    }
}
