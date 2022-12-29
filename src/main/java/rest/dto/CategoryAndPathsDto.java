package rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryAndPathsDto {
    private String category;
    private List<String> listOfNames;
    private List<String> listOfPaths;
}