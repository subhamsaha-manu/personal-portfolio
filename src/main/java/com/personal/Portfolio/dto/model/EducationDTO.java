package com.personal.portfolio.dto.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <h1>Education Data Transfer Object!</h1>
 * @author  Subham Saha
 * @version 1.0
 * @since   2024-07-03
 */
@NoArgsConstructor
@Data
public class EducationDTO {

    private String instituitionName;

    private String degree;

    private String endingDate;

    private String startingDate;

    private List<String> academicAchievements;
}
