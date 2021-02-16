package graduationCalculator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Student> students = new ArrayList<Student>();
		loadStudents(students);
		calculateClassifications(students);
		writeClassificationsToFile(students);
	}
	public static void loadStudents(ArrayList<Student> students) {
		try {
			File file = new File("ModuleScoresMSc.csv");
			String line = null;
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			line = br.readLine();
			line = br.readLine();
			br.readLine();
			while(line != null) {
				Student student = new Student();
				String[] delimiter = line.split(",");
				student.setStudentNumber(Integer.parseInt(delimiter[0]));
				student.setFirstName(delimiter[1]);
				student.setLastName(delimiter[2]);
				student.setProgramming(Integer.parseInt(delimiter[3]));
				student.setComputingFoundations(Integer.parseInt(delimiter[4]));
				student.setDatabases(Integer.parseInt(delimiter[5]));
				student.setWebDevelopment(Integer.parseInt(delimiter[6]));
				student.setSoftwareEngineering(Integer.parseInt(delimiter[7]));
				students.add(student);
				line = br.readLine();
				
			}
			br.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		public static void calculateClassifications(ArrayList<Student> students) throws IllegalArgumentException {
			for(Student student:students) {
				if(student.calculateAverage() >= 70 && student.calculateAverage() <=100) {
					student.setClassification("1:1");
				} else if (student.calculateAverage() >= 60 && student.calculateAverage() <=69) {
					student.setClassification("2:1");
				} else if (student.calculateAverage() >= 50 && student.calculateAverage() <=59) {
					student.setClassification("2:2");
				} else if (student.calculateAverage() >= 0 && student.calculateAverage() <=49) {
					student.setClassification("Fail");
				} else {
					throw new IllegalArgumentException("Value of average grade must be between 0 and 100 (inclusive).");
				}
			}
		}
		
		public static void writeClassificationsToFile(ArrayList<Student> students) {
			File file = new File("Graduates.txt");
			try {
				FileWriter fw = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(fw);
				for(Student student:students) {
					bw.write(student.getStudentNumber() + " " + student.getFirstName() + " " + student.getLastName() + " " + student.getClassification());
					bw.newLine();
				}
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
	}
	
	
