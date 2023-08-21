package linkedin.profile.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class EducationDto {
    private Long educationId;
    private Long userId;
    private String name;

    private Long degreeId;
    private String degreeName;

    private String startDate;
    private String endDate;
    private String grade;

}

