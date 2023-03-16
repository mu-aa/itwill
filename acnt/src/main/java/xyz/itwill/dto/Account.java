package xyz.itwill.dto;

import lombok.Data;

/*
이름         널?       유형            
---------- -------- ------------- 
AC_NAME    NOT NULL VARCHAR2(50)  
AC_BANK             VARCHAR2(50)  
AC_MEMO             VARCHAR2(100) 
AC_BALANCE          NUMBER(20)    
AC_CARD    NOT NULL VARCHAR2(50) 
*/

@Data
public class Account {
	private Integer acNo;
	private String acName;
	private String acBank;
	private String acMemo;
	private Integer acBalance;
	private String acCard;
}
