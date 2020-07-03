package com.personal.portfolio.dto.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * <h1>User Data Transfer Object!</h1>
 * @author  Subham Saha
 * @version 1.0
 * @since   2024-07-03
 */

@NoArgsConstructor
@Data
public class UserDTO {

    private String firstName;

    private String middleName;

    private String lastName;

    private List<EmailAddressDTO> emailAddresses;

    private String profilePhotoUrl;

    private String linkedInId;

    private Long mobileNumber;

    private String careerObjective;

    private List<ExperienceDTO> workExperience;

    private List<EducationDTO> educationQualification;

    private List<InterestsDTO> areasOfInterest;

    private List<SkillsDTO> skills;

    private List<PhotoDTO> photos;

}
