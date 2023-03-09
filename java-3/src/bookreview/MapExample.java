package bookreview;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
	public static void main(String[] args) {
		Map<Integer, String> map=new HashMap<Integer, String>();
		
		map.put(96, "blue");
		map.put(86, "hong");
		map.put(92, "white");
		
		String name=null;
		int maxScore=0;
		int totalScore=0;
		
		for(Integer temp:map.keySet()) {
			totalScore+=temp;
			if(maxScore<temp) {
				maxScore=temp;
				name=map.get(maxScore);
			}
		}
		System.out.println("평균점수 = "+totalScore/map.size());
		System.out.println("최고점수 = "+maxScore);
		System.out.println("최고점수자 = "+name);
	}
}