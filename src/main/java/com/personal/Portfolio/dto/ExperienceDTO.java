package com.personal.portfolio.dto;

import lombok.Data;

import java.util.List;

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
