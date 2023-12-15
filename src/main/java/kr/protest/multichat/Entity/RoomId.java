package kr.protest.multichat.Entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;

public class RoomId implements Serializable {
    private Long rid;
    private Users uid;

}