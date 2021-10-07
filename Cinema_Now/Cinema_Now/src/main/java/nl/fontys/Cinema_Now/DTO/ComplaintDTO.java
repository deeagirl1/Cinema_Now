package nl.fontys.Cinema_Now.DTO;

import lombok.Getter;
import lombok.Setter;
import nl.fontys.Cinema_Now.Modules.Complaint;

import java.util.Date;

public class ComplaintDTO extends Complaint {
    public @Getter @Setter String sender;
    public ComplaintDTO(String title, String container, Date sentDate, String sender) {
        super(title, container, sentDate);
        this.sender = sender;
    }
}
