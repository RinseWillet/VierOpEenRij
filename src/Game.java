	import java.util.Scanner;
	
	// to do:
	// random bepalen welke speler begint
	// maximaal 6 per kolom detecteren - anders geen extra steen
	// en dan opnieuw kiezen zonder te wisselen van speler
	// horizontale vier op rij
	//verticale vier op rij
	// diagonale vier op rij

	public class Game {

		public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			
			char[][] grid = new char[6][7];    // dit is een multidimensionaal grid voor het speelveld, zes rijen hoog en zeven kolommen breed
			
			//deze loop vult de kollommen van het grid-array met lege plekken, per rij. 
			for (int row = 0; row < grid.length; row++){
				for (int col = 0; col < grid[0].length; col++){
					grid[row][col] = ' ';
				}
			}
			
			
			// eerste beurt, speler 1 (rood) begint
			int turn = 1;
			char player = 'R';
			boolean winner = false;		
			
			//beurt spelen
			while (winner == false && turn <= 42){
				boolean validPlay;
				int play;
				do {
					display(grid);
					
					System.out.print("Player " + player + ", choose a column: ");
					play = in.nextInt();
					
					//validate play
					validPlay = validate(play,grid);
					
				}while (validPlay == false);
				
				//drop the checker
				for (int row = grid.length-1; row >= 0; row--){
					if(grid[row][play] == ' '){
						grid[row][play] = player;
						break;
					}
				}
				
				//is er een winnaar?
				winner = isWinner(player,grid);
				
				//van spelers wisselen
				if (player == 'R'){
					player = 'G';
				}else{
					player = 'R';
				}
				
				turn++;			
			}
			display(grid);
			
			if (winner){
				if (player=='R'){
					System.out.println("Geel heeft gewonnen");
				}else{
					System.out.println("Rood heeft gewonnen");
				}
			}else{
				System.out.println("Gelijk spel");
			}
			
		}
		
		
		
		public static void display(char[][] grid){
			System.out.println(" a b c d e f g");
			System.out.println("---------------");
			for (int row = 0; row < grid.length; row++){
				System.out.print("|");
				for (int col = 0; col < grid[0].length; col++){
					System.out.print(grid[row][col]);
					System.out.print("|");
				}
				System.out.println();
				System.out.println("---------------");
			}
			System.out.println(" a b c d e f g");
			System.out.println();
		}
		
		public static boolean validate(int column, char[][] grid){
			//valid column?
			if (column < 0 || column > grid[0].length){
				return false;
			}
			
			//full column?
			if (grid[0][column] != ' '){
				return false;
			}
			
			return true;
		}
		
		// methode die checkt of er een vier op een rij is
		public static boolean isWinner(char player, char[][] grid){
			//checkt voor vier op een rij horizontaal
			for(int row = 0; row<grid.length; row++){
				for (int col = 0;col < grid[0].length - 3;col++){
					if (grid[row][col] == player   && 
						grid[row][col+1] == player &&
						grid[row][col+2] == player &&
						grid[row][col+3] == player){
						return true;
					}
				}			
			}
			//Checken of er 4 op een rij zijn verticaal
			for(int row = 0; row < grid.length - 3; row++){
				for(int col = 0; col < grid[0].length; col++){
					if (grid[row][col] == player   && 
						grid[row+1][col] == player &&
						grid[row+2][col] == player &&
						grid[row+3][col] == player){
						return true;
					}
				}
			}
			//checken of er een diagonale naar boven gaande rij is
			for(int row = 3; row < grid.length; row++){
				for(int col = 0; col < grid[0].length - 3; col++){
					if (grid[row][col] == player   && 
						grid[row-1][col+1] == player &&
						grid[row-2][col+2] == player &&
						grid[row-3][col+3] == player){
						return true;
					}
				}
			}
			//checken of er een diagonale naar beneden gaande rij is
			for(int row = 0; row < grid.length - 3; row++){
				for(int col = 0; col < grid[0].length - 3; col++){
					if (grid[row][col] == player   && 
						grid[row+1][col+1] == player &&
						grid[row+2][col+2] == player &&
						grid[row+3][col+3] == player){
						return true;
					}
				}
			}
			return false;
		}
	}

