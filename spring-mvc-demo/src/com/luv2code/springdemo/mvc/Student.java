package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class Student {
  private String firstName;
  
  @NotNull(message="is required")
  @Size(min=1,message="is required")
  private String lastName;
  private String country;
  private String favoriteLanguage;
  private String[] operatingSystems;
  
  @com.luv2code.springdemo.mvc.validation.CourseCode
  private String courseCode;
  
  @NotNull(message="is required")
  @Min(value=0, message="must >=0")
  @Max(value=10,message="must <=10")
  private Integer freePasses;
  @Pattern(regexp="^[a-zA-Z0-9]{5}", message="only 5 chars/digs")
  private String postalCode;
  
  
public Integer getFreePasses() {
	return freePasses;
}
public void setFreePasses(Integer freePasses) {
	this.freePasses = freePasses;
}
public String[] getOperatingSystems() {
	return operatingSystems;
}
public void setOperatingSystems(String[] operatingSystems) {
	this.operatingSystems = operatingSystems;
}
public String getFavoriteLanguage() {
	return favoriteLanguage;
}
public void setFavoriteLanguage(String favoriteLanguage) {
	this.favoriteLanguage = favoriteLanguage;
}
private LinkedHashMap<String,String> countryOptions;
  public Student() {
	  //population country options:used ISO country code
	  countryOptions=new LinkedHashMap();
	  countryOptions.put("BR", "Brazil");
	  countryOptions.put("FR", "France");
	  countryOptions.put("DE", "Germany");
	  countryOptions.put("IN", "India");
  }
public LinkedHashMap<String, String> getCountryOptions() {
	return countryOptions;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getPostalCode() {
	return postalCode;
}
public void setPostalCode(String postalCode) {
	this.postalCode = postalCode;
}

  
}
