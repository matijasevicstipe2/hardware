package hr.tvz.matijasevic.hardwareapp;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<ReviewDTO> findAll(String code);
    List<ReviewDTO> findByCriteria(String text);
    List<ReviewDTO> find();

}
