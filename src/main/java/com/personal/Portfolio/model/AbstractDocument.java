package com.personal.portfolio.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.math.BigInteger;

@Data
public class AbstractDocument {

    @Id
    private ObjectId _id;


}
