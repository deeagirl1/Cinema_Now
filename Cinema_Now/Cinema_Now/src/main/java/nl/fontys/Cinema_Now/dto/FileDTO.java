package nl.fontys.Cinema_Now.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class FileDTO {
    private String fileName;
    private byte[] fileData;
}
