package DS04_04;
import java.io.*;

public class Test {
	
	public Test() {
	}
	public void run(String file) {
		
		int words = 0, chars = 0;
		
		try {
			
			// �� �� ���� �غ�
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine(); // �� �� �д´�
			while (line != null) {
				MyStringTokenizer mst = new MyStringTokenizer(line, " ");
				while (mst.hasMoreTokens()) {
					++words;
					String word = mst.nextToken().toUpperCase(); 
					chars += word.length();
				}
				line=br.readLine(); //�� �������� �о �ƹ� ������ ������ �о���δ�.(==NULL)
			}
			
			br.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("words:" + words);
		System.out.println("characters:" + chars);
	}
	
}
