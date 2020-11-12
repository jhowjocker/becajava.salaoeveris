//package br.app.SalaoEveris.infrastructure.rest.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//	
//	@Bean
//    public UserDetailsService userDetailsService() {
//
//        User.UserBuilder users = User.withDefaultPasswordEncoder();
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(users.username("jhow").password("123456").roles("USER").build());
//        manager.createUser(users.username("admin").password("123456").roles("USER", "ADMIN").build());
//        return manager;
//	}
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//			.anyRequest().authenticated()
//			.and()
//			.httpBasic();
//		
//	}
//
//@Autowired
//public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//	auth.inMemoryAuthentication()
//
//		.withUser("jhow").password("professor").roles("USER")
//		.and()
//		.withUser("admin").password("professor").roles("USER","ADMIN");
//	
//	
//	}
//	
//}
