package se331.pbandjbackend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Sport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude

    Long id;
    String sport_title;
    Long gold;
    Long silver;
    Long bronze;


    @OneToMany(mappedBy = "Sport")
    @Builder.Default
    List<User> ownEvents = new ArrayList<>();
}
