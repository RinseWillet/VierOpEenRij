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
		GameMethods game = new GameMethods();
		game.SetupGrid();

		// eerste beurt, speler 1 (rood) begint
		int turn = 1;
		char player = 'R';
		boolean winner = false;

		// beurt spelen
		while (winner == false && turn <= 42) {
			boolean validPlay;
			int play;
			do {
				game.display(game.speelveld);
				System.out.print("Speler " + player + ", kies een kolom (a-g): ");
				String input = in.next();
				if(!game.onlyLettersAF(input)) {
				System.out.println("wrong input");
				} 
				play = game.InputToInteger(input);
								
				// is spelzet correct
				validPlay = game.validate(play, game.speelveld);

			} while (validPlay == false);

			//
			for (int row = game.speelveld.length - 1; row >= 0; row--) {
				if (game.speelveld[row][play] == ' ') {
					game.speelveld[row][play] = player;
					break;
				}
			}

			// is er een winnaar?
			winner = game.isWinner(player, game.speelveld);

			// van spelers wisselen
			if (player == 'R') {
				player = 'G';
			} else {
				player = 'R';
			}

			turn++;
		}
		game.display(game.speelveld);

		if (winner) {
			if (player == 'R') {
				System.out.println("Geel heeft gewonnen");
			} else {
				System.out.println("Rood heeft gewonnen");
			}
		} else {
			System.out.println("Gelijk spel");
		}

	}

}
