package lt.viltiesziedas.Filmoteka.model.entity;

import javax.persistence.*;

@Entity
public class Komentaras {
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String tekstas;

    @ManyToOne
    @JoinColumn(name = "filmo_id")
    private Filmai filmas;

    @ManyToOne
    @JoinColumn(name = "vartotojo_id")
    private Vartotojas vartotojas;

    public Komentaras() {
    }

    public Komentaras(long id, String tekstas, Filmai filmas, Vartotojas vartotojas) {
        this.id = id;
        this.tekstas = tekstas;
        this.filmas = filmas;
        this.vartotojas = vartotojas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTekstas() {
        return tekstas;
    }

    public void setTekstas(String tekstas) {
        this.tekstas = tekstas;
    }

    public Filmai getFilmas() {
        return filmas;
    }

    public void setFilmas(Filmai filmas) {
        this.filmas = filmas;
    }

    public Vartotojas getVartotojas() {
        return vartotojas;
    }

    public void setVartotojas(Vartotojas vartotojas) {
        this.vartotojas = vartotojas;
    }

    @Override
    public String toString() {
        return "Komentaras{" +
                "id=" + id +
                ", tekstas='" + tekstas + '\'' +
                ", filmas=" + filmas +
                ", vartotojas=" + vartotojas +
                '}';
    }
}


