package lt.viltiesziedas.Filmoteka.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity

public class Vartotojas {

    @Id
    @GeneratedValue

    Long id;
    String username;
    String password;

    @OneToMany(mappedBy = "vartotojas")
    Set<Komentaras> vartotojoKomentarai;

    public Vartotojas() {
    }

    public Vartotojas(Long id, String username, String password, Set<Komentaras> vartotojoKomentarai) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.vartotojoKomentarai = vartotojoKomentarai;
    }

    @Override
    public String toString() {
        return "Vartotojas{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", vartotojoKomentarai=" + vartotojoKomentarai +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Komentaras> getVartotojoKomentarai() {
        return vartotojoKomentarai;
    }

    public void setVartotojoKomentarai(Set<Komentaras> vartotojoKomentarai) {
        this.vartotojoKomentarai = vartotojoKomentarai;
    }
}
