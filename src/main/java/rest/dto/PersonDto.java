package rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {
    private String id;
    private String nickname;
    private String pwd;
    private String email;
    private boolean teacher;
}