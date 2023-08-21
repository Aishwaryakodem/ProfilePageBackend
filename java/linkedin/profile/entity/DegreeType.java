package linkedin.profile.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "degree_type")
public class DegreeType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

}
