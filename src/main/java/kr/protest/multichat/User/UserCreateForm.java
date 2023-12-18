package kr.protest.multichat.User;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserCreateForm {
    @Size(min = 3, max = 25)
    @NotEmpty(message = "이름은 필수 항목입니다.")
    private String uname;

    @NotEmpty(message = "사용자 ID는 필수항목입니다.")
    private String lid;
    @NotEmpty(message = "비밀번호는 필수항목입니다.")
    private String lpwd;

    @NotEmpty(message = "비밀번호 확인은 필수항목입니다.")
    private String lpwd2;

}
