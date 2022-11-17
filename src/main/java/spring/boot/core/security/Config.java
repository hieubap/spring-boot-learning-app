package spring.boot.core.security;

import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import spring.boot.core.security.filter.AccessDeniedHandle;
import spring.boot.core.security.filter.AuthenticationEntryPointHandle;
import spring.boot.core.security.filter.JwtFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Config extends WebSecurityConfigurerAdapter {

    private final AccessDeniedHandle accessDeniedHandle;

    private final AuthenticationEntryPointHandle authenticationEntryPointHandle;

    private final SecretKey secretKey;

    @Value("${unAuthorization}")
    private String listUnAuthorization;

    public Config(AccessDeniedHandle accessDeniedHandle,
                  AuthenticationEntryPointHandle authenticationEntryPointHandle,
                  SecretKey secretKey) {
        this.accessDeniedHandle = accessDeniedHandle;
        this.authenticationEntryPointHandle = authenticationEntryPointHandle;
        this.secretKey = secretKey;
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        String[] unAuthorization = listUnAuthorization.split(",");
        for (String s : unAuthorization)
            System.out.println(s);

        http.cors()
                .and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPointHandle)
                .and()
                .addFilterBefore(new JwtFilter(secretKey), UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling().accessDeniedHandler(accessDeniedHandle)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.PUT, unAuthorization).permitAll()
                .antMatchers(HttpMethod.POST, unAuthorization).permitAll()
                .antMatchers(HttpMethod.GET, unAuthorization).permitAll()
                .anyRequest().authenticated();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/users/login", "/users/register");
    }

}

