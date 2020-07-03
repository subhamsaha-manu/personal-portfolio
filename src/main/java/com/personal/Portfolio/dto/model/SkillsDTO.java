package com.personal.portfolio.dto.model;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * <h1>Skills Data Transfer Object!</h1>
 * @author  Subham Saha
 * @version 1.0
 * @since   2024-07-03
 */

@NoArgsConstructor
@Data
public class SkillsDTO {

    private String skill;

    private boolean workingExperience;

    private int skillLevel;

}
