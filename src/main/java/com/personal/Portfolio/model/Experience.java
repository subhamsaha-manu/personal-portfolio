package com.personal.portfolio.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * <h1>Experience Model!</h1>
 * Holds information about the User's Experience details.
 * A list of this object would be embedded in the a User's document
 * @author  Subham Saha
 * @version 1.0
 * @since   2024-07-03
 */

@NoArgsConstructor
@Data
public class Experience {

    private String officeName;

    private String designation;

    private Date joiningDate;

    private Date endingDate;

    private List<String> workExperience;

}
