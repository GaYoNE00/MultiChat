package kr.protest.multichat.Dto;

import kr.protest.multichat.Entity.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomListDto {
    private Long rid;
    private Long uid;
    private String title;
}
