package com.example.chattapppp.user;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
	 @Id
private String nickName;
private String fullName;
private Status status;
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public String getNickName() {
	return nickName;
}
public void setNickName(String nickName) {
	this.nickName = nickName;
}
public String getFullName() {
	return fullName;
}
public void setFullName(String fullName) {
	this.fullName = fullName;
}
public Status getStatus() {
	return status;
}
public void setStatus(Status status) {
	this.status = status;
}
public User(String nickName, String fullName, Status status) {
	super();
	this.nickName = nickName;
	this.fullName = fullName;
	this.status = status;
}
@Override
public int hashCode() {
	return Objects.hash(fullName, nickName, status);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	return Objects.equals(fullName, other.fullName) && Objects.equals(nickName, other.nickName)
			&& status == other.status;
}
public static User of(String nickName, String fullName, Status status) {
	return new User(nickName,fullName,status);
}
}