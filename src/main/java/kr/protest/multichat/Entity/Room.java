package kr.protest.multichat.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@IdClass(RoomId.class)
public class Room extends BaseEntity{

    @Id
    private Long rid;

    @Id
    @ManyToOne
    @JoinColumn(name="uid")
    private Users uid;

    private String title;
    private boolean state;

}