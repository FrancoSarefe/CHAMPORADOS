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
public class UserEntity {
	private String userNumber;
	private String companyEmail;
	private String password;
	private Date dateCreated;
	private Boolean isAdmin;
	private String walletNumber;
	private String personNumber;
}
