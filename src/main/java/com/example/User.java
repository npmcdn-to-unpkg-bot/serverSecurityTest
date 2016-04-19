package com.example;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sebastian Börebäck on 2016-04-19.
 */
@Document(collection = "User")
public class User implements UserDetails {

	/**
	 *
	 */
	private static final long serialVersionUID = 7206798553934461899L;

	@Id
	private Long id;

	@NotNull
	@Size(min = 1, max = 20)
	private String username;

	@NotNull
	@Size(min = 4, max = 8)
	private String password;



	private Set<SimpleGrantedAuthority> authorities = new HashSet<SimpleGrantedAuthority>();
	private boolean accountNonExpired=true;
	private boolean isEnabled=true;
	private boolean isAccountNonLocked=true;
	private boolean isCredentialsNonExpired=true;

	@Override
	public Collection<SimpleGrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.isAccountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.isCredentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return this.isEnabled;
	}
}