package ut.edu.springboot.services;

import ut.edu.springboot.models.User;
import ut.edu.springboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByUsername(username);
        User user = userOptional.orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy người dùng với username: " + username));

        if (user.getRole() != null) {
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + user.getRole()); // Nếu getRole() là String
            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(),
                    user.getPassword(),
                    Collections.singletonList(authority)
            );
        } else {
            // Xử lý trường hợp role là null
            // Ví dụ: gán role mặc định hoặc ném ra ngoại lệ
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER"); // Gán role mặc định
            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(),
                    user.getPassword(),
                    Collections.singletonList(authority)
            );
            // Hoặc:
            // throw new RuntimeException("User role is null");
        }
    }
}