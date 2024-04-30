package threads;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class TempMatrixWriter {

	public static void main(String []args) throws IOException {
		String outPathString="src/main/resources/matrixFile.out";
		FileWriter fWriter=new FileWriter(new File(outPathString));
		Random random=new Random();
		
		for(int k=0;k<1000000;k++) {
			for(int i=0;i<10;i++) {
				for(int j=0;j<10;j++) {
					fWriter.write(String.valueOf(random.nextInt(1000)));
					if(j!=9)
					fWriter.write(',');
				}
				fWriter.write('\n');
			}
//			fWriter.write('\n');
			fWriter.write('\n');
		}
		
		
		
		
		fWriter.close();
		
		
		
		
		
	}
	
	
	
}
