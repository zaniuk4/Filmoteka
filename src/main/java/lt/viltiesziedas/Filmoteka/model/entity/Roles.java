package lt.viltiesziedas.Filmoteka.model.entity;

import javax.persistence.*;
import java.util.Collection;


@Entity
public class Roles {

    public Roles(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public void setId(long id) {
        this.id = id;
    }

    private String name;
    @ManyToMany(mappedBy = "roles")
    private Collection<Vartotojas> vartotojas;

    public Roles(Long id, String name, Collection<Vartotojas> vartotojas, Collection<Privilegija> privilegijos) {
        this.id = id;
        this.name = name;
        this.vartotojas = vartotojas;
        this.privilegijos = privilegijos;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vartotojas=" + vartotojas +
                ", privilegijos=" + privilegijos +
                '}';
    }

    public Roles() {
    }

    @ManyToMany
    @JoinTable(
                  name = "roles_privilegijos",
                  joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"),
                    inverseJoinColumns = @JoinColumn(
                    name = "privilegija_id", referencedColumnName = "id"))
    private Collection<Privilegija> privilegijos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Vartotojas> getVartotojas() {
        return vartotojas;
    }

    public void setVartotojas(Collection<Vartotojas> vartotojas) {
        this.vartotojas = vartotojas;
    }

    public Collection<Privilegija> getPrivilegijos() {
        return privilegijos;
    }

    public void setPrivilegijos(Collection<Privilegija> privilegijos) {
        this.privilegijos = privilegijos;
    }
}
