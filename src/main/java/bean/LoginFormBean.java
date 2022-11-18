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
public class LoginFormBean extends FormBean {
	private String companyEmail;
	private String password;
	
	@Override
	public boolean validate(UserService userService) {
		if(StringUtils.isEmpty(companyEmail)) {
			addError("email", "Email required.");
		}
		
		if(StringUtils.isEmpty(password)) {
			addError("password", "Password required.");
		}
		
		if(!userService.findEmailAndPassword(companyEmail, password)) {
			addError("password", "Email and password do not match/exist!");
		}
		
		return getErrors().isEmpty();
	}
	
}
