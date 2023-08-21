package linkedin.profile.repository;

import linkedin.profile.entity.Experience;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienceRepository extends CrudRepository<Experience, Long> {
    public List<Experience> findAllByUserId(Long userId);
    public Boolean existsByUserId(Long userId);
    public void deleteByIdAndUserId(Long id, Long userId);
}
