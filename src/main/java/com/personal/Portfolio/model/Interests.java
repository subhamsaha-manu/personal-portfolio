package com.personal.portfolio.model;

import lombok.Data;
import lombok.NoArgsConstructor;



/**
 * <h1>Interests Model!</h1>
 * Holds information about the User's Interest details.
 * A list of this object would be embedded in the a User's document
 * @author  Subham Saha
 * @version 1.0
 * @since   2024-07-03
 */

@NoArgsConstructor
@Data
public class Interests {

    private String value;
}
