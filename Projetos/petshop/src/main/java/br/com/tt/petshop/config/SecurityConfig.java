package br.com.tt.petshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String[] URLS_ABERTAS = { "/swagger-ui.html", "/webjar/**", "/csrf" };

    @Bean
    public PasswordEncoder getPassEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("gilberto")
                .password(getPassEncoder().encode("imersao"))
                .authorities("admin")
        .and().passwordEncoder(getPassEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(URLS_ABERTAS).permitAll()
                .antMatchers("/unidades").hasAuthority("admin")
                .antMatchers(HttpMethod.GET).permitAll()
                .anyRequest().authenticated().and()
                .httpBasic();
    }
}
