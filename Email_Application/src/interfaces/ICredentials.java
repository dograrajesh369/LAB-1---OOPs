package interfaces;

import model.employee;

public interface ICredentials {
	String generatePassword();
	String generateEmailAddress(employee employee);
	void showCredentials(employee employee);
	
}
