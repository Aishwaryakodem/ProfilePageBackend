package linkedin.profile.DTO;

import lombok.Data;

@Data
public class LocationDto {
    private Long id;
    private String houseNum;
    private String street;
    private String country;
    private String city;

}

