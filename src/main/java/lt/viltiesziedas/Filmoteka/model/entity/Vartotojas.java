package lt.viltiesziedas.Filmoteka.model.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity

public class Vartotojas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String username;
    private String password;
    private boolean enabled;
    private boolean tokenExpired;

    @OneToMany(mappedBy = "vartotojas")
    Set<Komentaras> vartotojoKomentarai;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isTokenExpired() {
        return tokenExpired;
    }

    public void setTokenExpired(boolean tokenExpired) {
        this.tokenExpired = tokenExpired;
    }

    public Collection<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Roles> roles) {
        this.roles = roles;
    }

    @ManyToMany
    @JoinTable(
                   name = "vartotojo_roles",
                   joinColumns = @JoinColumn(
                    name = "vartotojo_id", referencedColumnName = "id"),
                    inverseJoinColumns = @JoinColumn(
                         name ="role_id", referencedColumnName = "id"))
    private Collection<Roles>roles;





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
