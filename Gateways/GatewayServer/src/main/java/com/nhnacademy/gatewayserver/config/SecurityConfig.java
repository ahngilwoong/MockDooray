package com.nhnacademy.gatewayserver.config;

import com.nhnacademy.gatewayserver.auth.LoginSuccessHandler;
import com.nhnacademy.gatewayserver.service.impl.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/mockdooray/**","/login")
                .authenticated()
//                .antMatchers("/dooray/**","/login")
//                .authenticated()
            .anyRequest().permitAll()
            .and().formLogin()
                .successHandler(loginSuccessHandler(null))
            .loginPage("/login")
            .usernameParameter("id")
            .passwordParameter("pwd")
            .loginProcessingUrl("/login")
            .permitAll()
            .and()
            .logout()
            .logoutUrl("/logout")
            .and()
            .csrf()
            .disable();

        http.headers().frameOptions().sameOrigin();

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/ignore1", "/ignore2");
    }

    @Bean
    public AuthenticationProvider authenticationProvider(
        CustomUserDetailsService customUserDetailsService) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(customUserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationSuccessHandler loginSuccessHandler(
        RedisTemplate<String, String> redisTemplate) {
        return new LoginSuccessHandler(redisTemplate);
    }

//    @Bean
//    public ClientRegistrationRepository clientRegistrationRepository() {
//        return new InMemoryClientRegistrationRepository(github());
//    }
//
//    @Bean
//    public OAuth2AuthorizedClientService authorizedClientService() {
//        return new InMemoryOAuth2AuthorizedClientService(clientRegistrationRepository());
//    }

//    private ClientRegistration github() {
//        return CommonOAuth2Provider.GITHUB.getBuilder("github")
//            .clientId("")
//            .clientSecret("")
//            .scope("")
//            .redirectUri("http://localhost:8080/login/oauth2/code/github")
//            .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//            .build();
//    }

}
