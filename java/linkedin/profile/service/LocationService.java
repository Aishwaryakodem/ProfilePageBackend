package linkedin.profile.service;

import linkedin.profile.DTO.ExperienceDto;
import linkedin.profile.DTO.LocationDto;
import linkedin.profile.Mapper.LocationMapper;
import linkedin.profile.entity.Location;
import linkedin.profile.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private LocationMapper locationMapper;

    public Location addOrUpdateLocation(ExperienceDto locationDto) {
        Location location = locationRepository.findById(locationDto.getLocationId()).orElseThrow();
        location = locationMapper.toLocEntity(locationDto, location);
        locationRepository.save(location);
        return location;
    }
}
