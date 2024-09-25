package dat.entities;

import dat.dtos.PoemDTO;
import dat.enums.PoemTypes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Poem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private PoemTypes type;
    private String title;
    private String poem;
    private String author;

    public Poem(PoemDTO poemDTO){
        this.id = poemDTO.getId();
        this.type = poemDTO.getType();
        this.title = poemDTO.getTitle();
        this.poem = poemDTO.getPoem();
        this.author = poemDTO.getAuthor();
    }
}