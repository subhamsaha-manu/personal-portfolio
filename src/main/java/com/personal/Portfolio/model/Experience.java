package com.personal.portfolio.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Data
public class Experience {

    private String officeName;

    private String designation;

    private Date joiningDate;

    private Date endingDate;

    private List<String> workExperience;

}
