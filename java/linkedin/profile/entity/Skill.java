package linkedin.profile.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "skill")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false, nullable = false)
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "skill_id")
    private Long skillId;


}
