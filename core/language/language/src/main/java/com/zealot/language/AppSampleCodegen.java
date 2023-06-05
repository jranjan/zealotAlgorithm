/*
 * ********************************************************************************************************************
 *  Copyright(c) 2022, Jyoti Ranjan (jranjan@gmail.com) and his associates. All rights reserved.
 *
 * *******************************************************************************************************************
 */

package main.java.com.zealot.language;

import java.time.ZonedDateTime;
import java.util.Objects;

public class AppSampleCodegen {
    private String message;
    private ZonedDateTime timestamp;

    public AppSampleCodegen(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "SampleNotification{" +
                "message='" + message + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AppSampleCodegen)) return false;
        AppSampleCodegen that = (AppSampleCodegen) o;
        return Objects.equals(getMessage(), that.getMessage()) && Objects.equals(getTimestamp(), that.getTimestamp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMessage(), getTimestamp());
    }

    public static void main(String[] args) {
        AppSampleDummyProduct p = new AppSampleDummyProduct(("Car"));
        System.out.println(p.getName());

        printMessage("Hello, great tool");
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }
}
