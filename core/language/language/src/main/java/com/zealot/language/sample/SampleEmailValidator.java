/*
 * ********************************************************************************************************************
 *  Copyright(c) 2022, Jyoti Ranjan (jranjan@gmail.com) and his associates. All rights reserved.
 *
 * *******************************************************************************************************************
 */

package main.java.com.zealot.language.sample;

public class SampleEmailValidator {

    private String emailId;
    private String password;

    public SampleEmailValidator(String emailId, String password) {
        this.emailId = emailId;
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
