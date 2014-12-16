package br.com.leonardojgs.scalog.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.leonardojgs.scalog.model.domains.User;
import br.com.leonardojgs.scalog.model.dto.SystemUserDetail;
import br.com.leonardojgs.scalog.model.repositories.UserRepository;

@Configuration
@EnableWebSecurity
public class APPSecuritityContext extends WebSecurityConfigurerAdapter {

	@Autowired private UserRepository userRepository;
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        	.authorizeRequests()
        		.antMatchers("/login", "/authentication")
        			.permitAll()
        		.antMatchers("/app/**")
        			.hasRole("ADMIN")
        .and()
        	.formLogin()
        	.loginPage("/login")
        	.usernameParameter("username")
        	.passwordParameter("password")
        	.loginProcessingUrl("/authentication")
        	.defaultSuccessUrl("/app/logs")
        	.failureUrl("/login?status=failed")
        	
        .and()
        	.logout()
        	.logoutUrl("/logout")
        	.logoutSuccessUrl("/login?status=logout");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService((username) -> {
        	User user = userRepository.findByUsername(username);
        	if(user==null) throw new UsernameNotFoundException(username);
        	return new SystemUserDetail(user);
        }).passwordEncoder(new BCryptPasswordEncoder());
    }
    
}
