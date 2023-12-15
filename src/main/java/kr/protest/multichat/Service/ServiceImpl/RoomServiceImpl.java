package kr.protest.multichat.Service.ServiceImpl;

import kr.protest.multichat.Dto.RoomListDto;
import kr.protest.multichat.Dto.UserDto;
import kr.protest.multichat.Entity.Room;
import kr.protest.multichat.Entity.Users;
import kr.protest.multichat.Repository.RoomRepository;
import kr.protest.multichat.Service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {


    private final RoomRepository roomRepository;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }


    @Override
    public List<Room> findActiveRoomsByUser(Users uid) {
        return roomRepository.findByUidAndState(uid,true);
    }
}
