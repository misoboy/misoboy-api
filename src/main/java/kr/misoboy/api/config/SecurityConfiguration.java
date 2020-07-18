package kr.misoboy.api.config;

import kr.misoboy.api.common.SecurityConst;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final String[] AUTH_WHITELIST = {
            "/h2-console/**",
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**"
    };

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser(SecurityConst.API_ACCESS_USER_ID)
                .password("{noop}" + SecurityConst.API_ACCESS_USER_PWD)
                .roles(SecurityConst.API_ACCESS_USER_ROLE);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(AUTH_WHITELIST).permitAll()
                .antMatchers("/v1/**").hasRole(SecurityConst.API_ACCESS_USER_ROLE)
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .headers().frameOptions().sameOrigin()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint())
                .accessDeniedHandler(accessDeniedHandler())
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    private AuthenticationEntryPoint authenticationEntryPoint(){
        return (request, response, e) -> response.setStatus(HttpStatus.UNAUTHORIZED.value());
    }

    private AccessDeniedHandler accessDeniedHandler(){
        return (request, response, e) -> response.setStatus(HttpStatus.FORBIDDEN.value());
    }
}
