package linkedin.profile.controller;

import linkedin.profile.DTO.EducationDto;
import linkedin.profile.repository.EducationRepository;
import linkedin.profile.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
public class EducationController {
    @Autowired
    private EducationService educationService;
    @Autowired
    private EducationRepository educationRepository;

    @RequestMapping(value = "deleteEducation/{userId}")
    public void deleteEducation(@PathVariable Long userId, @RequestBody EducationDto educationDto) {
        educationService.deleteEducation(userId, educationDto.getEducationId());
    }

    @RequestMapping(value = "updateEducation/{userId}", method = RequestMethod.POST)
    public EducationDto updateEducation(@RequestBody EducationDto education, @PathVariable String userId) {
        return educationService.addOrUpdateEducation(education, Long.parseLong(userId));

    }

    @RequestMapping(value = "addEducation/{userId}", method = RequestMethod.POST)
    public EducationDto setEducation(@RequestBody EducationDto education, @PathVariable Long userId) {
        return educationService.addOrUpdateEducation(education, userId);
    }

    @RequestMapping(value = "showEducation/{userId}", method = RequestMethod.GET)
    public List<EducationDto> getEducation(@PathVariable Long userId) {
        if(educationRepository.existsByUserId(userId)) {
            return educationService.getEducation(userId);
        }
        return new ArrayList<>();
    }

}
