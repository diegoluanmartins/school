package com.cprt.school.domain.referal;

import java.time.LocalDateTime;

import com.cprt.school.domain.student.Student;

public class Referal {
    
    private Student referee;
    private Student referrer;
    private LocalDateTime referalDate;
    
    public Referal(Student referee, Student referrer) {
        this.referee = referee;
        this.referrer = referrer;
        this.referalDate = LocalDateTime.now();
    }

    public Student getReferee() {
        return referee;
    }

    public Student getReferrer() {
        return referrer;
    }

    public LocalDateTime getReferalDate() {
        return referalDate;
    }

}
