package com.personal.portfolio.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * <h1>Abstract Collection Document!</h1>
 * Contains the common fields, here the Id which is the unqiue identifier
 * to each document.
 * @author  Subham Saha
 * @version 1.0
 * @since   2024-07-03
 */


public class AbstractDocument {

    @Id
    private ObjectId _id;


}
