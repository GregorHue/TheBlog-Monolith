package com.gregorhue.theblog.model;

/**
 * Created by gregorhue on 02.10.2020.
 */
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Category extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 8949525803601019959L;
	@Column
	private String name;
}
