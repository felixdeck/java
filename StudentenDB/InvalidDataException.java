package StudentenDB;

import java.io.BufferedReader;
import java.io.LineNumberReader;

public class InvalidDataException extends Exception{
public InvalidDataException(LineNumberReader lineReader, String errMsg) {

	super("Import von Datensatz in StudentenDB-File nicht möglich. " + errMsg);
}
}
