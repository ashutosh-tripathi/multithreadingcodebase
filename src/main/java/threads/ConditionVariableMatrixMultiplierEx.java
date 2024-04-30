package threads;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringJoiner;


public class ConditionVariableMatrixMultiplierEx {

	private static final int N=10;
	private static final String inpfile="src/main/resources/matrixFile.out";
	private static final String outfile="src/main/resources/matrixOutFile.out";
	public static void main(String[] args) throws IOException {
		ThreadQueue threadeQueue=new ThreadQueue();
		File inpFile=new File(inpfile);
		File outFile=new File(outfile);
		MatrixReaderProducer matrixReaderProducer=new MatrixReaderProducer(new FileReader(inpFile), threadeQueue);
		MatrixMultiplierConsumer matrixMultiplierConsumer=new MatrixMultiplierConsumer(threadeQueue, new FileWriter(outFile));
		matrixReaderProducer.start();
		matrixMultiplierConsumer.start();
	}
	
	private static class MatrixMultiplierConsumer extends Thread{
		private ThreadQueue threadQueue;
		private FileWriter fileWriter;
		
		
		public MatrixMultiplierConsumer(ThreadQueue _threadQueue,FileWriter _fileWriter) {
			threadQueue=_threadQueue;
			fileWriter=_fileWriter;
		}
		private void saveMatrixtofile(FileWriter fileWriter,int[][]matrix) {
			for(int r=0;r<N;r++) {
				StringJoiner stringJoiner=new StringJoiner(",");
				for(int c=0;c<N;c++) {
					stringJoiner.add(String.valueOf(matrix[r][c]));
				
			}
				try {
					fileWriter.write(stringJoiner.toString());
					fileWriter.write('\n');
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
			try {
				fileWriter.write('\n');
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			while(true) {
				MatrixPair matrixPair=threadQueue.remove();
				if(matrixPair==null) {
					System.out.println("No more matrix to multiply");
					break;
				}
				int[][] result=multiplyMatrix(matrixPair.matrix1, matrixPair.matrix2);
				saveMatrixtofile(fileWriter,result);
			}
			try {
				
				fileWriter.flush();
				fileWriter.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		private int[][] multiplyMatrix(int[][] m1,int[][] m2){
		int [][]result=new int[N][N];
		
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				for(int k=0;k<N;k++) {
					result[r][c]=m1[r][k]*m2[k][c];
				}
				
			}
		}
		return result;
			
		
	}
	}
	
	
	
	
	private static class MatrixReaderProducer extends Thread{
		
		private Scanner scanner;
		private ThreadQueue threadQueue;
		
		public MatrixReaderProducer(FileReader reader, ThreadQueue queue) {
			this.scanner=new Scanner(reader);
			this.threadQueue=queue;
		}
		
		@Override
		public void run() {
			while(true) {
				int [][] m1=readMatrix();
				int [][] m2=readMatrix();
				if(m1==null || m2==null) {
					threadQueue.terminate();
					System.out.println("No more matrix to read. Producer thread is terminating");
					return;
					
				}
				MatrixPair matrixPair=new MatrixPair();
				matrixPair.matrix1=m1;
				matrixPair.matrix2=m2;
				threadQueue.add(matrixPair);
			}
		}
		
		private int [][] readMatrix(){
			int [][] matrix=new int[N][N];
			for(int r=0;r<N;r++) {
				if(!scanner.hasNext()) {
					return null;
				}
				String[] line=scanner.nextLine().split(",");
				for(int c=0;c<N;c++) {
					matrix[r][c]=Integer.valueOf(line[c]);
					}
				
			}
			scanner.nextLine();
			return matrix;
		}
		
	}
	public static class ThreadQueue{
		
		private Queue<MatrixPair> queue=new LinkedList<>();
		private boolean isEmpty=true;
		private boolean isTerminate=false;
		
		public synchronized void add(MatrixPair matrixPair) {
			queue.add(matrixPair);
			isEmpty=false;
			notify();
		}
		public synchronized MatrixPair remove() {
			while(isEmpty && !isTerminate) {
				try {
					wait();
				}catch(InterruptedException ex) {
						ex.printStackTrace();
				}
				
			}
			if(queue.size()==1) {
				isEmpty=true;
				
			}
			if(queue.size()==0 && isTerminate) {
				return null;
			}
			System.out.println("current queue size is "+queue.size());
			return queue.remove();
			
		}
		public synchronized void terminate() {
			isTerminate=true;
			notifyAll();
		}
		
		
	}
	
	private  static class MatrixPair{
		public int [][]matrix1;
		public int [][]matrix2;
		
	}
	
	
}
