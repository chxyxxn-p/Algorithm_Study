import java.util.ArrayList;

public class Solution {
	public int solution(int[][] board, int[] moves) {

		ArrayList<Integer> basket = new ArrayList<Integer>();

//		터트려 사라진 인형 갯수 카운트하는 변수
		int popCount = 0;

//		moves 배열을 순서대로 pop 처리 -> moves배열의 데이터는 board[a][b]에서 [b+1]에 해당(moves[1] = 1 -> board[a][0])
		for (int movesIndex = 0; movesIndex < moves.length; movesIndex++) {
			
//			board[a][b]에서 a값을 0부터 탐색 
			for (int boardIndex = 0; boardIndex < board.length; boardIndex++) {
				
//				한번 뽑은 뒤에 바구니에 2개 이상의 인형이 존재하면 최근 두개가 같은 모양인지 체크
//				매번 체크하기 때문에 최근 2개만 검사하고 그 아래쪽은 검사하지 않아도 됨
				if (basket.size() >= 2) {
					if (basket.get(basket.size()-1) == basket.get(basket.size()-2)) {
						for (int i = 0; i < 2; i++) {
							basket.remove(basket.size()-1);
							popCount++;
						}
					}
				}

//				board[a][b]에서 a, b값을 이중 포문으로 결정짓고, baord[a][b]값을 구한다
				int dollNum = board[boardIndex][moves[movesIndex] - 1];
				
//				구한 값이 0이면 그냥 통과하고, 0이 아니면
				if (dollNum != 0) {
//					바구니에 그 인형을 담고
					basket.add(dollNum);
//					크레인으로 뽑은 인형 자리에 빈칸 처리 (0 대입)
					board[boardIndex][moves[movesIndex] - 1] = 0;
					
//					moves 배열 데이터 하나당 한번만 뽑으면 되므로 break;처리하고 ....?
					break;
				}


			}
		}

		return popCount;
	}
}