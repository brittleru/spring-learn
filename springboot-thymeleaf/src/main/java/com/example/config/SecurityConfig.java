package com.example.config;

import com.example.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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


//    @Autowired
//    @Qualifier("securityDataSource")
//    private DataSource securityDataSource;

    @Autowired
    @Qualifier("customUserDataSource")
    private DataSource customUserDataSource;

    @Autowired
    private UserService userService;

    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;


    /**
     * This project makes use of in-memory authentication. We set up the following users
     *
     * +---------+----------+-----------------------------+
     * | user id | password |            roles            |
     * +---------+----------+-----------------------------+
     * | john    | test123   | ROLE_EMPLOYEE              |
     * | mary    | test123   | ROLE_EMPLOYEE, ROLE_MANAGER|
     * | susan   | test123   | ROLE_EMPLOYEE, ROLE_ADMIN  |
     * +---------+----------+-----------------------------+
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // use jdbc authentication... oh yeah!!!!!
//        auth.jdbcAuthentication().dataSource(securityDataSource);
        auth.authenticationProvider(authenticationProvider());

//        // add our users for in memory authentication
//        UserBuilder users = User.withDefaultPasswordEncoder();
//
//        auth.inMemoryAuthentication()
//                .withUser(users.username("john").password("test123").roles("EMPLOYEE"))
//                .withUser(users.username("mary").password("test123").roles("EMPLOYEE", "MANAGER"))
//                .withUser(users.username("susan").password("test123").roles("EMPLOYEE", "ADMIN"));
    }

    /**
     * - Employee role: users in this role will only be allowed to list employees.
     * - Manager role: users in this role will be allowed to list, add and update employees.
     * - Admin role: users in this role will be allowed to list, add, update and delete employees.
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/employees/show-form*").hasAnyRole("MANAGER", "ADMIN")
                .antMatchers("/employees/save*").hasAnyRole("MANAGER", "ADMIN")
                .antMatchers("/employees/delete").hasRole("ADMIN")
                .antMatchers("/employees/**").hasRole("EMPLOYEE")
                .antMatchers("/resources/**").permitAll()
                .and()
                .formLogin()
                  .loginPage("/show-login")
                  .loginProcessingUrl("/auth-user")
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
        authenticationProvider.setUserDetailsService(userService);    // set the custom user details service
        authenticationProvider.setPasswordEncoder(passwordEncoder()); // set the password encoder - bcrypt

        return authenticationProvider;
    }
}
