package StudentenDB;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.StringTokenizer;

public class Student implements Cloneable, Comparable<Student>{

	private Integer numMatrikel=0;
	private String firstName="None";
	private String name="None";

	public Student(int numMatrikel, String firstName, String name){
		super();
		this.numMatrikel = numMatrikel;
		this.firstName = firstName;
		this.name = name;
	}

	public Student(String string) {
		StringTokenizer toked=new StringTokenizer(string, ";");
		
		if(toked.countTokens()==3) {
			this.numMatrikel=Integer.parseInt(toked.nextToken().trim());
			this.firstName=toked.nextToken().trim();
			this.name=toked.nextToken().trim();
		}

	}
	public Student clone() {
		Student newStudent = null;
		try {
			newStudent = (Student)super.clone();
		} catch(CloneNotSupportedException e) {
		}
		// Attribut modifizieren
		return newStudent;
	}
	
	public Integer getNumMatrikel() {
		return numMatrikel;
	}

	public void setNumMatrikel(int numMatrikel) {
		this.numMatrikel = numMatrikel;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void print() {
		System.out.println(this.name+", "+this.firstName+" ("+this.numMatrikel+")");
	}
	public void write(Writer out, Student student) throws IOException {
		try{
			String studString = student.getNumMatrikel()+";"+student.getName()+";"+student.getFirstName();
			out.write(studString+System.lineSeparator());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int compareTo(Student o) {
		return this.getNumMatrikel().compareTo(o.getNumMatrikel());
	}
}