package kr.protest.multichat.Controller;

import kr.protest.multichat.Entity.Room;
import kr.protest.multichat.Entity.Users;
import kr.protest.multichat.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainRestController {


    private final RoomRepository roomRepository;

    @Autowired
    public MainRestController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @RequestMapping("/chat_list")
    public List<Room> chat_list(Long uid){
        Users user = new Users();
        user.setUid(uid);
        List<Room> result = roomRepository.findByUidAndState(user,true);

        return result;
    }
}
