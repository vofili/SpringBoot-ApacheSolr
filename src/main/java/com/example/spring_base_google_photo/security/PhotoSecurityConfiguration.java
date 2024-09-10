package com.example.spring_base_google_photo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class PhotoSecurityConfiguration {

        @Bean
        public SecurityFilterChain defaultAPISecurityFilterChain(HttpSecurity httpSecurity) throws Exception{
                return httpSecurity.csrf(AbstractHttpConfigurer::disable)
                        .authorizeHttpRequests(auth->
                        {
                                auth.anyRequest().authenticated();

                        })
                        .httpBasic(Customizer.withDefaults())
                        .build();
        }

        SecurityFilterChain doBasicSecurityFilterChain(HttpSecurity httpSecurity) throws Exception{
                return httpSecurity.csrf(AbstractHttpConfigurer::disable)
                        .authorizeHttpRequests(auth->{
                                auth.anyRequest().authenticated();
                        })
                        .httpBasic(Customizer.withDefaults())
                        .build();
        }

        @Bean
        UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){
                UserDetails user = User.builder()
                        .password(passwordEncoder.encode("Passw0rd"))
                        .username("admin")
                        .roles("ADMIN")
                        .build();
                return new InMemoryUserDetailsManager(user);
        }

        @Bean
        PasswordEncoder bcryptPasswordEncoder(){
                return new BCryptPasswordEncoder();
        }
}
