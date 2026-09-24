package com.example.boardadmin.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.boardadmin.security.AdminUserDetailsService;

import jakarta.servlet.DispatcherType;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class SecurityConfig {

	private final AdminUserDetailsService adminUserDetailsService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	private DaoAuthenticationProvider adminAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider(adminUserDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.csrf(csrf -> csrf.disable())
			.authenticationProvider(adminAuthenticationProvider())
			.authorizeHttpRequests(auth -> auth
					.dispatcherTypeMatchers(DispatcherType.FORWARD, DispatcherType.ERROR).permitAll()

					.requestMatchers(
							"/admin/login",
							"/admin/loginPost",
							"/css/**",
							"/js/**",
							"/images/**",
							"/favicon.ico"
					).permitAll()

					.requestMatchers("/admin/admins/**").hasRole("MASTER")
					.requestMatchers("/admin/**").hasAnyRole("MASTER", "MANAGER", "VIEWER")

					.anyRequest().denyAll()
				)
				.formLogin(form -> form
						.loginPage("/admin/login")
						.loginProcessingUrl("/admin/loginPost")
						.usernameParameter("adminId")
						.passwordParameter("password")
						.defaultSuccessUrl("/admin", true)
						.failureUrl("/admin/login?error=true")
						.permitAll()
				)
				.logout(logout -> logout
					.logoutUrl("/admin/logout")
					.logoutSuccessUrl("/admin/login?logout=true")
					.invalidateHttpSession(true)
					.deleteCookies("ADMINSESSIONID")
					.permitAll()
				);

		return http.build();
	}
}
