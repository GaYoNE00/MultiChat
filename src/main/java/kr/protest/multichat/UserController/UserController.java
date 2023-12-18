package kr.protest.multichat.UserController;

import jakarta.validation.Valid;
import kr.protest.multichat.User.UserCreateForm;
import kr.protest.multichat.UserService.UserService;
import lombok.RequiredArgsConstructor;
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
        return "signuo_form";
    }
    @PostMapping("/signup")
    public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "sigup_form";
        }
        if(!userCreateForm.getLpwd().equals(userCreateForm.getLpwd2())){
            bindingResult.rejectValue("Lpwd2", "passwrodInCorrect", "2개의 패스워드사 서로 일치하지 않습니다.");
            return "signup_form";
        }
        userService.create(userCreateForm.getLid(), userCreateForm.getUname(), userCreateForm.getLpwd());
        return "redirect:/";

    }
}
