class Solution {
	int answer = 0;
	int[] numbers;
	int target;
	
    public int solution(int[] numbers, int target) {
      
    	this.numbers = numbers;
    	this.target = target;
    	
    	searchNode(0, 0);
    	
        return answer;
    }
    
    public static void main(String[] args) {
		int [] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		
		System.out.println(new Solution().solution(numbers, target));	//5
	}
    
    public void searchNode(int index, int sum) {
    	if(index == numbers.length) {	//탈출 조건
    		if(sum == target) {	//탈출 전 sum과 target이 같으면
    			answer++;	//이 경우의 수는 조건에 해당되므로 answer에 1 추가
    		}
    		return;	//재귀에서 빠져나온다(깊이 우선 탐색에서 가장 끝까지 간 것)
    	}
    	
//    	모든 경우의 수를 가지치기 해나간다
    	searchNode(index + 1, sum + numbers[index]);
    	searchNode(index + 1, sum - numbers[index]);
    }
}