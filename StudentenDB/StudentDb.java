package StudentenDB;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class StudentDb {
	private Map<Integer, Student> students = new HashMap<>();
	private int countStudents = 0;
	private LineNumberReader lineReader=null;
	
	public void addStudent(Student student){
		this.students.put(student.getNumMatrikel(), student);
		countStudents++;
		return;
	}
	public void print(){
//		List<Student> myStudents = new ArrayList<>(students.values());
//		Collections.sort(myStudents);
		List<Integer> keys = new ArrayList<>(students.keySet());
		Collections.sort(keys);
		for(Integer matr:keys) {
			students.get(matr).print();
		}
	}
	public void read(BufferedReader in) throws IOException{
		int lineNumber=0;
		try {
			String studentString = null;
			this.lineReader = new LineNumberReader(in);	// Erzeuge neuen LineNumberReader
			lineReader.setLineNumber(lineNumber);					// Setzte LineNumber auf 0
			while((studentString = in.readLine()) != null){
				Student newStudent = new Student(studentString);
				//Fehlerbehandlung wenn Trenneranzahl nicht passt
				if((new StringTokenizer(studentString,";").countTokens())!=3) {
					throw new IOException(" Zeile " + this.lineReader.getLineNumber() 
						+ " fehlerhaft! Trenneranzahl stimmt nicht");
				}
				else if(students.containsKey(newStudent.getNumMatrikel())) {
					throw new IOException("Doppelt vorkommende Matrikelnummer. Gescheitert in Zeile " 
						+ this.lineReader.getLineNumber());
				}
				else {
					addStudent(newStudent);
					lineNumber++;
					lineReader.setLineNumber(lineNumber);				// Update LineNumber	
				}
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void write(Writer out) {
		try {
			for(Student stud: students.values()) {
				stud.write(out, stud);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
