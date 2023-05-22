package com.amit.admindata.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDto {
	private int id;
	private String userName;
	private String password;
	private String dept;
	@Override
	public String toString() {
		return "AdminDto [id=" + id + ", userName=" + userName + ", password=" + password + ", dept=" + dept + "]";
	}
	

}
