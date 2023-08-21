package linkedin.profile.repository;

import linkedin.profile.entity.SkillType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillTypeRepository extends CrudRepository<SkillType, Long> {
    public SkillType findByName(String name);
}
