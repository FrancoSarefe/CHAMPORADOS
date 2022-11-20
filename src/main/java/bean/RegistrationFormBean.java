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
	
	private UserService userService;
	
	public RegistrationFormBean(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public boolean validate() {
		if(StringUtils.isEmpty(companyEmail)) {
			addError("email", "Email is required.");
		}
		
		if(userService.findEmail(companyEmail)) {
			addError("email", "Email already exists!");
		}
		
		if(StringUtils.isEmpty(firstName)) {
			addError("firstName", "First name is required.");
		}
		
		if(StringUtils.isEmpty(lastName)) {
			addError("lastName", "Last name is required.");
		}
		
		if(StringUtils.isEmpty(birthDate)) {
			addError("birthDate", "Birth date is required.");
		}
		
		if(StringUtils.isEmpty(contactNumber)) {
			addError("contactNumber", "Contact number is required.");
		}
		
		if(StringUtils.isEmpty(password)) {
			addError("password", "Password is required.");
		} else if(!password.equals(confirmPassword)) {
			addError("password", "Please confirm password.");
		}
		
		return getErrors().isEmpty();
	}
	
}
