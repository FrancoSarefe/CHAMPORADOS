package bean;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import service.UserService;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationFormBean extends FormBean {
	private String firstName;
	private String middleName;
	private String lastName;
	private String companyEmail;
	private String password;
	private String confirmPassword;
	private String birthDate;
	private String contactNumber;
	private BigDecimal amount;
	
	@Override
	public boolean validate(UserService userService) {
		if(StringUtils.isEmpty(companyEmail)) {
			addError("email", "Email required.");
		}
		
		if(userService.findEmail(companyEmail)) {
			addError("email", "Email already exists!");
		}
		
		if(StringUtils.isEmpty(firstName)) {
			addError("firstName", "First name required.");
		}
		
		if(StringUtils.isEmpty(lastName)) {
			addError("lastName", "Last name required.");
		}
		
		if(StringUtils.isEmpty(password)) {
			addError("password", "Password required.");
		} else if(!password.equals(confirmPassword)) {
			addError("password", "Please confirm password.");
		}
		
		return getErrors().isEmpty();
	}
	
}
