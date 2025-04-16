package ut.edu.springboot.controllers.res;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "master/productRequirement/yeu-cau-phu-tung";
    }
    @GetMapping("/productRequirement/yeu-cau-phu-tung")
    public String trangChu() {
        return "master/productRequirement/yeu-cau-phu-tung";
    }
    @GetMapping("/popupRequest")
    public String popupRequest() {
        return "master/productRequirement/popupRequest"; // Trả về file popupRequest.html trong templates/
    }
    @GetMapping("/buyProducts/ban-phu-tung")
    public String banPhuTung() {
        return "master/buyProducts/ban-phu-tung";
    }
    @GetMapping("/aboutUs/thong_tin_ve_chung_toi")
    public String aboutUs() {
        return "master/aboutUs/thong_tin_ve_chung_toi";
    }
    @GetMapping("/phone/thong_tin_lien_he")
    public String phone() {
        return "master/phone/thong_tin_lien_he";
    }
    @GetMapping("/buyProducts/chi-tiet-san-pham")
    public String productDetails() {
        return "master/buyProducts/chi-tiet-san-pham";
    }

    @GetMapping("/search/login/login")
    public String login() {
        return "master/search/login/login";
    }

    @GetMapping("/search/login/register")
    public String register() {
        return "master/search/login/register";
    }

    @GetMapping("/search/login/foggotpassword")
    public String forgotPassword() {
        return "master/search/login/foggotpassword";
    }
    @GetMapping("/search/login/otp-verification")
    public String otpVerification() {
        return "master/search/login/otp-verification";
    }


}
