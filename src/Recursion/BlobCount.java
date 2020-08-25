package Recursion;

public class BlobCount {
	private static int N=8;
	private static int [][] blob = {
			{1,0,0,0,0,0,0,1},
			{0,1,1,0,0,1,0,0},
			{1,1,0,0,1,0,1,0},
			{0,0,0,0,0,1,0,0},
			{0,1,0,1,0,1,0,0},
			{0,1,0,1,0,1,0,0},
			{1,0,0,0,1,0,0,1},
			{0,1,1,0,0,1,1,1}
	};
	
	@SuppressWarnings("unused")
	private static int BLANK_COLOR = 0;
	private static int IMAGE_COLOR = 1;
	private static int COUNTED_COLOR = 2;
	
	public static int blobCount(int x, int y) {
		if (x < 0 || y <0 || x>=N || y>=N) 
			return 0;
		else if(blob[x][y] != IMAGE_COLOR)
			return 0;
		else 
			blob[x][y] = COUNTED_COLOR;
			return 1+blobCount(x, y-1) +blobCount(x+1, y-1) +blobCount(x+1, y)+
					blobCount(x+1, y+1)+blobCount(x, y+1)+blobCount(x-1, y+1)+
					blobCount(x-1, y) +blobCount(x-1, y-1); 
		
	}
	
	public static void main(String[] args) {
		System.out.println(blobCount(5, 5));
		System.out.println();
		
		for (int i = 0; i < blob.length; i++) {
			for (int j = 0; j < blob.length; j++) {
				System.out.print(blob[i][j] + " ");
			}System.out.println();
		}		
	}
}
