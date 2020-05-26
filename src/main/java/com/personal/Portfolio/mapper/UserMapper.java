package com.personal.portfolio.mapper;

import com.personal.portfolio.dto.*;
import com.personal.portfolio.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    @Mappings({
      @Mapping(target = "joiningDate", source = "joiningDate",
              dateFormat = "yyyy-MM-dd"),
      @Mapping(target = "endingDate", source = "endingDate",
              qualifiedByName = "checkIfPresentOrganization")
    })
    ExperienceDTO experienceToExperienceDTO(Experience experience);

    @Mappings({
            @Mapping(target = "startingDate", source = "startingDate",
                    dateFormat = "yyyy-MM-dd"),
            @Mapping(target = "endingDate", source = "endingDate",
                    dateFormat = "yyyy-MM-dd")
    })
    EducationDTO educationToEducationDTO(Education education);

    InterestsDTO interestsToInterestsDTO(Interests interests);

    SkillsDTO skillsToSkillsDTO(Skills skills);

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

    @Named("checkIfPresentOrganization")
    public static String checkIfPresentOrganization(Date endingDate){
        Optional<Date> date = Optional.ofNullable(endingDate);
        if(!date.isPresent())
            return "Present";
        else {
            String dateString = date.get().toString();
            final DateTimeFormatter inputFormat =
                    DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy");
            final ZonedDateTime parsed = ZonedDateTime.parse(dateString, inputFormat);
            final DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

           return outputFormat.format(parsed);
        }
    }
}
