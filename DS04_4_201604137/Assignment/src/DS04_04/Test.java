package DS04_04;
import java.io.*;

public class Test {
	
	public Test() {
	}
	public void run(String file) {
		
		int words = 0, chars = 0;
		
		try {
			
			// 한 줄 읽을 준비
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine(); // 한 줄 읽는다
			while (line != null) {
				MyStringTokenizer mst = new MyStringTokenizer(line, " ");
				while (mst.hasMoreTokens()) {
					++words;
					String word = mst.nextToken().toUpperCase(); 
					chars += word.length();
				}
				line=br.readLine(); //그 다음줄을 읽어서 아무 내용이 없음을 읽어들인다.(==NULL)
			}
			
			br.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("words:" + words);
		System.out.println("characters:" + chars);
	}
	
}
