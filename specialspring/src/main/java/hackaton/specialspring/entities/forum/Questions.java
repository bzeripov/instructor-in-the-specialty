package hackaton.specialspring.entities.forum;

import hackaton.specialspring.entities.Sections;
import hackaton.specialspring.entities.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import javax.persistence.*;


@Entity
@Table(name = "questions")
@Data
@AllArgsConstructor
@NoArgsConstructor

@Component
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "body")
    private String body;

    @Column(name = "voting")
    private int voting;

    @Column(name = "views")
    private int views;

    @ManyToOne(fetch = FetchType.EAGER)
    private Sections section;

    @ManyToOne(fetch = FetchType.EAGER)
    private Users user;
}

