package linkedin.profile.Mapper;

import linkedin.profile.DTO.ExperienceDto;
import linkedin.profile.DTO.LocationDto;
import linkedin.profile.entity.Location;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper {
    public LocationDto toLocDto(Location location) {
        LocationDto locationDto = new LocationDto();
        locationDto.setId(location.getId());
        locationDto.setHouseNum(location.getHouseNo());
        locationDto.setStreet(location.getStreet());
        locationDto.setCity(location.getCity());
        locationDto.setCountry(location.getCountry());
        return locationDto;
    }

    public Location toLocEntity(ExperienceDto experienceDto, Location location) {
        location.setHouseNo(experienceDto.getHouseNum());
        location.setStreet(experienceDto.getStreet());
        location.setCity(experienceDto.getCity());
        location.setCountry(experienceDto.getCountry());
        return location;
    }
}
