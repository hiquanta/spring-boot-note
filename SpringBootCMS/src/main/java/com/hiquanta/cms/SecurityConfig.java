package com.hiquanta.cms;

import com.hiquanta.cms.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;

/**
 * Created by hiquanta on 2016/10/20.
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public UserService userService() {
        return new UserService();
    }

    @Bean
    public TokenBasedRememberMeServices rememberMeServices() {
        return new TokenBasedRememberMeServices("remember-me-key", userService());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new StandardPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .eraseCredentials(true)
                .userDetailsService(userService())
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
             //   .csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin/**","/swagger-ui.html").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/signin")
                .permitAll()
                .failureUrl("/signin?error=1")
                .loginProcessingUrl("/authenticate")
                .and()
                .logout()
                .logoutUrl("/logout")
                .permitAll()
                .logoutSuccessUrl("/signin?logout")
//                .and()
//                .antMatcher("/v1/**")
//                .httpBasic()
                .and()
                .rememberMe()
                .rememberMeServices(rememberMeServices())
                .key("remember-me-key");
    }
}
