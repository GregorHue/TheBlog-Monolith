package com.gregorhue.theblog.model;

/**
 * Created by gregorhue on 02.10.2020.
 */
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@SuperBuilder
public class Person extends BaseEntity {

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Column
	private String city;

	@Column
	private String street;

	@Column
	private Integer houseNumber;

	@Column
	private String postalCode;
}

