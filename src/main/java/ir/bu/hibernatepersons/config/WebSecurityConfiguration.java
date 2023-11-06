package ir.bu.hibernatepersons.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true, jsr250Enabled = true)
public class WebSecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        UserDetails user = User.withUsername("user")
                .username("user")
                .password(encoder.encode("password"))
                .roles("USER")
                .build();
        UserDetails ivan = User.withUsername("ivan")
                .username("Ivan")
                .password(encoder.encode("1111"))
                .roles("READ", "USER")
                .build();
        UserDetails maxim = User.withUsername("maxim")
                .username("Maxim")
                .password(encoder.encode("2222"))
                .roles("WRITE", "USER")
                .build();
        UserDetails admin = User.withUsername("admin")
                .username("admin")
                .password(encoder.encode("0000"))
                .roles("DELETE", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, ivan, maxim, admin);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
                        .requestMatchers(HttpMethod.GET, "/persons/hi").permitAll()
                        .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults());
        return http.build();
    }
}
