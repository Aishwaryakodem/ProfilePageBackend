package linkedin.profile.service;

import jakarta.transaction.Transactional;
import linkedin.profile.DTO.EducationDto;
import linkedin.profile.DTO.SkillDto;
import linkedin.profile.Mapper.SkillMapper;
import linkedin.profile.entity.DegreeType;
import linkedin.profile.entity.Education;
import linkedin.profile.entity.Skill;
import linkedin.profile.entity.SkillType;
import linkedin.profile.repository.SkillRepository;
import linkedin.profile.repository.SkillTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SkillService {
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private SkillTypeRepository skillTypeRepository;
    @Autowired
    private SkillMapper skillMapper;

    public List<SkillDto> getSkillsById(Long userId) {
        List<Skill> skills = skillRepository.findAllByUserId(userId);
        List<Long> skillTypeIdList = new ArrayList<>();
        // degreeIdList = educations.stream().map(Education::getDegreeId).collect(Collectors.toList());
        for (Skill skill : skills) {
            skillTypeIdList.add(skill.getSkillId());
        }
        List<SkillType> skillTypes = (List<SkillType>) skillTypeRepository.findAllById(skillTypeIdList);
        Map<Long, String> skillTypeMap = new HashMap<>();
        for (SkillType skillType : skillTypes) {
            skillTypeMap.put(skillType.getId(), skillType.getName());
        }
        List<SkillDto> skillDtos = new ArrayList<>();

        for (Skill skill : skills) {
            skillDtos.add(skillMapper.toSkillDto(skill, skillTypeMap.get(skill.getSkillId())));
        }
        return skillDtos;
//        List<Skill> skill = skillRepository.findAllByUserId(userId);
//        List<SkillDto> skillDtos = new ArrayList<>();
//        Map<Long, SkillType> skillTypeMap = new HashMap<>();
//
//        for (Skill skill1 : skill) {
//            System.out.println(skill1.getSkillId());
//            skillDtos.add(skillMapper.toSkillDto(skill1, skillTypeMap.get(skill1.getSkillId()).getName()));
//        }
//        return skillDtos;
    }


    public void addSkill(SkillDto skillDto) {
        Skill skill = skillMapper.toSkillEntity(skillDto, skillDto.getId(), new Skill());
        skillRepository.save(skill);

    }
    @Transactional
    public void deleteSkill(Long skillId, Long userId) {
        System.out.println(userId);
      skillRepository.deleteByIdAndUserId(skillId, userId);
    }
}
