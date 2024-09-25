package dat.dtos;

import dat.entities.Poem;
import dat.enums.PoemTypes;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Builder
public class PoemDTO {
    private Long id;
    private PoemTypes type;
    private String title;
    private String poem;
    private String author;

    public PoemDTO(Poem poem){
        this.id = poem.getId();
        this.type = poem.getType();
        this.title = poem.getTitle();
        this.poem = poem.getPoem();
        this.author = poem.getAuthor();
    }
}