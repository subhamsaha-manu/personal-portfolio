package com.personal.portfolio.dto;


import lombok.Data;

import java.util.List;

@Data
public class EducationDTO {

    private String instituitionName;

    private String degree;

    private String endingDate;

    private String startingDate;

    private List<String> academicAchievements;
}
