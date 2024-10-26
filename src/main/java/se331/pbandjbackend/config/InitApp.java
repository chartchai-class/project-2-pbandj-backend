package se331.pbandjbackend.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import se331.pbandjbackend.repository.CountryRepository;
import se331.pbandjbackend.repository.SportRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import se331.pbandjbackend.entity.Country;
import se331.pbandjbackend.entity.Sport;


import java.util.List;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {

    final CountryRepository countryRepository;
    final SportRepository sportRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {

        // Initialize Sport
        Sport athleticsW = sportRepository.save(Sport.builder().title("Athletics (Women's 400m)").build()); // 1
        Sport athleticsM = sportRepository.save(Sport.builder().title("Athletics (Men's 400m)").build()); //2
        Sport athleticsWH = sportRepository.save(Sport.builder().title("Athletics (Women's Heptathlon)").build()); //3
        Sport hockeyM = sportRepository.save(Sport.builder().title("Hockey (Men)").build()); //4
        Sport artisticGymnasticsW = sportRepository.save(Sport.builder().title("Artistic Gymnastics (Women's Uneven Bars)").build()); //5
        Sport cyclingRoadW = sportRepository.save(Sport.builder().title("Cycling Road (Women's Road Race)").build()); //6
        Sport canoeSprintM = sportRepository.save(Sport.builder().title("Canoe Sprint (Men's Kayak Double 1000m)").build()); //7
        Sport trampolineM  = sportRepository.save(Sport.builder().title("Trampoline Gymnastics (Men)").build()); //8

        // Initialize Countries
        Country australia = countryRepository.save(Country.builder() //1
                .countryName("Australia")
                .description("Island continent with diverse landscapes, unique wildlife, and a multicultural society.")
                .img("https://upload.wikimedia.org/wikipedia/commons/8/88/Flag_of_Australia_%28converted%29.svg")
                .amountGold(17)
                .amountSilver(8)
                .amountBronze(22)
                .total(47)
                .firstOlympicAppearance("1896")
                .numberOfOlympicsParticipatedIn(32)

                .build());

        Country austria = countryRepository.save(Country.builder() //2
                .countryName("Austria")
                .description("Central European country known for its Alps, classical music, and neutrality.")
                .img("https://upload.wikimedia.org/wikipedia/commons/4/41/Flag_of_Austria.svg")
                .amountGold(1)
                .amountSilver(1)
                .amountBronze(7)
                .total(9)
                .firstOlympicAppearance("1896")
                .numberOfOlympicsParticipatedIn(30)

                .build());
        Country azerbaijan = countryRepository.save(Country.builder() //3
                .countryName("Azerbaijan")
                .description("Eurasian country with a mix of Eastern and Western cultures, Caspian Sea coastline, and oil resources.")
                .img("https://upload.wikimedia.org/wikipedia/commons/d/dd/Flag_of_Azerbaijan.svg")
                .amountGold(0)
                .amountSilver(4)
                .amountBronze(4)
                .total(8)
                .firstOlympicAppearance("1996")
                .numberOfOlympicsParticipatedIn(6)

                .build());

        Country belarus = countryRepository.save(Country.builder() //4
                .countryName("Belarus")
                .description("Eastern European country with vast forests, historical sites, and a strong connection to Russia.")
                .img("https://upload.wikimedia.org/wikipedia/commons/thumb/8/85/Flag_of_Belarus.svg/800px-Flag_of_Belarus.svg.png")
                .amountGold(1)
                .amountSilver(3)
                .amountBronze(5)
                .total(9)
                .firstOlympicAppearance("1996")
                .numberOfOlympicsParticipatedIn(6)

                .build());

        Country belgium = countryRepository.save(Country.builder() //5
                .countryName("Belgium")
                .description("Western European country known for chocolate, beer, and multiple languages.")
                .img("https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/Flag_of_Belgium.svg/692px-Flag_of_Belgium.svg.png")
                .amountGold(3)
                .amountSilver(1)
                .amountBronze(3)
                .total(7)
                .firstOlympicAppearance("1900")
                .numberOfOlympicsParticipatedIn(30)

                .build());

        Country armenia = countryRepository.save(Country.builder() //6
                .countryName("Armenia")
                .description("Eurasian country with a rich history, mountainous terrain, and friendly people.")
                .img( "https://upload.wikimedia.org/wikipedia/commons/2/2f/Flag_of_Armenia.svg")
                .amountGold(0)
                .amountSilver(2)
                .amountBronze(3)
                .total(5)
                .firstOlympicAppearance("1996")
                .numberOfOlympicsParticipatedIn(6)

                .build());

        Country argentina = countryRepository.save(Country.builder() //7
                .countryName("Argentina")
                .description("South American nation known for its Pampas grasslands, tango, and football.")
                .img( "https://upload.wikimedia.org/wikipedia/commons/1/1a/Flag_of_Argentina.svg")
                .amountGold(0)
                .amountSilver(3)
                .amountBronze(3)
                .total(6)
                .firstOlympicAppearance("1900")
                .numberOfOlympicsParticipatedIn(30)

                .build());

        Country bahamas = countryRepository.save(Country.builder() //8
                .countryName("Bahamas")
                .description("Caribbean archipelago famous for its beaches and turquoise waters.")
                .img( "https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/Flag_of_the_Bahamas.svg/800px-Flag_of_the_Bahamas.svg.png")
                .amountGold(2)
                .amountSilver(0)
                .amountBronze(0)
                .total(2)
                .firstOlympicAppearance("1952")
                .numberOfOlympicsParticipatedIn(28)

                .build());

        Country bahrain = countryRepository.save(Country.builder() //9
                .countryName("Bahrain")
                .description("Island nation in the Persian Gulf, known for oil production and modern architecture.")
                .img( "https://cdn.britannica.com/67/5767-004-E0FF7201/Flag-Bahrain.jpg")
                .amountGold(0)
                .amountSilver(5)
                .amountBronze(0)
                .total(5)
                .firstOlympicAppearance("1984")
                .numberOfOlympicsParticipatedIn(11)

                .build());

        athleticsW.setGold(bahamas);                 // id 1
        bahamas.getGoldMedals().add(athleticsW);
        athleticsW.setSilver(bahrain);
        bahrain.getSilverMedals().add(athleticsW);
        athleticsW.setBronze(argentina);
        argentina.getBronzeMedals().add(athleticsW);

        athleticsM.setGold(bahamas);
        bahamas.getGoldMedals().add(athleticsM);     // id 2
        athleticsM.setSilver(bahrain);
        bahrain.getSilverMedals().add(athleticsM);
        athleticsM.setBronze(armenia);
        armenia.getBronzeMedals().add(athleticsM);

        athleticsWH.setGold(belgium);                 // id 3
        belgium.getGoldMedals().add(athleticsWH);
        athleticsWH.setSilver(australia);
        australia.getSilverMedals().add(athleticsWH);
        athleticsWH.setBronze(austria);
        austria.getBronzeMedals().add(athleticsWH);

        hockeyM.setGold(belgium);                   // id 4
        belgium.getGoldMedals().add(hockeyM);
        hockeyM.setSilver(argentina);
        argentina.getSilverMedals().add(hockeyM);
        hockeyM.setBronze(austria);
        austria.getBronzeMedals().add(hockeyM);

        artisticGymnasticsW.setGold(belgium);       // id 5
        belgium.getGoldMedals().add(artisticGymnasticsW);
        artisticGymnasticsW.setSilver(argentina);
        argentina.getSilverMedals().add(artisticGymnasticsW);
        artisticGymnasticsW.setBronze(austria);
        austria.getGoldMedals().add(artisticGymnasticsW);

        cyclingRoadW.setGold(austria);          // id 6
        austria.getGoldMedals().add(cyclingRoadW);
        cyclingRoadW.setSilver(azerbaijan);
        azerbaijan.getSilverMedals().add(cyclingRoadW);
        cyclingRoadW.setBronze(belarus);
        belarus.getBronzeMedals().add(cyclingRoadW);

        canoeSprintM.setGold(australia);           // id 7
        australia.getGoldMedals().add(canoeSprintM);
        canoeSprintM.setSilver(bahrain);
        bahrain.getSilverMedals().add(canoeSprintM);
        canoeSprintM.setBronze(belarus);
        belarus.getBronzeMedals().add(canoeSprintM);

        trampolineM.setGold(belarus);
        belarus.getGoldMedals().add(trampolineM);
        trampolineM.setSilver(bahrain);
        bahrain.getSilverMedals().add(trampolineM);
        trampolineM.setBronze(argentina);
        argentina.getBronzeMedals().add(trampolineM);


    }
    @Override
    public boolean supportsAsyncExecution() {
        return ApplicationListener.super.supportsAsyncExecution();
    }

}
