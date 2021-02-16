package graduationCalculator;

/**
 * 
 * @author Jason McKillen QUB MSc Software Development
 *
 */
public class Student {
	
	// Instantiates reference variables
	private int studentNumber;
	private String firstName;
	private String lastName;
	private int programming;
	private int computingFoundations;
	private int databases;
	private int webDevelopment;
	private int softwareEngineering;
	private String classification;
	
	// Default constructor
	public Student() {
	
	}
	
	// Constructor with all arguments except classification, as classification is set elsewhere.
	public Student(int studentNumber, String firstName, String lastName, int programming, int computingFoundations,
			int databases, int webDevelopment, int softwareEngineering) {
		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.programming = programming;
		this.computingFoundations = computingFoundations;
		this.databases = databases;
		this.webDevelopment = webDevelopment;
		this.softwareEngineering = softwareEngineering;
	}

	public int getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getProgramming() {
		return programming;
	}

	public void setProgramming(int programming) {
		this.programming = programming;
	}

	public int getComputingFoundations() {
		return computingFoundations;
	}

	public void setComputingFoundations(int computingFoundations) {
		this.computingFoundations = computingFoundations;
	}

	public int getDatabases() {
		return databases;
	}

	public void setDatabases(int databases) {
		this.databases = databases;
	}

	public int getWebDevelopment() {
		return webDevelopment;
	}

	public void setWebDevelopment(int webDevelopment) {
		this.webDevelopment = webDevelopment;
	}

	public int getSoftwareEngineering() {
		return softwareEngineering;
	}

	public void setSoftwareEngineering(int softwareEngineering) {
		this.softwareEngineering = softwareEngineering;
	}
	
	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	// Programming as a subject is double-weighted, this line accounts for that.
	public double calculateAverage() {
		double totalMarks = ((this.programming * 2) + this.computingFoundations + this.databases + this.webDevelopment + this.softwareEngineering);
		double averageMarks = totalMarks / 6;
		return averageMarks;
	}
}
