package com.gregorhue.theblog.model;

/**
 * Created by gregorhue on 02.10.2020.
 */
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true, exclude = {"author", "post"})
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Comment extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 7889406006566932078L;

	@NotEmpty
	@Size(max = 1000)
	@Column(length = 1000)
	private String content;

	@Column(columnDefinition = "int default 0")
	private Integer likes;

	@NotNull
	@ManyToOne
	@JoinColumn
	private User author;

	@NotNull
	@ManyToOne
	@JoinColumn
	private Post post;
	
	@Transient
	private String authorname;
}

