package com.gregorhue.theblog.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

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
public class User extends Person implements Serializable {

	private static final long serialVersionUID = 4305712957311775612L;


	@NotNull
	@Column(name="USERNAME", unique = true)
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "EMAIL")
	private String email;

	@ManyToMany
	@JoinTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
	@Builder.Default
	private Set<Role> roles = new HashSet<>();

	@OneToMany(mappedBy = "author")
	@Builder.Default
	private Set<Comment> comments = new HashSet<>();

	@OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
	@Builder.Default
	private Set<Post> posts = new HashSet<>();
	
	@Column(name="DELETED_TS", columnDefinition = "TIMESTAMP")
	private LocalDateTime deletedTs;
}
