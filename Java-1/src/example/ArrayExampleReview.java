package example;

public class ArrayExampleReview {
	public static void main(String[] args) {
		// 사람들의 나이를 저장한 배열 생성
		int[] age = { 27, 16, 22, 36, 57, 60, 43, 23, 14, 29, 44, 52, 59, 51, 39, 33, 11 };

		// 배열에 저장된 모든 사람들이 나이 평균을 계산하여 출력하세요.

		int tot = 0;

		for (int temp : age) {
			tot += temp;
		}

		System.out.println("나이 평균 : " + tot / age.length);

		// 배열에 저장된 사람들의 나이를 연령별로 구분하여 인원수를 계산하여 출력하세요.
		// ex) 10대 = 3명
		// 20대 = 4명
		// ...
		// 60대 = 1명

		int[] cnt = new int[6];

		for (int temp : age) {
			cnt[temp / 10 - 1]++;
		}

		for (int i = 0; i < cnt.length; i++) {
			System.out.println((i + 1) * 10 + "대 : " + cnt[i] + "명");
		}
	}
}
