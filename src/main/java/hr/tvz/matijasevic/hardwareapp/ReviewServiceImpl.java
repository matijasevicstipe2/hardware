package hr.tvz.matijasevic.hardwareapp;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements Serializable,ReviewService {
    private ReviewsJpaRepository reviewRepository;

    public ReviewServiceImpl(ReviewsJpaRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<ReviewDTO> findAll(String code) {
        return reviewRepository.findByHardware_Code(code).stream().map(this::mapReviewToDTO).collect(Collectors.toList());
    }

    @Override
    public List<ReviewDTO> findByCriteria(String text) {
        return reviewRepository.findByTitleIgnoreCaseContaining(text).stream().map(this::mapReviewToDTO).collect(Collectors.toList());
    }

    @Override
    public List<ReviewDTO> find() {
        return reviewRepository.findAll().stream().map(this::mapReviewToDTO).collect(Collectors.toList());
    }

    private ReviewDTO mapReviewToDTO(Review review){
        return new ReviewDTO(review.getTitle(),review.getEvaluation(),review.getInfo());

    }

}
