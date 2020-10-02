package com.gregorhue.theblog.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.gregorhue.blog.model.Comment;
import com.gregorhue.blog.model.Person;
import com.gregorhue.blog.model.Post;
import com.gregorhue.blog.model.Role;
import com.gregorhue.blog.model.User;
import com.gregorhue.blog.model.User.UserBuilder;
import com.gregorhue.blog.model.User.UserBuilderImpl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * Created by gregorhue on 02.10.2020.
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true, exclude = "roles")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class User extends Person {

	@NotNull
	@Column(unique = true)
	private String username;

	
	@Column
	private String password;

	@Column
	private String email;

	@ManyToMany
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	@Builder.Default
	private Set<Role> roles = new HashSet<>();

	@OneToMany(mappedBy = "author")
	@Builder.Default
	private Set<Comment> comments = new HashSet<>();

	@OneToMany(mappedBy = "author")
	@Builder.Default
	private Set<Post> posts = new HashSet<>();
	
	private LocalDateTime deletedTs;
}
