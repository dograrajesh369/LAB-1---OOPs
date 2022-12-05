package main;

import java.util.Scanner;

import interfaces.ICredentials;
import model.employee;
import Services.CredentialServiceImpl;


public class EmailApplication {
	
	public static <ICredential> void main(String args[]) {
		EmailApplication application = new EmailApplication();
		Scanner scanner = new Scanner(System.in);
		ICredential credential = new ICredential("rdx.com");
		int option = 0;
		do {	
			System.out.println("1. Technical");
			System.out.println("2. Admin");
			System.out.println("3. Human Resource");
			System.out.println("4. Legal");
			System.out.println("5. Exit");
			System.out.println("Enter Your Option : ");
			option = scanner.nextInt();
			
			switch (option) {
			case 1:
				application.generateEmailAndPassword(scanner, credential, "tech");
				break;
			case 2:
				application.generateEmailAndPassword(scanner, credential, "admin");
				break;
			case 3:
				application.generateEmailAndPassword(scanner, credential, "hr");
				break;
			case 4:
				application.generateEmailAndPassword(scanner, credential, "legal");
				break;
			case 5:
				System.out.println("Exiting from Email Application.");
				scanner.close();
				System.exit(0);
				break;
			default:
				System.out.println("Invalid option choosen by you.");
				break;
			}
		} while (option != 5);
	}

	private void generateEmailAndPassword(Scanner scanner, ICredentialService credentialService, String department) {
		System.out.println("Enter Your FirstName : ");
		String firstName = scanner.next();
		System.out.println("Enter Your LastName : ");
		String lastName = scanner.next();
		Employee employee = new Employee(firstName, lastName);
		employee.setDepartment(department);
		employee.setEmail(credentialService.generateEmailAddress(employee));
		employee.setPassword(credentialService.generatePassword());
		credentialService.showCredentials(employee);
	}
}
