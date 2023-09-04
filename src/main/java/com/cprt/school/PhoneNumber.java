package com.cprt.school;

public class PhoneNumber {

    private String ddd;
    private String number;

    public PhoneNumber(String ddd, String number) {
        checkValidNumber(ddd, "^\\d{2}$");
        checkValidNumber(number, "^\\d{8,9}$");
        this.ddd = ddd;
        this.number = number;
    }

    private void checkValidNumber(String value, String regex) {
        if (!((value != null) && (value.matches(regex)))) {
            throw new IllegalArgumentException(value);
        }
    }

    public String getPhoneNumber(){
        return this.ddd + "-" + this.number;
    }

    public String getDdd(){
        return this.ddd;
    }

    public String getNumber(){
        return this.number;
    }

}
