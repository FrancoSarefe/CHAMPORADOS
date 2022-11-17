package entity;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class PersonEntity {
	private String personNumber;
	private String firstName;
	private String middleName;
	private String lastName;
	private Date birthDate;
	private String contactNumber;
}
