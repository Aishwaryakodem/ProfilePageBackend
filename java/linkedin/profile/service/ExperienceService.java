package linkedin.profile.service;

import linkedin.profile.DTO.ExperienceDto;
import linkedin.profile.Mapper.ExperienceMapper;
import linkedin.profile.Mapper.LocationMapper;
import linkedin.profile.entity.Experience;
import linkedin.profile.entity.Location;
import linkedin.profile.repository.ExperienceRepository;
import linkedin.profile.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExperienceService {

    @Autowired
    private ExperienceRepository experienceRepository;
    @Autowired
    private ExperienceMapper experienceMapper;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private LocationService locationService;
    @Autowired
    private LocationMapper locationMapper;

//    public List<ExperienceDto> getExperience(Long userId) {
//        List<ExperienceDto> experienceDtos = new ArrayList<>();
//        List<Experience> experiences = (List<Experience>) experienceRepository.findAllByUserId(userId);
//        List<Long> locationIdList = new ArrayList<>();
//
//        for (Experience experience: experiences) {
//            locationIdList.add(experience.getLocationId());
//        }
//
//        List<Location> locations = (List<Location>) locationRepository.findAllById(locationIdList);
//
//        Map<Long, Location> locationMap = new HashMap<>();
//        for (Location location : locations) {
//            locationMap.put(location.getId(), location);
//        }
//        for (Experience experience : experiences) {
//            experienceDtos.add(experienceMapper.toExpDto(experience, locationMap.get(experience.getLocationId())));
//        }
//        return experienceDtos;
//    }

    public List<ExperienceDto> getExperienceShortCode(Long userId) {
        List<ExperienceDto> experienceDtos = new ArrayList<>();
        List<Experience> experiences = experienceRepository.findAllByUserId(userId);

        for (Experience experience : experiences) {
            experienceDtos.add(experienceMapper.toExpDtoShortCode(experience));
        }
        System.out.println(experienceDtos);
        return experienceDtos;
    }

    public ExperienceDto addOrUpdateExperience(ExperienceDto experienceDto, Long userId) {
        Location location = new Location();
        if (experienceDto.getLocationId() == null) {
            location = locationMapper.toLocEntity(experienceDto, new Location());
            locationRepository.save(location);
        } else {
            location = locationService.addOrUpdateLocation(experienceDto);
        }
        System.out.println(location);
        Long locationId = location.getId();
        Experience experience = new Experience();
        if (experienceDto.getId() != null) {
            experience = experienceRepository.findById(experienceDto.getId()).orElseThrow(null);
        }
        experience.setUserId(userId);
        experience = experienceMapper.toExpEntity(experienceDto, experience, location);
        System.out.println(experience);
        experienceRepository.save(experience);
        return experienceMapper.toExpDtoShortCode(experience);
    }

    public void deleteExperience(Long id) {
        if (experienceRepository.existsById(id)) {
            experienceRepository.deleteById(id);
        }
    }
}
