package kg.edu.alatoo.delivery.config;

import kg.edu.alatoo.delivery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf()
                    .disable()
                .authorizeRequests()
                    //No role
                    .antMatchers("/registration", "/swagger-ui/index.html").not().fullyAuthenticated()
                    //Admin role
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .antMatchers("/order").hasRole("USER")
                    //Everyone
                    .antMatchers("/", "/resources/**", "/v3/**", "/swagger-ui/index.html").permitAll()
                //Authenticated
                .anyRequest().authenticated()
                .and()
                    //Login
                    .formLogin()
                    .loginPage("/login")
                    //Redirect to main page
                    .defaultSuccessUrl("/", true)
                    .permitAll()
                .and()
                    .logout()
                    .permitAll()
                    .logoutSuccessUrl("/");
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
    }
}
