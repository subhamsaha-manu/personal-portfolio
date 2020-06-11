package com.personal.portfolio.dto.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
