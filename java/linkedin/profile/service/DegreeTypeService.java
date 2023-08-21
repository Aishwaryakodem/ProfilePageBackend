package linkedin.profile.service;

import linkedin.profile.DTO.DegreeTypeDto;
import linkedin.profile.Mapper.DegreeTypeMapper;
import linkedin.profile.entity.DegreeType;
import linkedin.profile.repository.DegreeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DegreeTypeService {

    @Autowired
    private DegreeTypeRepository degreeTypeRepository;
    @Autowired
    private DegreeTypeMapper degreeTypeMapper;

    public List<DegreeTypeDto> getAllDegree() {
        List<DegreeTypeDto> degreeTypeDtos = new ArrayList<>();
        List<DegreeType> degreeTypes = (List<DegreeType>) degreeTypeRepository.findAll();
        for (DegreeType degreeType : degreeTypes) {
            degreeTypeDtos.add(degreeTypeMapper.toDegreeDto(degreeType));
        }
        return degreeTypeDtos;
    }
}
