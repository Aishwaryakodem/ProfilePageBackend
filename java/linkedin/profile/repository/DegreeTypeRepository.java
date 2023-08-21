package linkedin.profile.repository;

import linkedin.profile.entity.DegreeType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DegreeTypeRepository extends CrudRepository<DegreeType, Long> {
    public DegreeType findByName(String name);

}
