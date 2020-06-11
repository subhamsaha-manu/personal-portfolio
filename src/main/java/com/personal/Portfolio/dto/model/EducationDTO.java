package com.personal.portfolio.dto.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class EducationDTO {

    private String instituitionName;

    private String degree;

    private String endingDate;

    private String startingDate;

    private List<String> academicAchievements;
}
