package bean;

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
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String confirmPassword;
	
	@Override
	public boolean validate() {
		if(StringUtils.isEmpty(username)) {
			addError("username", "Username required.");
		}
		
		if(StringUtils.isEmpty(firstName)) {
			addError("firstName", "First name required.");
		}
		
		if(StringUtils.isEmpty(lastName)) {
			addError("lastName", "Last name required.");
		}
		
		if(StringUtils.isEmpty(email)) {
			addError("email", "Email required.");
		}
		
		if(StringUtils.isEmpty(password)) {
			addError("password", "Password required.");
		} else if(!password.equals(confirmPassword)) {
			addError("password", "Please confirm password.");
		}
		
		return getErrors().isEmpty();
	}
	
}
