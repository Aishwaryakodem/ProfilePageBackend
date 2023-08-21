package linkedin.profile.controller;

import linkedin.profile.DTO.ExperienceDto;
import linkedin.profile.DTO.LocationDto;
import linkedin.profile.entity.Experience;
import linkedin.profile.repository.ExperienceRepository;
import linkedin.profile.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ExperienceController {

    @Autowired
    private ExperienceService experienceService;
    @Autowired
    private ExperienceRepository experienceRepository;

    @RequestMapping(value = "showExp/{userId}", method = RequestMethod.GET)
    public List<ExperienceDto> getExp(@PathVariable Long userId) {
        if(experienceRepository.existsByUserId(userId)) {
            return experienceService.getExperienceShortCode(userId);
        }
        return new ArrayList<>();
    }

    @RequestMapping(value = "addExp/{userId}", method = RequestMethod.POST)
    public ExperienceDto addExp(@RequestBody ExperienceDto experienceDto, @PathVariable Long userId) {
        return experienceService.addOrUpdateExperience(experienceDto, userId);

    }

    @RequestMapping(value = "updateExp/{userId}", method = RequestMethod.POST)
    public ExperienceDto updateExp(@RequestBody ExperienceDto experienceDto, @PathVariable Long userId) {
        return experienceService.addOrUpdateExperience(experienceDto, userId);
    }

    @RequestMapping(value = "deleteExp/{userId}")
    public void deleteExp(@PathVariable Long userId, @RequestBody ExperienceDto experienceDto) {
//        System.out.println(experienceDto);
        experienceService.deleteExperience(experienceDto.getId());

    }
}
