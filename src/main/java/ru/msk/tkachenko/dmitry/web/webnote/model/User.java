package ru.msk.tkachenko.dmitry.web.webnote.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class User implements Serializable {
	private Long id;
	
	@NotNull
	@Size(min=5, max=16)
	private String login;

	@NotNull
	@Size(min=5, max=25)
	private String password;
	
	@NotNull
	@Email(message="{email.valid}")
	private String email;
	
	private boolean rememberMe;
	
	public User() {}

	public User(Long id, String login, String password, String email, boolean rememberMe) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.email = email;
		this.rememberMe = rememberMe;
	}
	
	public Long getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(boolean rememberMe) {
		rememberMe = rememberMe;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password + ", email=" + email + ", rememberMe="
				+ rememberMe + "]";
	}
}
