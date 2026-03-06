package tg.Ipnet.efunerailles.Config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration 
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // 1. Activation de la configuration CORS définie plus bas
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            
            // 2. Désactivation CSRF (nécessaire pour les APIs Stateless/Postman)
            .csrf(csrf -> csrf.disable())
            
            // 3. Gestion de session Stateless (pas de cookies de session côté serveur)
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            
            // 4. Autorisations des routes
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**").permitAll() 
                .requestMatchers("/api/cercueils/**").permitAll() 
                .requestMatchers("/api/ceremonies/**").permitAll()
                .requestMatchers("/api/defunts/**").permitAll()
                .requestMatchers("/api/familles/**").permitAll()
                .requestMatchers("/api/corbillards/**").permitAll()
                .requestMatchers("/api/reservations/**").permitAll()
                .requestMatchers("/api/factures/**").permitAll()
                .requestMatchers("/api/paiements/**").permitAll()
                .requestMatchers("/api/dossiers/**").permitAll()
                .anyRequest().authenticated()
            )
            
            // 5. Désactivation des interfaces par défaut
            .formLogin(form -> form.disable())
            .httpBasic(basic -> basic.disable());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Configuration Centralisée du CORS
     * Cette méthode remplace le WebMvcConfigurer pour être compatible avec Spring Security
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        
        // Liste explicite des origines (INTERDIT de mettre "*" avec allowCredentials(true))
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200", "http://localhost:4201"));
        
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type", "Accept", "X-Requested-With"));
        
        // Autorise l'envoi de credentials (Cookies, Headers d'auth)
        configuration.setAllowCredentials(true);
        
        // Applique cette config à toutes les routes de l'API
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}