package linkedin.profile.repository;

import linkedin.profile.entity.Education;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface EducationRepository extends CrudRepository<Education, Long> {
    public List<Education> findAllByUserId(Long userId);
    public Boolean existsByUserId(Long userId);
    public void deleteByIdAndUserId(Long userId, Long educationId);
}
