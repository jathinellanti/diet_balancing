package com.example.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    private String email; // Email as the primary key

    private String name; // Full name of the user
    private String password; // Password for user authentication
    private String gender; // Gender of the user
    private String birthDate; // Date of birth (stored in "YYYY-MM-DD" format)
    private String heightFeet; // Height in feet
    private String heightInches; // Height in inches
    private String weight; // Weight of the user in appropriate units (e.g., kg or lbs)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getHeightFeet() {
		return heightFeet;
	}
	public void setHeightFeet(String heightFeet) {
		this.heightFeet = heightFeet;
	}
	public String getHeightInches() {
		return heightInches;
	}
	public void setHeightInches(String heightInches) {
		this.heightInches = heightInches;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "User [email=" + email + ", name=" + name + ", password=" + password + ", gender=" + gender
				+ ", birthDate=" + birthDate + ", heightFeet=" + heightFeet + ", heightInches=" + heightInches
				+ ", weight=" + weight + "]";
	}

}
