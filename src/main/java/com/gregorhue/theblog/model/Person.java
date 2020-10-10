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

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Column(name="CITY")
	private String city;

	@Column(name="STREET")
	private String street;

	@Column(name = "HOUSE_NUMBER")
	private Integer houseNumber;

	@Column(name = "POSTAL_CODE")
	private String postalCode;
}

