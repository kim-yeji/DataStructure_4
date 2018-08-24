package DS04_04;

public class MyStringTokenizer {

	private String[] words;
	private String line = "";
	private String token = "";
	private int index; //가져오는용 hasNext용

	public MyStringTokenizer(String line, String token) {
		this.line = line;
		this.token = token;//delimiter
		this.words = makeWords(line, token);
		this.index = 0;
	}

	//단어의 배열을 만들어 주는 함수
	public String[] makeWords(String line, String token) {
		String[] tmp = null;

		int splitIndex = 0; // 나중에 tmp에 추가할때 참조하기위한 인덱스. 첫번째는 tmp의0번째에 넣고..
		int splitLength = 1; // 스트링배열의 개수 띄어쓰기3개면 단어4개=> 배열도 4개만큼 만들어줌
		int beginIndex = 0; // 자를때 어디서부터 어디까지 잘라야하는지의 기준
		int lastIndex = 0; //저는 lastIndex대신 i를 사용하여 단어의 마지막 위치를 표시하였습니다.

		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == ' ')
				splitLength++;
		}

		tmp = new String[splitLength];
		
		for (int i = 0; i < line.length(); i++) {
			if (splitLength == (splitIndex + 1)) { // 맨 마지막부분에서의 예외처리
				tmp[splitIndex] = line.substring(beginIndex, line.length());
				break;
			} else if (line.charAt(i) == ' ') {
				tmp[splitIndex] = line.substring(beginIndex, i);
				beginIndex=i+1; //구분자 다음 글자를 가져오기 위해서 +1
				splitIndex++;
			}
		}
		return tmp;

	}

	public boolean hasMoreTokens() {
		if(words.length == index) return false;
		else return true;
	 }
	
	public String nextToken() {
		return words[index++];
	}
}
