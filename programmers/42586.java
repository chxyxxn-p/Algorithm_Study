import java.util.Stack;

class Solution {
public int[] solution(int[] progresses, int[] speeds) {
		int[] answer = {};
		Stack<Integer> answerSt = new Stack<Integer>();

//		progresses의 마지막 인덱스부터 거꾸로
//		완료되기까지 최소 며칠이 필요한지 구해서 스택에 push
		Stack<Integer> daySt = new Stack<Integer>();
		for (int i = progresses.length - 1; i >= 0; i--) {
//			몇 퍼센트 더 일해야하는지 (100-progresses[i]) 구하고 speeds[i]로 나눠서 며칠이 필요한지 구한다
//			올림 하여 int형식으로 바꾼다 (ex. 2.333일 더 필요 -> 3 push, 2일 필요 -> 2 push)
			if (progresses[i] == 100) {
				daySt.push(0);
				System.out.println("day stack push : 0");
			} else {
				int n = (int) Math.ceil(((100 - progresses[i]) / (double) speeds[i]));
				daySt.push(n);
				System.out.println("day stack push : " + n);
			}
		}

		int dayCount = -1;
		int doneCount = 0;

		while (true) {
			dayCount++;
			System.out.println("*dayCount : " + dayCount);

			if (daySt.empty()) {
				System.out.println("stack is empty");
				break;
			} else {
				System.out.println("stack is not empty");
				if (daySt.peek() > dayCount) {
					System.out.println("stack top value > dayCount");
					continue;
				} else {
					System.out.println("stack top value <= dayCount");
					int popValue = daySt.pop();
					System.out.println("popValue = " + popValue);
					doneCount++;
					System.out.println("doneCount : " + doneCount);

					while (true) {
						if (daySt.empty()) {
							System.out.println("stack is empty");
							break;
						} else {
							System.out.println("stack is not empty");
							if (daySt.peek() <= popValue) {
								System.out.println("stack top value <= popValue");
								int n = daySt.pop();
								System.out.println("pop : " + n);
								doneCount++;
								System.out.println("doneCount : " + doneCount);
							} else {
								System.out.println("stack top value >= popValue");
								break;
							}
						}
					}
				}

				System.out.println("escape while()");
				answerSt.push(doneCount);
				System.out.println("answerSt push : " + doneCount);
				doneCount = 0;
				System.out.println("doneCount : " + doneCount);
			}
		}

		answer = new int[answerSt.size()];
		System.out.println("set answer length : " + answerSt.size());
		for (int i = answer.length - 1; i >= 0; i--) {

			answer[i] = answerSt.pop();
		}

		return answer;
    }
}