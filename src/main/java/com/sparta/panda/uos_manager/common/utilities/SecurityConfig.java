package com.sparta.panda.uos_manager.common.utilities;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("panda@panda.com").password(passwordEncoder().encode("panda")).roles("ADMIN")
                .and()
                .withUser("u2").password(passwordEncoder().encode("u2")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN")
                .and()
                .withUser("a").password(passwordEncoder().encode("a")).roles("ADMIN");
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin*").hasRole("ADMIN")
//                .antMatchers("/anonymous*").anonymous()
                .antMatchers("/", "/home", "/css/**", "/images/**", "/webjars/**", "/public/**", "/rooms",
                        "/facilities", "/contactUs", "/login*").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .loginProcessingUrl("/perform_login")
                .defaultSuccessUrl("http://localhost:8080/home", true)
                //.failureUrl("/login.html?error=true")
                .failureUrl("/loginFailure")
                .and()
                .logout()
                .logoutUrl("/perform_logout")
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/home");
//                .csrf().disable()
//                .formLogin()
//                .loginPage("/public/login/login.html")
//                .loginProcessingUrl("/perform_login")
//                .defaultSuccessUrl("/public/home.html",true)
//                .failureUrl("/exceptions/error.html");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
