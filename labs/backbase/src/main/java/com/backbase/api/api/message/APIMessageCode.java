package com.backbase.api.api.message;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum APIMessageCode {
  KS0601700(
      HttpStatus.NOT_FOUND,
      "External user input",
      "Resource",
      "Unable to find resource with given parameters"),
  KS0102700(
      HttpStatus.INTERNAL_SERVER_ERROR,
      "Internal components",
      "Service directory client",
      "Dependent service is down"),
  KS0000700(
      HttpStatus.INTERNAL_SERVER_ERROR,
      "Internal",
      "Unknown",
      "Failed to process request"),
  KS0602700(
      HttpStatus.BAD_REQUEST,
      "External user input",
      "Request payload",
      "Invalid UUID - %s"),
  KS0602701(
      HttpStatus.BAD_REQUEST,
      "External user input",
      "Request payload",
      " Given page %s size exceeds the maximum allowed page size %s"),
  KS0602702(
      HttpStatus.BAD_REQUEST,
      "External user input",
      "Request payload",
      "Page size must not be less than one"),
  KS0602703(
      HttpStatus.BAD_REQUEST,
      "External user input",
      "Request payload",
      "Page number must not be less than one"),
  KS0602704(
      HttpStatus.BAD_REQUEST,
      "External user input",
      "Request payload",
      "Given substrate %s is invalid. Please use one of these substrates - %s"),
  KS0602705(
      HttpStatus.BAD_REQUEST,
      "External user input",
      "Request payload",
      "Given entity type %s is invalid. Please use one of these entities - [service,feature]"),
  KS0602706(
      HttpStatus.BAD_REQUEST,
      "External user input",
      "Request payload",
      "Missing data"),
  KS0602707(
      HttpStatus.BAD_REQUEST,
      "External user input",
      "Request payload",
      "Invalid data provided"),
  KS0602708(
      HttpStatus.NOT_FOUND,
      "External user input",
      "Request payload",
      "Data not found for provided keys"),
  KS0602709(
      HttpStatus.BAD_REQUEST,
      "External user input",
      "Request payload",
      "Given substrate %s is not available for the service - %s"),
  KS0602710(
      HttpStatus.BAD_REQUEST,
      "External user input",
      "Request payload",
      "Id not found"),
  KS0602711(
      HttpStatus.BAD_REQUEST,
      "External user input",
      "Request payload",
      "Deletion cannot be done as it has dependencies. Please delete corresponding dependent elements/instance first"),
  KS0602712(
      HttpStatus.BAD_REQUEST,
      "External user input",
      "Request payload",
      "Data conflict"),
  KS0602713(
      HttpStatus.BAD_REQUEST,
      "External user input",
      "Request payload",
      "Please onboard the substrate first"),
  KS0602714(
      HttpStatus.BAD_REQUEST,
      "External user input",
      "Request payload",
      "Id is not allowed when you are creating data"),
  KS0602715(
      HttpStatus.BAD_REQUEST,
      "External user input",
      "Request payload",
      "Identity attributes cannot be updated/deleted"),
  KS0602716(
      HttpStatus.BAD_REQUEST,
      "External user input",
      "Request payload",
      "Given batch size %s exceeds the maximum allowed batch size %s"),
  KS0602717(
      HttpStatus.BAD_REQUEST,
      "External user input",
      "Request payload",
      "Identity attributes cannot be created after it is onboarded"),
  KS0602718(
      HttpStatus.BAD_REQUEST,
      "External user input",
      "Request payload",
      "Internal fields are not supposed to be given in input payload");

  private final String message;
  private final String category;
  private final String subCategory;
  private final HttpStatus status;

  APIMessageCode(HttpStatus status, String category, String subCategory, String message) {
    this.status = status;
    this.category = category;
    this.subCategory = subCategory;
    this.message = message;
  }
}
