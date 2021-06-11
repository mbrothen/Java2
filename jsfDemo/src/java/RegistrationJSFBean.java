/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author mbrot
 */
@Named(value = "registration")
@RequestScoped
public class RegistrationJSFBean {
    private String lastName;
    private String firstName;
    private String mi;
    private String gender;
    private String major;
    private String[] minor;
    private String[] hobby;
    private String remarks;

    /**
     * Creates a new instance of RegistrationJSFBean
     */
    public RegistrationJSFBean() {
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getMi(){
        return mi;        
    }
    public void setMi(String mi){
        this.mi = mi;
    }
    public String getGender(){
        return gender;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public String getMajor(){
        return major;
    }
    public void setMajor(String major){
        this.major = major;
    }
    public String[] getMinor(){
        return minor;
    }
    public void setMinor(String[] minor){
        this.minor = minor;
    }
    public String[] getHobby() {
        return hobby;
    }
    public void setHobby(String[] hobby){
        this.hobby = hobby;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks){
        this.remarks=remarks;
    }
    public String getResponse(){
        if (lastName==null)
            return "";
        else{
            String allMinor ="";
            for (String s: minor){
                allMinor += s + " ";
            }
            String allHobby = "";
            for (String s: hobby) {
                allHobby += s + " ";
            }
            
            return "<p style=\"color:red\">You entered <br />" + 
                    "Last Name: " + lastName + "<br />" +
                    "First Name: " + firstName + "<br />" +
                    "MI: " + mi + "<br />" +
                    "Gender: " + gender + "<br />" + 
                    "Major: " + major + "<br />" +
                    "Minor: " + allMinor + "<br />"+
                    "Hobby: " + allHobby + "<br />" +
                    "Remarks: " + remarks + "</p>";
                    
        }
    }
}
