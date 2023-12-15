package kr.protest.multichat.Repository;

import kr.protest.multichat.Dto.RoomListDto;
import kr.protest.multichat.Entity.Room;
import kr.protest.multichat.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByUidAndState(Users uid, boolean state);
}
