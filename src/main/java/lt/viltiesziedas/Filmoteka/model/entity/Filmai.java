package lt.viltiesziedas.Filmoteka.model.entity;


import javax.persistence.*;
import java.util.Set;

@Entity

public class Filmai {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long  id;
    private String pavadinimas;
    private String aprasymas;
    private double IMDBReitingas;



    @ManyToOne
    @JoinColumn (name = "zanro_id")
    private FilmoZanras zanras;



    @OneToMany(mappedBy = "filmas")
    Set<Komentaras> komentarai;

    public Filmai() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public String getAprasymas() {
        return aprasymas;
    }

    public void setAprasymas(String aprasymas) {
        this.aprasymas = aprasymas;
    }

    public double getIMDBReitingas() {
        return IMDBReitingas;
    }

    public void setIMDBReitingas(double IMDBReitingas) {
        this.IMDBReitingas = IMDBReitingas;
    }

    public FilmoZanras getZanras() {
        return zanras;
    }

    public void setZanras(FilmoZanras zanras) {
        this.zanras = zanras;
    }

    public Set<Komentaras> getKomentarai() {
        return komentarai;
    }

    public void setKomentarai(Set<Komentaras> komentarai) {
        this.komentarai = komentarai;
    }

    public Filmai(long id, String pavadinimas, String aprasymas, double IMDBReitingas, FilmoZanras zanras, Set<Komentaras> komentarai) {
        this.id = id;
        this.pavadinimas = pavadinimas;
        this.aprasymas = aprasymas;
        this.IMDBReitingas = IMDBReitingas;
        this.zanras = zanras;
        this.komentarai = komentarai;


    }

    @Override
    public String toString() {
        return "Filmai{" +
                "id=" + id +
                ", pavadinimas='" + pavadinimas + '\'' +
                ", aprasymas='" + aprasymas + '\'' +
                ", IMDBReitingas=" + IMDBReitingas +
                ", zanras=" + zanras +
                ", komentarai=" + komentarai +
                '}';
    }
}
