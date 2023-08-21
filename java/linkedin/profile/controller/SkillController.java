package linkedin.profile.controller;

import linkedin.profile.DTO.SkillDto;
import linkedin.profile.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SkillController {

    @Autowired
    private SkillService skillService;

    @RequestMapping(value = "showSkill/{userId}", method = RequestMethod.GET)
    public List<SkillDto> getSkill(@PathVariable Long userId) {
        return skillService.getSkillsById(userId);

    }

    @RequestMapping(value = "addSkill", method = RequestMethod.POST)
    public void addSkill(@RequestBody SkillDto skillDto) {
         skillService.addSkill(skillDto);
    }

    @RequestMapping(value = "deleteSkill/{userId}")
    public void deleteSkill(@PathVariable Long userId, @RequestBody SkillDto skillDto) {
        System.out.println(skillDto);
        skillService.deleteSkill(skillDto.getId(), userId);
    }
}
