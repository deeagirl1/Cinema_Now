package nl.fontys.Cinema_Now.Handlers;

import lombok.Getter;
import lombok.Setter;

public class InvalidFieldException extends Throwable {
    private static final long serialVersionUID = 1L;

    private @Getter @Setter
    String message;

    public InvalidFieldException(String message)
    {
        this.setMessage(message);
    }
}