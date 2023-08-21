package linkedin.profile.repository;

import linkedin.profile.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
    public List<Skill> findAllByUserId(Long userId);
    public void deleteByIdAndUserId(Long id, Long userId);
}
