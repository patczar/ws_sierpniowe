package waluty.pobieranie;

public class BrakDanych extends Exception {

	public BrakDanych() {
		super();
	}

	public BrakDanych(String message) {
		super(message);
	}

	public BrakDanych(String message, Throwable cause) {
		super(message, cause);
	}

}
