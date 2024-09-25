package dat.entities;

import dat.dto.PoemDTO;
import dat.enums.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Poem {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String author;
    @Enumerated(EnumType.STRING)
    private Type type;
    private String poem;
    
    public Poem (PoemDTO poemDTO){
    this.id = poemDTO.getId();
    this.author = poemDTO.getAuthor();
    this.type = poemDTO.getType();
    this.poem = poemDTO.getPoem();
    }
}
