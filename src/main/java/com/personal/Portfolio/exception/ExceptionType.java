package com.personal.portfolio.exception;

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
