package com.personal.portfolio.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@NoArgsConstructor
@Data
@Document(collection = "User")
public class User extends AbstractDocument{


@Field(name = "name")
private String fullName;

@Field("email")
private List<EmailAddress> emailAddresses;

@Field
private String profilePhotoUrl;

@Field
private String linkedInId;

@Field
private Long mobileNumber;

@Field
private String careerObjective;

@Field("experience")
private List<Experience> workExperience;

@Field
private List<Education> educationQualification;

@Field("interests")
private List<Interests> areasOfInterest;

@Field("skills")
private List<Skills> skills;

@Field("photos")
private List<Photo> photos;

}
