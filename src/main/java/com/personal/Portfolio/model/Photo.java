package com.personal.portfolio.model;


import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>Photo Model!</h1>
 * Holds information about the User's Photo details.
 * A list of this object would be embedded in the a User's document
 * @author  Subham Saha
 * @version 1.0
 * @since   2024-07-03
 */

@NoArgsConstructor
@Data
public class Photo {

   private int id;

   private String urlForSmallerDimension;

   private String urlForLargerDimension;

   private String title;

   private String description;

   private int likeCounter;

}
