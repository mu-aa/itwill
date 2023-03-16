package xyz.itwill.dto;
//
import lombok.Data;
/*
이름         널?       유형            
---------- -------- ------------- 
USERID     NOT NULL VARCHAR2(50)  
PASSWD              VARCHAR2(200) 
USERNAME            VARCHAR2(50)  
GENDER              NUMBER(1)     
PHONE               VARCHAR2(50)  
EMAIL               VARCHAR2(100) 
AREA                NUMBER(6)     
USERSTATUS          NUMBER(1) 
*/
@Data
public class Member {
	private String userid;
	private String passwd;
	private String username;
	private int gender;
	private String phone;
	private String email;
	private int area;
	private int userstatus;
}