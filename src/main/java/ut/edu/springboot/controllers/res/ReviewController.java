package ut.edu.springboot.controllers.res;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ut.edu.springboot.models.Review;
import ut.edu.springboot.repositories.ReviewRepository;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @PostMapping
    public ResponseEntity<?> saveReview(@RequestBody Review review) {
        ResponseEntity.ok(reviewRepository.save(review));
        return ResponseEntity.ok("Đánh giá đã được lưu!");

    }


}
