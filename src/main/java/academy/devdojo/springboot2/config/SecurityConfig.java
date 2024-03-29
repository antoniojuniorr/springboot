//package academy.devdojo.springboot2.config;
//
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
//
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//		.and()
//		.authorizeRequests().anyRequest().authenticated().and().httpBasic();
//	}
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//		auth.inMemoryAuthentication()
//			.withUser("william")
//			.password(passwordEncoder.encode("teste"))
//			.roles("USER", "ADMIN")
//			.and()
//			.withUser("devdojo")
//			.password(passwordEncoder.encode("academy"))
//			.roles("USER");
//	}
//	
//}
