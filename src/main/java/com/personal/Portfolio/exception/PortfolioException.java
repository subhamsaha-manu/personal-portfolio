package com.personal.portfolio.exception;

import com.personal.portfolio.config.PropertiesConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.text.MessageFormat;
import java.util.Optional;


@Component
public class PortfolioException extends Exception {


    private static PropertiesConfig propertiesConfig;

    @Autowired
    PortfolioException(PropertiesConfig propertiesConfig){PortfolioException.propertiesConfig = propertiesConfig;}


    public static RuntimeException throwException(String messageTemplate, String... args) {
        return new RuntimeException(format(messageTemplate, args));
    }

    public static RuntimeException throwsException(EntityType entityType, ExceptionType exceptionType, String...args) {
        String exceptionTemplate = getExceptionTemplate(entityType,exceptionType);
        return throwException(exceptionType,exceptionTemplate,args);
    }

    private static RuntimeException throwException(ExceptionType exceptionType, String exceptionTemplate, String...args) {
        if(ExceptionType.ENTITY_NOT_FOUND.equals(exceptionType)){
            return new EntityNotFoundException(format(exceptionTemplate,args));
        }else if(ExceptionType.DUPLICATE_ENTITY.equals(exceptionType)){
            return new DuplicateEntityException(format(exceptionTemplate,args));
        }
        return new RuntimeException(format(exceptionTemplate,args));
    }

    private static String format(String exceptionTemplate, String...args) {
        Optional<String> exceptionMessage = Optional.ofNullable(propertiesConfig.getConfigValue(exceptionTemplate));
        if(exceptionMessage.isPresent()){
            return MessageFormat.format(exceptionMessage.get(),args);
        }
        return String.format(exceptionTemplate,args);
    }

    private static String getExceptionTemplate(EntityType entityType, ExceptionType exceptionType) {
        return entityType.name().concat(".").concat(exceptionType.getValue()).toLowerCase();
    }

    public static class EntityNotFoundException extends RuntimeException{
        public EntityNotFoundException(String message){
            super(message);
        }
    }


    public static class DuplicateEntityException extends RuntimeException {
        public DuplicateEntityException(String message) {
            super(message);
        }
    }
}
