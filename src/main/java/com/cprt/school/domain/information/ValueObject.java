package com.cprt.school.domain.information;

public abstract class ValueObject {

    String value;
    String regex;

    protected ValueObject(String value, String regex) throws IllegalArgumentException {
        this.regex = regex;
        update(value);
    }

    protected void update(String email) throws IllegalArgumentException {
        if (!isValidText(email)) {
            throw new IllegalArgumentException(email);
        }
        this.value = email;
    }

    private boolean isValidText(String value) {
        return (value != null) && (value.matches(regex));
    }

    protected String getValue(){
        return this.getValue();
    }

}
