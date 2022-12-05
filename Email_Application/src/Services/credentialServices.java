package Services;

import interfaces.ICredentialService;
import model.Employee;

public class CredentialServiceImpl implements ICredentialService {
	private String companyName;

	public CredentialServiceImpl(String companyName) {
		this.companyName = companyName;
	}

	//override
	public String generatePassword() {
		return "181E@wFT";
	}

	//override
	public String generateEmailAddress(Employee employee) {
		if (employee != null && ((employee.getFirstName() != null && !employee.getFirstName().isEmpty())
				|| employee.getLastName() != null && !employee.getLastName().isEmpty())) {
			return employee.getFirstName()
					.concat(employee.getFirstName())
					.concat("@")
					.concat(employee.getDepartment())
					.concat(".")
					.concat(companyName);
		} else {
			System.out.println("Unable to create email adderss as firstName and lastName is either null or empty.");
		}
		return null;
	}

	//override

	public void showCredentials(Employee employee) {
		System.out.println("\n\n-----Employee Details are below------");
		if (employee != null) {
			if (employee.getEmail() != null && !employee.getEmail().isEmpty()) {
				System.out.println("Email Id : " + employee.getEmail());
			}
			if (employee.getPassword() != null && !employee.getPassword().isEmpty()) {
				System.out.println("Password : " + employee.getPassword());
			}
		}
		System.out.println("-------------------------------------\n\n");
	}

}
