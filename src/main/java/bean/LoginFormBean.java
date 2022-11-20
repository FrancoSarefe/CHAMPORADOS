package bean;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

import entity.BalanceEntity;
import entity.PersonEntity;
import entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import service.BalanceService;
import service.PersonService;
import service.UserService;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class LoginFormBean extends FormBean {
	private String firstName;
	private String middleName;
	private String lastName;
	private String companyEmail;
	private String password;
	private String birthDate;
	private String contactNumber;
	private String userNumber;
	private String personNumber;
	private String walletNumber;
	private BigDecimal amount;
	
	public LoginFormBean(String companyEmail, String password, UserService userService, PersonService personService, BalanceService balanceService) {
		this.companyEmail = companyEmail;
		this.password = password;
		UserEntity userEntity = userService.findEmailAndPassword(companyEmail, password);
		
		if(!(userEntity == null)) {
			userNumber = userEntity.getUserNumber();
			personNumber = userEntity.getPersonNumber();
			
			PersonEntity personEntity = personService.findByPersonNumber(personNumber);
			firstName = personEntity.getFirstName();
			middleName = personEntity.getMiddleName();
			lastName = personEntity.getLastName();
			birthDate = personEntity.getBirthDate().toString();
			contactNumber = personEntity.getContactNumber();
			
			BalanceEntity balanceEntity = balanceService.findByUserNumber(userNumber);
			walletNumber = balanceEntity.getWalletNumber();
			amount = balanceEntity.getAmount();
			
		}
		
	}
	
	@Override
	public boolean validate() {
		if(StringUtils.isEmpty(companyEmail)) {
			addError("email", "Email required.");
		}
		
		if(StringUtils.isEmpty(password)) {
			addError("password", "Password required.");
		}
		
		if(StringUtils.isEmpty(userNumber) || StringUtils.isEmpty(personNumber)) {
			addError("password", "Email and password do not match/exist!");
		}
		
		return getErrors().isEmpty();
	}
	
}
