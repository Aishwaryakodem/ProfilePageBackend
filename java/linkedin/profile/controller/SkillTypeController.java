package linkedin.profile.controller;

import linkedin.profile.entity.SkillType;
import linkedin.profile.service.SkillTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SkillTypeController {

    @Autowired
    private SkillTypeService skillTypeService;

    @RequestMapping(value = "showSkillType", method = RequestMethod.GET)
    public  Iterable<SkillType> getskilltype() {
       return skillTypeService.getAllSkills();

    }

}
