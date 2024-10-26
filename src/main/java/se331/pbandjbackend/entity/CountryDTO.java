package se331.pbandjbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CountryDTO {
    Long id;
    String countryName;
    String description;
    String img;
    Integer amountGold;
    Integer amountSilver;
    Integer amountBronze;
    Integer total;
    String firstOlympicAppearance;
    Integer numberOfOlympicsParticipatedIn;
    List<CountrySportDTO> goldMedals = new ArrayList<>();
    List<CountrySportDTO> silverMedals = new ArrayList<>();
    List<CountrySportDTO> bronzeMedals = new ArrayList<>();
}
