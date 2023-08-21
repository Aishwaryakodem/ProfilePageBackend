package linkedin.profile.Mapper;

import linkedin.profile.DTO.SkillDto;
import linkedin.profile.entity.Skill;
import org.springframework.stereotype.Component;

@Component
public class SkillMapper {

    public SkillDto toSkillDto(Skill skill, String skillTypeName) {
        SkillDto skillDto = new SkillDto();

        skillDto.setId(skill.getId());
        skillDto.setUserId(skill.getUserId());
        skillDto.setSkillName(skillTypeName);

        return skillDto;
    }

    public Skill toSkillEntity(SkillDto skillDto, Long skillTypeId, Skill skill) {

        skill.setId(skillDto.getId());
        skill.setUserId(skillDto.getUserId());
        skill.setSkillId(skillTypeId);

        return skill;
    }
}
