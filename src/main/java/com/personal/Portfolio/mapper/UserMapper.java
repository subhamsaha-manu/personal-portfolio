package com.personal.portfolio.mapper;

import com.personal.portfolio.dto.model.*;
import com.personal.portfolio.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

/**
 * <h1>Mapper Interface!</h1>
 * Helps to Map a Model object into a DTO object with the necessary modifications
 * and vice versa.
 * @author  Subham Saha
 * @version 1.0
 * @since   2024-07-03
 */

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(target = "firstName",source = "fullName",
                    qualifiedByName = "firstNameExtractor"),
            @Mapping(target = "middleName",source = "fullName",
                    qualifiedByName = "middleNameExtractor"),
            @Mapping(target = "lastName",source = "fullName",
                    qualifiedByName = "lastNameExtractor")
    })
    UserDTO userToUserDTO(User user);

    EmailAddressDTO emailAddressToEmailAddressDTO(EmailAddress emailAddress);

    //List<EmailAddressDTO> emailAddressToEmailAddressDTO(List<EmailAddress> emailAddress);

    /**
     * Modifies the date values in the experience embedded document to a specified
     * format.     *
     * @param experience
     * @return
     */
    @Mappings({
      @Mapping(target = "joiningDate", source = "joiningDate",
              qualifiedByName = "dateFormatter"),
      @Mapping(target = "endingDate", source = "endingDate",
              qualifiedByName = "dateFormatter")
    })
    ExperienceDTO experienceToExperienceDTO(Experience experience);

    @Mappings({
       @Mapping(target = "startingDate", source = "startingDate",
               qualifiedByName = "dateFormatter"),
       @Mapping(target = "endingDate", source = "endingDate",
               qualifiedByName = "dateFormatter")
    })
    EducationDTO educationToEducationDTO(Education education);

    InterestsDTO interestsToInterestsDTO(Interests interests);

    SkillsDTO skillsToSkillsDTO(Skills skills);

    PhotoDTO photoToPhotoDTO(Photo photos);

    @Named("firstNameExtractor")
    public static String getFirstName(String name){
        String[] nameParts = name.split(" ");
        return nameParts[0];
    }

    @Named("middleNameExtractor")
    public static String getMiddleName(String name){
        String[] nameParts = name.split(" ");
        if(nameParts.length == 3)
            return nameParts[1];
        else
            return " ";
    }

    @Named("lastNameExtractor")
    public static String getLastName(String name){
        String[] nameParts = name.split(" ");
        if(nameParts.length == 3)
            return nameParts[2];
        else
            return nameParts[1];
    }

    @Named("dateFormatter")
    public static String dateFormatter(Date endingDate){
        Optional<Date> date = Optional.ofNullable(endingDate);
        if(!date.isPresent())
            return "Present";
        else {
            String dateString = date.get().toString();
            final DateTimeFormatter inputFormat =
                    DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy");
            final ZonedDateTime parsed = ZonedDateTime.parse(dateString, inputFormat);
            final DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
            String outputFormatOfDateFormatter =  outputFormat.format(parsed);
            String desiredFormat =  outputFormatOfDateFormatter.substring(outputFormatOfDateFormatter.indexOf("-")+1);
           return desiredFormat;
        }
    }
}
