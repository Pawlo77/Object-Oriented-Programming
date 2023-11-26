package pl.edu.pl.mini.zpoif.gradedtask.first;

public abstract class ParsingException extends Exception {

	private static final long serialVersionUID = 410541016589652113L;

	public ParsingException(String message, Throwable cause) {
		super(message, cause);
	}

	public ParsingException(String message) {
		super(message);
	}
}
