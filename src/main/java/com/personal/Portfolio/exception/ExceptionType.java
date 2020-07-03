package com.personal.portfolio.exception;

/**
 * <h1>Exception Type Enums!</h1>
 * Different kind of exception that is presently handled has
 * been added as enum values
 * @author  Subham Saha
 * @version 1.0
 * @since   2024-07-03
 */

public enum ExceptionType {
    ENTITY_NOT_FOUND("not.found"),
    DUPLICATE_ENTITY("duplicate"),
    ENTITY_EXCEPTION("exception"),
    SYSTEM_EXCEPTION("exception"),
    MAIL_EXCEPTION("exception");
    String value;

    ExceptionType(String value){
        this.value = value;
    }

    String getValue(){
        return this.value;
    }
}
