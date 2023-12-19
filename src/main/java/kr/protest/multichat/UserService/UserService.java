package kr.protest.multichat.UserService;

import kr.protest.multichat.Entity.Users;
import kr.protest.multichat.UserDto.UserDto;
import kr.protest.multichat.UserRepository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public Users create(UserDto userDto){
        Users user = new Users();
        user.setLid(userDto.getLid());
        user.setUname(userDto.getUname());
        user.setLpwd(passwordEncoder.encode(userDto.getLpwd()));
        user.setRegDate(LocalDateTime.now());
        user.setModDate(LocalDateTime.now());
        this.userRepository.save(user);
        return user;
    }
}
