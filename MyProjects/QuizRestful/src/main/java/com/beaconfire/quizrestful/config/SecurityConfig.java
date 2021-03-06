package com.beaconfire.quizrestful.config;


import com.beaconfire.quizrestful.security.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private JwtFilter jwtFilter;

    @Autowired
    public void setJwtFilter(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .addFilterAfter(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/user").hasAuthority("read")
                .antMatchers("/user/*", "/quiz/*").hasAuthority("read")
                .antMatchers("/user/*", "/quiz/*").hasAuthority("write")
                .antMatchers("/user/*", "/quiz/*").hasAuthority("update")
                .antMatchers("/user/*", "/quiz/*").hasAuthority("delete")
                .anyRequest()
                .authenticated();
    }
}
