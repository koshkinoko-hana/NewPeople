package newpeople.Request.model.Exception;

public class UnExpectedEnumValueException extends RuntimeException {

    public UnExpectedEnumValueException(String name) {
        super("Cannot recognize " + name  + " value");
    }

}
