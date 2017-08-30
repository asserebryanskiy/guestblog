package org.student.guestblog.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Document(collection = "users")
public class User {
	@Id
	private String id;

	@NotBlank
	@Indexed(unique = true)
	@Size(min = 8, max = 32)
	@Field("username")
	private String username;

	@NotBlank
	@Field("password")
	private String password;

	@Transient
	private String confirmPassword;

	@NotBlank
	@Email
	@Field("email")
	private String email;

	@DBRef(db = "roles")
	@Field("roles")
	private Set<Role> roles;

	@DBRef(db = "messages")
	@Field("messages")
	private Set<Message> messages;

	public String getId() {
		return id;
	}

	public User() {
	}

	public User(@NotBlank @Size(min = 8, max = 32) String username, @NotBlank String password, @NotBlank @Email String email) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.roles = new HashSet<>();
		this.messages = new HashSet<>();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Message> getMessages() {
		return messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User user = (User) o;

		if (!username.equals(user.username)) return false;
		if (!password.equals(user.password)) return false;
		return email.equals(user.email);
	}

	@Override
	public int hashCode() {
		int result = username.hashCode();
		result = 31 * result + password.hashCode();
		result = 31 * result + email.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "User{" +
				"id='" + id + '\'' +
				", username='" + username + '\'' +
				", email='" + email + '\'' +
				", roles=" + roles +
				'}';
	}
}
