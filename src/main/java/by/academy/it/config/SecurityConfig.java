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
                .antMatchers("/info").hasRole("ADMIN")
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
        manager.createUser(User.withDefaultPasswordEncoder()
                .username("alex")
                .password("123")
                .roles("USER", "ADMIN")
                .build());
        manager.createUser(User.withDefaultPasswordEncoder()
                .username("bob")
                .password("111")
                .roles("USER")
                .build());
        return manager;
    }
}
