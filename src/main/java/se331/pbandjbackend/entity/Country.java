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
public class Country {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @EqualsAndHashCode.Exclude
        Long id;
        String country;
        String desc;
        String img;
        String firstOlympicAppearance;
        Long gold;
        Long silver;
        Long bronze;
        Long total;
        Long  numberOfOlympicsParticipatedIn;


    }

