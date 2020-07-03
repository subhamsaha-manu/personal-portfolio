package com.personal.portfolio.dto.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>Photo Data Transfer Object!</h1>
 * @author  Subham Saha
 * @version 1.0
 * @since   2024-07-03
 */


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
