package by.academy.it.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/index.html").permitAll()
                .antMatchers("/employees").authenticated()
                .antMatchers("/info").hasAnyRole("ADMIN", "USER")
                .and()
                .formLogin()
                .and()
                .httpBasic()
                .and()
                .logout().logoutSuccessUrl("/");
    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.builder()
                .username("alex")
                .password("{bcrypt}$2y$12$xkiuac97NTnlIh8QmOOjYeVdGYDcxuw9iCanuuVBPxHBdd4ahDAW6")
                .roles("USER", "ADMIN")
                .build());
        manager.createUser(User.builder()
                .username("bob")
                .password("{bcrypt}$2y$12$bWmoc/QDn.l1TP4Focqc7u29a.bn7.UffozYsJbd0vEOEQ/1BiBsK")
                .roles("USER")
                .build());
        return manager;
    }
}
