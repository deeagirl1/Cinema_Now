package nl.fontys.Cinema_Now.handlers;

import lombok.Getter;
import lombok.Setter;

public class InvalidField extends Throwable {
    private static final long serialVersionUID = 1L;

    private @Getter @Setter
    String message;

    public InvalidField(String message)
    {
        this.setMessage(message);
    }
}
