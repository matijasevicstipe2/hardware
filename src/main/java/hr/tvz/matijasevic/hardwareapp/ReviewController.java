package hr.tvz.matijasevic.hardwareapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("review")
@CrossOrigin(origins = "http://localhost:4200")
public class ReviewController implements Serializable {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping(params = "hardwareCode")
    public List<ReviewDTO> getAllReviews(@RequestParam String hardwareCode){
        return reviewService.findAll(hardwareCode);
    }
    @GetMapping()
    public List<ReviewDTO> getAll(){
        return reviewService.find();
    }
    @GetMapping("/criteria/{text}")
    public List<ReviewDTO> getReviews(@PathVariable String text){
        return reviewService.findByCriteria(text);
    }

}
