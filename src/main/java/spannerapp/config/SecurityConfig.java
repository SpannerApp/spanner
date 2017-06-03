package spannerapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

/**
 * Created by Siekacz on 03.06.2017.
 */
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    DataSource dataSource;
//
//    private static final String CHECK_USER_BY_USERNAME = "SELECT Username, Password From AuthUser where Username=?";
//    private static final String CHECK_AUTH_BY_USERNAME_ROLES = "SELECT au.Login, RoleName FROM AuthUser au join UserRoles ur on au.UserID = ur.UserID join Roles r on ur.RoleID = r.RoleID WHERE au.Login=?";
//
//    @Autowired
//    public void configureAuthentication(AuthenticationManagerBuilder auth) throws Exception{
//        auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(CHECK_USER_BY_USERNAME).authoritiesByUsernameQuery(CHECK_AUTH_BY_USERNAME_ROLES);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.httpBasic().and().authorizeRequests().antMatchers("/**").access("hasRole('ADMIN')").
//                anyRequest().fullyAuthenticated().and().formLogin().loginPage("/index.html").usernameParameter("username").passwordParameter("password").
//                and().exceptionHandling().accessDeniedPage("/reqister.html").and().csrf();
//    }
//
//}

public class SecurityConfig{}