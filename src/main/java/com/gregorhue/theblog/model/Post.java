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

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true, exclude = "author")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Post extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1860430367285107005L;

	@NotEmpty
	@Column(name="TITLE")
	private String title;

	@NotEmpty
	@Size(max = 1000)
	@Column(name="CONTENT", length = 1000)
	private String content;

	@Column(name="LIKES", columnDefinition = "int default 0")
	private Integer likes;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CATEGORY_ID")
	private Category category;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="AUTHOR_ID")
	private User author;

	@OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
	@Builder.Default
	private Set<Comment> comments = new HashSet<>();
	
	@Transient
	private String authorname;
}

