package nl.fontys.Cinema_Now.Model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity @Data
@AllArgsConstructor @NoArgsConstructor
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name ="uuid2", strategy = "uuid2")
    @Column(length = 36)
    private String id;
    private String name;


}
