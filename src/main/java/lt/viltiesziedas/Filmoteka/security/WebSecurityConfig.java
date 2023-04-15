package lt.viltiesziedas.Filmoteka.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/*").authenticated()
                .antMatchers("/filmai/idejimas/").hasRole("ADMIN")
                .antMatchers("/filmai/filmo_redagavimas/*").hasRole("ADMIN")
                .antMatchers("/filmai/istrinti_filma/*").hasRole("ADMIN")
                .antMatchers("/zanrai/prideti_zanra/").hasRole("ADMIN")
                .antMatchers("/zanrai/pridetas_zanras").hasRole("ADMIN")
                .antMatchers("/zanrai/istrinti_zanra").hasRole("ADMIN")
                .antMatchers("/registracija").permitAll()
                .antMatchers("/registracijos_patvirtinimas").permitAll()
                .and()
                .formLogin()
                //.loginPage("/login.html").permitAll()
                //.failureUrl("/login-error.html")
                .and()
                .httpBasic()
                .and()
                .logout();
        return http.build();
    }

    /*/@Bean
    public InMemoryUserDetailsManager userDetailsService(){
        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder().encode("adminPass"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(admin);
    }/*/
}