package restApi.exceptions;

public class ByCeroException extends Exception {

    private static final long serialVersionUID = -1344640670884805385L;

    public static final String DESCRIPTION = "Error división por cero";

    public static final int CODE = 666;

    public ByCeroException() {
        this("");
    }

    public ByCeroException(String detail) {
        super(DESCRIPTION + ". " + detail + ". CODE: " + CODE);
    }

}
