package linkedin.profile.Mapper;

import linkedin.profile.DTO.EducationDto;
import linkedin.profile.entity.Education;
import org.springframework.stereotype.Component;

//Entity to Dto

@Component
public class EducationMapper {

    public EducationDto toEduDto(Education entity, String degreeTypeName) {

        EducationDto dto = new EducationDto();

        dto.setEducationId(entity.getId());
        dto.setUserId(entity.getUserId());
        dto.setName(entity.getName());
        dto.setStartDate(entity.getStartDate());
        dto.setEndDate(entity.getEndDate());
        dto.setDegreeName(degreeTypeName);
        dto.setGrade(entity.getGrade());

        return dto;
    }

    public Education toEduEntity(EducationDto dto, Education entity, Long degreeTypeId) {
        entity.setId(dto.getEducationId());
//        entity.setUserId(dto.getUserId());
        entity.setName(dto.getName());
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());
        entity.setDegreeId(degreeTypeId);
        entity.setGrade(dto.getGrade());
        return entity;
    }
}
