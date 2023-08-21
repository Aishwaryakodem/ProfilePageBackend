package linkedin.profile.controller;


import linkedin.profile.DTO.DegreeTypeDto;
import linkedin.profile.service.DegreeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DegreeTypeController {

    @Autowired
    private DegreeTypeService degreeTypeService;

    @RequestMapping(value = "/showDegree")
    public List<DegreeTypeDto> getDegreeType() {
        return degreeTypeService.getAllDegree();
    }

}
