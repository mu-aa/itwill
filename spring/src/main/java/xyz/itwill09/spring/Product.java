package xyz.itwill09.spring;

import lombok.AllArgsConstructor;
import lombok.Data;

//상품정보를 저장하기 위한 클래스 - VO 클래스
@AllArgsConstructor
@Data
public class Product {
	private int num;
	private String name;
}