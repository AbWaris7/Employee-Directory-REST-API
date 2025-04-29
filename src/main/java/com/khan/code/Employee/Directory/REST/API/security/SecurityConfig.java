package com.khan.code.Employee.Directory.REST.API.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {


//    @Bean
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
//
//        UserDetails john = User.builder()
//                .username("john")
//                .password("{noop}test123")
//                .roles("EMPLOYEE")
//                .build();
//
//        UserDetails marry = User.builder()
//                .username("marry")
//                .password("{noop}test123")
//                .roles("EMPLOYEE", "MANAGER")
//                .build();
//
//        UserDetails abdul = User.builder()
//                .username("abdul")
//                .password("{noop}test123")
//                .roles("EMPLOYEE", "MANAGER","ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(john, marry, abdul);
//    }


    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/h2-console/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/h2-console/**").permitAll()
                        .requestMatchers("/docs/**", "/swagger-ui/**", "/v3/api-docs/**", "swagger-ui.html").permitAll()
                        .requestMatchers(HttpMethod.GET,"/api/employees")
                        .hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/api/employees/**")
                        .hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/api/employees")
                        .hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/api/employees/**")
                        .hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/api/employees/**")
                        .hasRole("ADMIN")
        );

        http.httpBasic(httpBasicCustomizer ->httpBasicCustomizer.disable());

        // User HTTP Basic Authentication
        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf -> csrf.disable());

        http.exceptionHandling(exceptionHandler -> exceptionHandler.authenticationEntryPoint(authenticationEntryPoint()));
        http.headers(headers -> headers.frameOptions(frameOptionsConfig -> frameOptionsConfig.disable()));
        return http.build();
    }


    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {

        return (request, response, authException) -> {
            // Send 401 unauthorized status without triggering a basic auth
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setContentType("application/json");

            // Remove the WWW-Authenticate header to prevent browser popup
            response.setHeader("WWW-Authenticate", "");
            response.getWriter().write("{\"error\" : \"Unauthorized access\"}");
        };
    }

}
