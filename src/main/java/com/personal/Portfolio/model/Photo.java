package com.personal.portfolio.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
