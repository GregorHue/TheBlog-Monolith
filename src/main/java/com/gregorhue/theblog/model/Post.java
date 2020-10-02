package com.gregorhue.theblog.model;

/**
 * Created by gregorhue on 02.10.2020.
 */
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true, exclude = "author")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Post extends BaseEntity {

	@NotEmpty
	@Column
	private String title;

	@NotEmpty
	@Size(max = 1000)
	@Column(length = 1000)
	private String content;

	@Column(columnDefinition = "int default 0")
	private Integer likes;

	@NotNull
	@ManyToOne
	@JoinColumn
	private Category category;

	@NotNull
	@ManyToOne
	@JoinColumn
	private User author;

	@OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
	@Builder.Default
	private Set<Comment> comments = new HashSet<>();
	
	@Transient
	private String authorname;
}

