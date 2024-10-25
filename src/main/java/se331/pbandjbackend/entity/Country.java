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

        String countryName;
        String desc;
        String img;

        Integer amountGold;
        Integer amountSilver;
        Integer amountBronze;
        Integer total;

        String firstOlympicAppearance;
        Integer numberOfOlympicsParticipatedIn;

        @OneToMany(mappedBy = "gold")
        @Builder.Default
        List<Sport> goldMedals = new ArrayList<>();

        @OneToMany(mappedBy = "silver")
        @Builder.Default
        List<Sport> silverMedals = new ArrayList<>();

        @OneToMany(mappedBy = "bronze")
        @Builder.Default
        List<Sport> bronzeMedals = new ArrayList<>();
}

