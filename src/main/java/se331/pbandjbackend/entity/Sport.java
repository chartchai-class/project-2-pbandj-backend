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

    String title;

    @ManyToOne
//    @JoinColumn(name = "gold_country_id") // Not sure if use
    Country gold;

    @ManyToOne
//    @JoinColumn(name = "silver_country_id") // Same
    Country silver;

    @ManyToOne
//    @JoinColumn(name = "bronze_country_id") // here as well
    Country bronze;

}

