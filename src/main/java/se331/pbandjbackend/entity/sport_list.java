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
public class sport_list {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @EqualsAndHashCode.Exclude

        String sport_title;
        String medal_type;



        @OneToMany(mappedBy = "Sport")
        @Builder.Default
        List<User> ownEvents = new ArrayList<>();
    }


