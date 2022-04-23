package hackaton.specialspring.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import javax.persistence.*;


@Entity
@Table(name = "albums")
@Data
@AllArgsConstructor
@NoArgsConstructor

@Component
public class Albums {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "heading")
    private String heading;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    private Specialities speciality;

    @Column(name = "video")
    private String video;

    @Column(name = "image")
    private String image;

    public Long getId() {
        return id;
    }

    public String getHeading() {
        return heading;
    }

    public String getDescription() {
        return description;
    }

    public Long getSpecialityId(){
        return speciality.getId();
    }

    public String getVideo() {
        return video;
    }
}

