package kr.protest.multichat.Repository;

import kr.protest.multichat.Dto.RoomListDto;
import kr.protest.multichat.Entity.Room;
import kr.protest.multichat.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query(value = "SELECT * FROM room WHERE uid = :uid AND state = true", nativeQuery = true)
    List<Room> findActiveRoomsByUserId(@Param("uid") Long uid);}
