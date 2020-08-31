package StudentenDB;

public class MaximumNumberOfStudentsExeededException extends Exception {
	public MaximumNumberOfStudentsExeededException() {
		super("Die maximale Aufnahme an Studenten in der Datenbank wurde erreicht.");
	}
}
