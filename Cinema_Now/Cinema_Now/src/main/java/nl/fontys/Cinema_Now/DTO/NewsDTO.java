package nl.fontys.Cinema_Now.DTO;

import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsDTO {

        private @Getter @Setter String title;
        private @Getter @Setter String description;
        private @Getter @Setter String postedAt;
}


