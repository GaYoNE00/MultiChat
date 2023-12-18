package kr.protest.multichat.UserSecurityService;

import kr.protest.multichat.Entity.Users;
import kr.protest.multichat.User.UserRole;
import kr.protest.multichat.UserRepository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserSecurityService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String lid) throws UsernameNotFoundException{
        Optional<Users> _users = this.userRepository.findByLid(lid);
        if(_users.isEmpty()){
            System.out.println(lid+"사용자는 없습니다.");
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }
        System.out.println("사용자는"+_users);
        Users users = _users.get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        if("admin".equals(lid)){
            authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
        }else{
            authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
        }
        return new User(users.getLid(), users.getLpwd(), authorities);
    }

}
