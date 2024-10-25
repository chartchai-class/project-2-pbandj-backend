package se331.pbandjbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SportCountryDTO {
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
}
