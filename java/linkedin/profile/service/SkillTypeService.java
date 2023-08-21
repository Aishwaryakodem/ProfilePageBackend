package linkedin.profile.service;

import linkedin.profile.entity.SkillType;
import linkedin.profile.repository.SkillTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillTypeService {

    @Autowired
    private SkillTypeRepository skillTypeRepository;

    public Iterable<SkillType> getAllSkills() {
        return skillTypeRepository.findAll();
    }

}
