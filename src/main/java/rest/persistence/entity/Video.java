package rest.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "videos")
public class Video {
    @Id
    private UUID id;
    private String name;
    private String about;
    private String category;
}
