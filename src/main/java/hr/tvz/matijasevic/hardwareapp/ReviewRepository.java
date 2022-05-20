package hr.tvz.matijasevic.hardwareapp;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository {
    List<Review> findAll(String code);

}
