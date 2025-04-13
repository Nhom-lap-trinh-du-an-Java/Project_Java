package ut.edu.springboot.controllers.res;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import ut.edu.springboot.jwt.JwtUtil;
import ut.edu.springboot.services.UserService;
import ut.edu.springboot.models.User
;


@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/profile")
    @PreAuthorize("hasRole('ADMIN')")
    public String getUserProfile(HttpServletRequest request) {
        // Lấy token từ header Authorization
        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return "Missing or invalid token!";
        }

        // Cắt bỏ "Bearer " để lấy token thực sự
        String token = authHeader.substring(7);

        return "Token: " + token;
    }


}
