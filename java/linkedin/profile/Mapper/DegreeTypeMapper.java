package linkedin.profile.Mapper;

import linkedin.profile.DTO.DegreeTypeDto;
import linkedin.profile.entity.DegreeType;
import org.springframework.stereotype.Component;

@Component
public class DegreeTypeMapper {

    public DegreeTypeDto toDegreeDto(DegreeType degreeType) {
        DegreeTypeDto degreeTypeDto = new DegreeTypeDto();

        degreeTypeDto.setId(degreeType.getId());
        degreeTypeDto.setName(degreeType.getName());

        return degreeTypeDto;
    }

    public DegreeType toDegreeEntity(DegreeTypeDto degreeTypeDto) {
        DegreeType degreeType = new DegreeType();

        degreeType.setId(degreeType.getId());
        degreeType.setName(degreeTypeDto.getName());

        return degreeType;
    }
}
