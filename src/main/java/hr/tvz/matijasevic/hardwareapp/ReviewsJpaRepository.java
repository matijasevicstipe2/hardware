package hr.tvz.matijasevic.hardwareapp;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewsJpaRepository extends JpaRepository<Review,Long> {

    List<Review> findAll();
    List<Review> findByHardware_Code(String code);
    List<Review> findByTitleIgnoreCaseContaining(String text);
}
