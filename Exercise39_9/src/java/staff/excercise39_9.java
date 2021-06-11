/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staff;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import javax.enterprise.context.RequestScoped;


/**
 *
 * @author mbrothen
 */
@Named(value = "staffForm")
@RequestScoped

public class excercise39_9 implements Serializable {

    /**
     * Creates a new instance of excercise39_9
     */
    private String idNumber;
    private String firstName;
    private String mi;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String phone;
    private Statement stmt;
    private String status ="";
    
    public String getIdNumber() {
        return idNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMi() {
        return mi;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPhone() {
        return phone;
    }
    public String getStatus() {
        return status;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMi(String mi) {
        this.mi = mi;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setStatus(String status) {
        this.status =status;
    }
    public void connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection conn = DriverManager.getConnection
            ("jdbc:mysql://apollo.gtc.edu/brothenm2_javabook", "brothenm2", "password");

            setStatus("<p>Database connected</p>");

            stmt = conn.createStatement();
            }
        catch (Exception ex) {
            setStatus("<p>Connection failed: " + ex + "</p>");
        }
    }
    
    public void view() {
        
        //gets database record with the user entered ID number, calls fillForm to update rest of form
        String query = "SELECT * FROM Staff WHERE ID = " + "'" + getIdNumber().trim() + "'";
        try{
            ResultSet rs = stmt.executeQuery(query);
            fillForm(rs);
        }
        catch(SQLException ex) {
            setStatus("Select failed: " + ex);
        }
    }
    private void fillForm(ResultSet rs)throws SQLException{
        //Takes resultset and adds information to for fields
        if (rs.next()){
                setLastName(rs.getString(2));
                setFirstName(rs.getString(3));
                setMi(rs.getString(4));
                setAddress(rs.getString(5));
                setCity(rs.getString(6));
                setState(rs.getString(7));
                setPhone(rs.getString(8));
                setStatus("Record found");
        }
        else
                setStatus("Record not found");
	}
    public void insert() {
        //Takes user entered information and creates a new table entry
        String insertStmt = "INSERT INTO Staff( ID, LastName, FirstName, mi, Address, " + " City, State, Telephone) VALUES('" +
            getIdNumber().trim() + "','" +
            getLastName().trim() + "','" +
            getFirstName().trim() + "','" +
            getMi().trim() + "','" +
            getAddress().trim() + "','"+
            getCity().trim() + "','" +
            getState().trim() + "','" +
            getPhone().trim() + "');";

        try {
                stmt.executeUpdate(insertStmt);
        }
        catch (SQLException ex) {
                setStatus("Insertion failed: " + ex);
        }

            setStatus("record inserted");
    }
    
    public void update() {
        //Updates existing entry based on employee id
        String updateStmt = "UPDATE Staff " +

                "SET LastName = '" + getLastName().trim() + "','" +
                "FirstName = '" + getFirstName().trim() + "','" +
                "mi = '" + getMi().trim() + "','" +
                "Address = '" + getAddress().trim() + "','"+
                "City = '" + getCity().trim() + "','" +
                "State = '" + getState().trim() + "','" +
                "Telephon = '" + getPhone().trim() + "' " +
                "WHERE ID = '" + getIdNumber().trim() + "';";

    try {
        stmt.executeUpdate(updateStmt);
    }
    catch (SQLException ex) {
        setStatus("update failed: " + ex);
    }

        setStatus("record updated");
    }
    
    public void clear() {
        //Clears form
        setIdNumber(null);
        setFirstName(null);
        setMi(null);
        setLastName(null);
        setAddress(null);
        setCity(null);
        setState(null);
        setPhone(null);
    }
    
    public excercise39_9() {
        connect();
        
    }
    
}
