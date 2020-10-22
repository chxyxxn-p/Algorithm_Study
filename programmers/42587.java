import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int solution(int[] priorities, int location) {
		int answer = 0;

		Queue<Integer> queue = new LinkedList<Integer>();
		
		for (int i = 0; i < priorities.length; i++) {
			queue.add(priorities[i]); // 주어진 중요도 배열의 원소들을 queue에 순서대로 삽입
		}
				
		// 맨 앞의 원소를 반환
		while (true) {
			Integer front = queue.poll();

			// front가 null이면 queue 비어있다
			if (front == null) {
				break;
			}
            
			boolean flag = false;

			// 두번째 원소부터 마지막 원소까지 큐에서 반환해서 front보다 중요도 큰지 검사 후 다시 삽입
			for (int i = 0; i < queue.size(); i++) {
				Integer item = queue.poll();
				
				if (front < item) {
					flag = true; // 중요도가 더 큰 원소가 있다고 체크
				}

				queue.add(item);
			}

			if (flag) {
				// front보다 중요도 더 큰 원소 있으면 front를 다시 queue의 마지막에 삽입
				queue.add(front);

			} else {
				
				answer++; // 삭제 처리한 문서 갯수 증가
				
				if (location == 0) {
					break;
				}
			}
			
			//처음에 front를 반환했으므로 location 값 조정
			location--;
			if (location == -1) {
				location = queue.size() - 1;
			}
		}

		return answer;
	}
}