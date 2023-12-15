package kr.protest.multichat.Service;


import kr.protest.multichat.Entity.Room;
import kr.protest.multichat.Entity.Users;

import java.util.List;

public interface RoomService {
    List<Room> findActiveRoomsByUser(Users user);
}
