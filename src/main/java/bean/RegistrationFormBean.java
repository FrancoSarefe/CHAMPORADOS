package bean;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
	public boolean validate() {
		if(StringUtils.isEmpty(companyEmail)) {
			addError("email", "Email required.");
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
