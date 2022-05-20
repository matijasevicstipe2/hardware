package hr.tvz.matijasevic.hardwareapp;

import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/*@Repository
public class TempReviewRepository implements Serializable,ReviewRepository {
    private List<Review> TEMP_REVIEW_REPOSITORY = new ArrayList<>(Arrays.asList(

            new Review(Stars.valueOf("jedan"),"Procesor mi unistio laptop","Uzasno los procesor ne znam kako je opce dospio na trziste","ic9-770"),
            new Review(Stars.valueOf("dva"),"Ne preporucuje se","Sporo radi i bloka","nrtx4-3000"),
            new Review(Stars.valueOf("tri"),"Solidna maticna zadovoljava sve jednostavne radnje","Kako bi se reklo not great not terrible","sTRX4amd"),
            new Review(Stars.valueOf("cetiri"),"16 giga radi bez vecih problema","Zadovoljan sam","ddr4ven"),
            new Review(Stars.valueOf("pet"),"Najbolji ssd ikad","Prezadovoljan","nvMe2tb"),
            new Review(Stars.valueOf("tri"),"Ne preporucuje za kompliciranije zadatke","Cesti zastoji","nrtx4-3000")


    ));
    @Override
    public List<Review> findAll(String code) {
        return TEMP_REVIEW_REPOSITORY
                .stream()
                .filter(h -> Objects.equals(code,h.getHardwareCode())).collect(Collectors.toList());
    }

}*/
