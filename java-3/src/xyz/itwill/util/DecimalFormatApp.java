package xyz.itwill.util;

import java.text.DecimalFormat;

public class DecimalFormatApp {
	public static void main(String[] args) {
		//DecimalFormat(String Pattern) : 숫자값에 대한 패턴정보가 저장된 DecimalFormat 객체를
		//ㄴ 패턴문자 : #(숫자 - 공백), 0(숫자 - 0), 콤마(,), 소숫점(.), 달러($), E(화폐)
		DecimalFormat decimalFormat=new DecimalFormat("###,###,##0"); // "###,###,##0" == 패턴정보
		
		int money=100_000_000;
		
		System.out.println("금액 = "+money+"원");
		
		//DecimalFormat.format(long number) : 매개변수로 숫자값을 전달받아
		//DecimalFormat 객체에 저장된 패턴정보의 문자열로 변환하여 반환하는 메소드
		System.out.print("금액 = "+decimalFormat.format(money)+"원");
		
		decimalFormat.applyPattern("$##,###,##0.00");
		System.out.print("\n금액 = "+decimalFormat.format(money));
		
		//DecimalFormat.getInstance() : 숫자값에 대한 기본 패턴정보가 저장된 DecimalFormat 객체를 반환하는 메소드
		System.out.println("\n금액 = "+DecimalFormat.getInstance().format(money)+"원");
		//DecimalFormat.getInstance() : 숫자값에 대한 화폐단위가 포함된 기본 패턴정보가 저장된 DecimalFormat 객체를 반환하는 메소드
		System.out.println("\n금액 = "+DecimalFormat.getCurrencyInstance().format(money));
		
	}
}
