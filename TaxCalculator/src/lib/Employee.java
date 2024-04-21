package lib;

import java.time.LocalDate;
import lib.EmploymentDetails.Gender;

public class Employee {

	private String employeeId;
	private PersonalDetails personalDetails;
    private EmploymentDetails employmentDetails;
    private FamilyDetails familyDetails;
	
	public Employee(String employeeId, String firstName, String lastName, String idNumber, String address, LocalDate dateJoined, boolean isForeigner, Gender gender) {
		this.employeeId = employeeId;
		this.personalDetails = new PersonalDetails(firstName, lastName, idNumber, address);
        this.employmentDetails = new EmploymentDetails(dateJoined, isForeigner, gender);
        this.familyDetails = new FamilyDetails();
	}
	
	public int calculateAnnualIncomeTax() {
        return employmentDetails.getAnnualIncomeTax(familyDetails.getSpouseIdNumber(), familyDetails.getChildCount());
    }
	
	
	class PersonalDetails {
		private String firstName;
		private String lastName;
		private String idNumber;
		private String address;
	
		public PersonalDetails(String firstName, String lastName, String idNumber, String address) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.idNumber = idNumber;
			this.address = address;
		}
	}

}


