package com.personal.portfolio.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

/**
 * <h1>Education Model!</h1>
 * Holds information about the User's Education details.
 * A list of this object would be embedded in a User's document
 * @author  Subham Saha
 * @version 1.0
 * @since   2024-07-03
 */

@NoArgsConstructor
@Data
public class Education  {

    private String instituitionName;

    private String degree;

    private Date endingDate;

    private Date startingDate;

    private List<String> academicAchievements;

}
