package com.personal.portfolio.dto.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.Binary;

import java.util.List;

@NoArgsConstructor
@Data
public class PhotoDTO {
    private Long id;

    private String urlForSmallerDimension;

    private String urlForLargerDimension;

    private String title;

    private String description;

    private int likeCounter;
}
