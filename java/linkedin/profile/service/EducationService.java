package linkedin.profile.service;

import linkedin.profile.DTO.EducationDto;
import linkedin.profile.Mapper.EducationMapper;
import linkedin.profile.entity.DegreeType;
import linkedin.profile.entity.Education;
import linkedin.profile.repository.DegreeTypeRepository;
import linkedin.profile.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class EducationService {

    @Autowired
    private EducationRepository educationRepository;
    @Autowired
    private DegreeTypeService degreeTypeService;
    @Autowired
    private EducationMapper educationMapper;
    @Autowired
    private DegreeTypeRepository degreeTypeRepository;

    public void deleteEducation(Long userId, Long educationId) {
        if (educationRepository.existsById(educationId)) {
            educationRepository.deleteById(educationId);
        }
    }

    public EducationDto addOrUpdateEducation(EducationDto eduDto, Long userId) {
        DegreeType degreeType = degreeTypeRepository.findByName(eduDto.getDegreeName());
        System.out.println(degreeType);
        Education education = new Education();
        if(eduDto.getEducationId()!=null) {
            education = educationRepository.findById(eduDto.getEducationId()).orElseThrow(null);
        }
        education.setUserId(userId);
        education = educationMapper.toEduEntity(eduDto, education, degreeType.getId());

        educationRepository.save(education);

        return educationMapper.toEduDto(education, degreeType.getName());
    }

    public List<EducationDto> getEducation(Long userId) {
        List<Education> educations = educationRepository.findAllByUserId(userId);
        List<Long> degreeIdList = new ArrayList<>();
        // degreeIdList = educations.stream().map(Education::getDegreeId).collect(Collectors.toList());
        for (Education education : educations) {
            degreeIdList.add(education.getDegreeId());
        }
        List<DegreeType> degreeTypes = (List<DegreeType>) degreeTypeRepository.findAllById(degreeIdList);
        Map<Long, String> degreeTypeMap = new HashMap<>();
        for (DegreeType degreeType : degreeTypes) {
            degreeTypeMap.put(degreeType.getId(), degreeType.getName());
        }
        List<EducationDto> educationDtos = new ArrayList<>();

        for (Education education : educations) {
            educationDtos.add(educationMapper.toEduDto(education, degreeTypeMap.get(education.getDegreeId())));
        }
        return educationDtos;
    }
}
