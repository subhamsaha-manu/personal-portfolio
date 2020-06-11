package com.personal.portfolio.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Data
public class Education  {

    private String instituitionName;

    private String degree;

    private Date endingDate;

    private Date startingDate;

    private List<String> academicAchievements;

}
