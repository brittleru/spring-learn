package com.example.config;

import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // add a reference to our security data source
//    @Autowired
//    private DataSource securityDataSource;

    // add a reference to our security data source
    @Autowired
    private UserService userService;

    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }


    //    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        // use jdbc auth... oh yeah!!!!
//        auth.jdbcAuthentication().dataSource(securityDataSource);
//
//        // NO MORE HARDCODED USERS
////        // add our users for in memory authentication
////        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
////
////        auth.inMemoryAuthentication().withUser(userBuilder.username("susan").password("test123").roles("EMPLOYEE"));
////        auth.inMemoryAuthentication().withUser(userBuilder.username("medi").password("test123").roles("EMPLOYEE", "MANAGER", "ADMIN"));
////        auth.inMemoryAuthentication().withUser(userBuilder.username("sebi").password("test123").roles("EMPLOYEE", "ADMIN"));
//
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/").hasRole("EMPLOYEE")
                .antMatchers("/leaders/**").hasRole("MANAGER")
                .antMatchers("/systems/**").hasRole("ADMIN")
                .and()
                .formLogin()
                    .loginPage("/showLoginPage")
                    .loginProcessingUrl("/authenticateUser")
                    .successHandler(customAuthenticationSuccessHandler)
                    .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied");

    }

    // beans
    // bcrypt bean definition
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    // authenticationProvider bean definition
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userService); // set the custom user details service
        authenticationProvider.setPasswordEncoder(passwordEncoder()); // set the password encoder - bcrypt

        return authenticationProvider;
    }
}
