package com.lauracarpaciu.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Qualifier("dataSource")
    @Autowired
    private javax.sql.DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        super.configure(auth);

        auth.inMemoryAuthentication().withUser("admin").password("1234").roles("USER", "ADMIN");
        auth.inMemoryAuthentication().withUser("user").password("1234").roles("USER");


        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username as principal, password as credentials,active from users where username=?")
                .authoritiesByUsernameQuery("select username as principal, roles as role from users_roles where username=?")
                .passwordEncoder(new Md5PasswordEncoder())
                .rolePrefix("ROLE_");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        super.configure(http);
        http.formLogin().loginPage("/login");
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/products").hasRole("USER");
        http.authorizeRequests().antMatchers("/categories/{idCat}", "/categories").hasRole("USER");
        http.authorizeRequests().antMatchers("/categories").hasRole("ADMIN");
        http.exceptionHandling().accessDeniedPage("/403");
    }

}