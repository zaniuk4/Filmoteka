package lt.viltiesziedas.Filmoteka.security;

import lt.viltiesziedas.Filmoteka.model.entity.Privilegija;
import lt.viltiesziedas.Filmoteka.model.entity.Roles;
import lt.viltiesziedas.Filmoteka.model.entity.Vartotojas;
import lt.viltiesziedas.Filmoteka.model.repository.PrivilegijaRepository;
import lt.viltiesziedas.Filmoteka.model.repository.RolesRepository;
import lt.viltiesziedas.Filmoteka.model.repository.VartotojasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Component
public class SetupDataLoader implements
        ApplicationListener<ContextRefreshedEvent> {

  boolean alreadySetup = false;

  @Autowired
  private VartotojasRepository userRepository;

  @Autowired
  private RolesRepository roleRepository;

  @Autowired
  private PrivilegijaRepository privilegijaRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  @Transactional
  public void onApplicationEvent(ContextRefreshedEvent event) {

    if (alreadySetup)
      return;
    Privilegija readPrivilegija
            = createPrivilegijaIfNotFound("READ_PRIVILEGIJA");
    Privilegija writePrivilegija
            = createPrivilegijaIfNotFound("WRITE_PRIVILEGE");

    List<Privilegija> adminPrivilegija = Arrays.asList(readPrivilegija, writePrivilegija);
    createRoleIfNotFound("ROLE_ADMIN", adminPrivilegija);
    createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilegija));

    Roles adminRoles = roleRepository.findByName("ROLE_ADMIN");
    Vartotojas vartotojas = new Vartotojas();
    vartotojas.setUsername("Test");

    vartotojas.setPassword(passwordEncoder.encode("test"));

    vartotojas.setRoles(Arrays.asList(adminRoles));
    vartotojas.setEnabled(true);
    vartotojas.setId(3L);
    userRepository.save(vartotojas);

    alreadySetup = true;
  }

  @Transactional
  Privilegija createPrivilegijaIfNotFound(String name) {

    Privilegija privilegija = privilegijaRepository.findByName(name);
    if (privilegija == null) {
      privilegija = new Privilegija(name);
      privilegijaRepository.save(privilegija);
    }
    return privilegija;
  }

  @Transactional
  Roles createRoleIfNotFound(
          String name, Collection<Privilegija> privileges) {

    Roles role = roleRepository.findByName(name);
    if (role == null) {
      role = new Roles(name);
      role.setPrivilegijos(privileges);
      roleRepository.save(role);
    }
    return role;
  }
}

