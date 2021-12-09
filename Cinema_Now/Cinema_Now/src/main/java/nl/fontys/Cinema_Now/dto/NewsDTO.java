package nl.fontys.Cinema_Now.dto;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsDTO {
        private String id;
        private String title;
        private String description;
        private String postedAt;
}


