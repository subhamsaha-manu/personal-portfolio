package com.personal.portfolio.model;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.persistence.Id;

@Data
@Document(collection = "User")
public class User {

@Id
private String id;

private String name;

private String email;
}
