package xyz.itwill.dto;

import lombok.Data;

/*
이름        널?       유형            
--------- -------- ------------- 
IN_NO     NOT NULL NUMBER(9)     
IN_ID     NOT NULL VARCHAR2(50)  
IN_ACNAME NOT NULL VARCHAR2(50)  
IN_CATE   NOT NULL VARCHAR2(20)  
IN_AMOUNT          NUMBER(10)    
IN_MEMO            VARCHAR2(100) 
IN_DATE   NOT NULL DATE
 */

@Data
public class Income {
	private Integer inNo;
	private String inId;
	private String inCate;
	private Integer inAmount;
	private String inAcname;
	private String inMemo;
	private String inDate;
}
