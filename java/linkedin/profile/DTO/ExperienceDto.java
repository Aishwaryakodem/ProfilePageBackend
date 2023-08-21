package linkedin.profile.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class ExperienceDto {
    private Long id;
    private Long userId;
    private String title;
    private String companyName;
    private int yearsOfExp;
    private Date startDate;
    private Date endDate;
    private boolean isCurrentEmp;
    private Long locationId;
    private String houseNum;
    private String street;
    private String country;
    private String city;
//    private LocationDto locationDto;
}
