package SpringBoot.EmployeeBook.Exception;


public class APIException extends RuntimeException {
    private int statusCode;

    public APIException(String message) {
        super(message);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}

