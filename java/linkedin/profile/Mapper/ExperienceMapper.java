package linkedin.profile.Mapper;

import linkedin.profile.DTO.ExperienceDto;
import linkedin.profile.DTO.LocationDto;
import linkedin.profile.entity.Experience;
import linkedin.profile.entity.Location;
import org.springframework.stereotype.Component;

@Component
public class ExperienceMapper {

//    public ExperienceDto toExpDto(Experience experience, Location location){
//        ExperienceDto experienceDto = new ExperienceDto();
//
//        experienceDto.setId(experience.getId());
//        experienceDto.setCompanyName(experience.getCompanyName());
//        experienceDto.setTitle(experience.getTitle());
//        experienceDto.setStartDate(experience.getStartDate());
//        experienceDto.setEndDate(experience.getEndDate());
//        experienceDto.setCurrentEmp(experience.isCurrentEmp());
//        experienceDto.setUserId(experience.getUserId());
//        experienceDto.setYearsOfExp(experience.getYearsOfExp());
//
//
//        return experienceDto;
//    }

    public ExperienceDto toExpDtoShortCode(Experience experience) {
        ExperienceDto experienceDto = new ExperienceDto();

        experienceDto.setId(experience.getId());
        experienceDto.setCompanyName(experience.getCompanyName());
        experienceDto.setTitle(experience.getTitle());
        experienceDto.setStartDate(experience.getStartDate());
        experienceDto.setEndDate(experience.getEndDate());
        experienceDto.setCurrentEmp(experience.isCurrentEmp());
        experienceDto.setUserId(experience.getUserId());
        experienceDto.setYearsOfExp(experience.getYearsOfExp());
        experienceDto.setLocationId(experience.getLocation().getId());
        experienceDto.setHouseNum(experience.getLocation().getHouseNo());
        experienceDto.setStreet(experience.getLocation().getStreet());
        experienceDto.setCity(experience.getLocation().getCity());
        experienceDto.setCountry(experience.getLocation().getCountry());

        return experienceDto;
    }

    public Experience toExpEntity(ExperienceDto experienceDto, Experience experience, Location location) {
        experience.setCompanyName(experienceDto.getCompanyName());
        experience.setTitle(experienceDto.getTitle());
        experience.setStartDate(experienceDto.getStartDate());
        experience.setEndDate(experienceDto.getEndDate());
        experience.setCurrentEmp(experienceDto.isCurrentEmp());
        experience.setYearsOfExp(experienceDto.getYearsOfExp());
        experience.setLocation(location);

        return experience;
    }
}
