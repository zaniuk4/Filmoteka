package lt.viltiesziedas.Filmoteka.model.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Privilegija {
    public Privilegija() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Privilegija{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", roles=" + roles +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Roles> roles) {
        this.roles = roles;
    }

    public Privilegija(Long id, String name, Collection<Roles> roles) {
        this.id = id;
        this.name = name;
        this.roles = roles;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public Privilegija(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "privilegijos")
    private Collection<Roles> roles;
}
