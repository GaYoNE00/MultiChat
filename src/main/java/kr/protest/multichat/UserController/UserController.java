package kr.protest.multichat.UserController;

import jakarta.validation.Valid;
import kr.protest.multichat.User.UserCreateForm;
import kr.protest.multichat.UserDto.UserDto;
import kr.protest.multichat.UserService.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;


    @GetMapping("/login")
    public String login(){
        return "login_form";
    }

    @GetMapping("/signup")
    public String signup(UserCreateForm userCreateForm){
        return "signup_form";
    }
    @PostMapping("/signup")
    public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "signup_form";
        }
        if(!userCreateForm.getLpwd().equals(userCreateForm.getLpwd2())){
            bindingResult.rejectValue("Lpwd2", "passwrodInCorrect", "2개의 패스워드사 서로 일치하지 않습니다.");
            return "signup_form";
        }
//        userService.create(userCreateForm.getLid(), userCreateForm.getUname(), userCreateForm.getLpwd());

        try {
            UserDto dto = new UserDto();
            dto.setUname(userCreateForm.getUname());
            dto.setLpwd(userCreateForm.getLpwd());
            dto.setLid(userCreateForm.getLid());
            userService.create(dto);
        }catch (DataIntegrityViolationException e){
            e.printStackTrace();
            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
            return "signup_form";
        }catch (Exception e){
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            return "signup_form";
        }
        return "redirect:/";

    }
}
