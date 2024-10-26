package se331.pbandjbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SportDTO {
    Long id;
    String title;
    SportCountryDTO gold;
    SportCountryDTO silver;
    SportCountryDTO bronze;

}
