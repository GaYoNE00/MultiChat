package kr.protest.multichat.UserService;

import kr.protest.multichat.Entity.Users;
import kr.protest.multichat.UserRepository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public Users create(String lid, String uname, String lpwd){
        Users user = new Users();
        user.setLid(lid);
        user.setUname(uname);
        user.setLpwd(passwordEncoder.encode(lpwd));
        this.userRepository.save(user);
        return user;
    }
}
