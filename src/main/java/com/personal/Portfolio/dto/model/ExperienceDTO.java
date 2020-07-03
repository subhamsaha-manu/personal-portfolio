package com.personal.portfolio.dto.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <h1>Experience Data Transfer Object!</h1>
 * @author  Subham Saha
 * @version 1.0
 * @since   2024-07-03
 */

@NoArgsConstructor
@Data
public class ExperienceDTO {

    private String officeName;

    private String position;

    private int grade;

    private int level;

    private String designation;

    private String joiningDate;

    private String endingDate;

    private List<String> workExperience;
}
