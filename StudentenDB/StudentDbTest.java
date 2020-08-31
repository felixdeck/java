package StudentenDB;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.nio.charset.Charset;

public class StudentDbTest {
	public static void main(String[] args) {
		StudentDb studentDb = new StudentDb();
		Student student1= new Student(12349999, "Deckenbach", "Felix");
		Student student2= new Student(123457, "Deckenbach", "Laureen");
		Student student3= new Student(123458, "Radies", "Thorben");
		Student student4= new Student("654321; Elvira; Stockmann");
	
//		studentDb.addStudent(student1);
//		studentDb.addStudent(student2);
//		studentDb.addStudent(student3);
//		studentDb.addStudent(student4);

		studentDb.print();
//		try(Writer writer = new FileWriter("\\C:\\Users\\deckenf\\Documents\\Studium\\Semester 5\\"
//				+ "JAVA für C++ Entwickler\\StudentDB.txt")){
//			studentDb.write(writer);
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
		
		try(InputStream inStream = new FileInputStream("\\C:\\Users\\deckenf\\Documents\\Studium\\Semester 5\\"
				+ "JAVA für C++ Entwickler\\StudentDB.txt")){
			BufferedReader reader = new BufferedReader(new InputStreamReader(inStream,Charset.forName("utf-8")));	
			try {
				studentDb.read(reader);
				studentDb.print();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}catch(IOException e) {
			System.out.println("IOE");
		}
	}
}
