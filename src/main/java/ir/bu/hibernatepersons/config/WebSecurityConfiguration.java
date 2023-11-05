package ir.bu.hibernatepersons.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
class WebSecurityConfiguration {

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
                .roles("USER")
                .build();
        UserDetails maxim = User.withUsername("maxim")
                .username("Maxim")
                .password(encoder.encode("2222"))
                .roles("MANAGER")
                .build();
        UserDetails admin = User.withUsername("admin")
                .username("admin")
                .password(encoder.encode("0000"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, ivan, maxim, admin);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
                        .requestMatchers(HttpMethod.GET, "/persons/hi").permitAll()
                        .requestMatchers(HttpMethod.GET, "/read-all").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/create").hasAuthority("Ivan")
                        .requestMatchers(HttpMethod.POST, "/delete").hasAnyAuthority("Ivan", "Maxim", "admin")
                        .requestMatchers(HttpMethod.POST, "/update").hasAuthority("Maxim")
                        .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults());
        return http.build();
    }
}
