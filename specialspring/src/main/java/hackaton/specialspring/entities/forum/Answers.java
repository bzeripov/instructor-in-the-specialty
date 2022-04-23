package hackaton.specialspring.entities.forum;

import hackaton.specialspring.entities.Sections;
import hackaton.specialspring.entities.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import javax.persistence.*;

@Entity
@Table(name = "answers")
@Data
@AllArgsConstructor
@NoArgsConstructor

@Component
public class Answers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "body")
    private String body;

    @ManyToOne
    private Questions question;

    @ManyToOne(fetch = FetchType.EAGER)
    private Users user;

    @Column(name = "rating")
    private int rating;
}

