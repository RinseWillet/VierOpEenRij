
public class GameMethods {

	char[][] speelveld = new char[6][7]; // dit is een multidimensionaal speelveld voor het speelveld, zes rijen hoog en
										 // zeven kolommen breed

	public void SetupGrid() {

		this.speelveld = speelveld;

		// deze loop vult de kollommen van het speelveld-array met lege plekken, per
		// rij.
		for (int row = 0; row < speelveld.length; row++) {
			for (int col = 0; col < speelveld[0].length; col++) {
				speelveld[row][col] = ' ';
			}
		}
	}
	
	

	public void display(char[][] speelveld) {
		// deze methode laat het speelveld zien

		System.out.println(" a b c d e f g");
		System.out.println("---------------");
		for (int row = 0; row < speelveld.length; row++) { // als int row kleiner is dan speelveld-lengte (rijen - 6),
															// dan wordt er een recht streepje geprint
			System.out.print("|");
			for (int col = 0; col < speelveld[0].length; col++) { // als int col kleiner is dan de speelveld-lengte
																	// (kolommen - 7) dan wordt er een het element op
																	// speelveld [rij][kolom] geprint en een recht
																	// streepje
				System.out.print(speelveld[row][col]);
				System.out.print("|");
			}
			System.out.print(6 - row); // print rijnummer aan de rechterzijde
			System.out.println();
			System.out.println("---------------");
		}
		System.out.println();
	}
	
	

	public boolean validate(int column, char[][] speelveld) {
		// methode checked of de input van de speler ook daadwerkelijk kan

		// is dit een valide kolom (niet kleiner dan 0 of groter dan het aantal
		// kolommen?)
		if (column < 0 || column > speelveld[0].length) {
			return false;
		}

		// is de kolom vol (geen ' ' lege plekken meer?)
		if (speelveld[0][column] != ' ') {
			return false;
		}

		return true;
	}
	
	

	//method om the checken of enkel a-g ingevoerd zijn.
	boolean onlyLettersAF (String input) {
		String omzet = input.toLowerCase();	
		if (omzet.length() >1) {
			return false;
		}
		char[] check = new char[4];
		check = omzet.toCharArray();
		boolean contains = true;
		for (char c : check) {
		    if (!(c == 'a' || c == 'b' || c == 'c' || c == 'd' || c == 'e' || c == 'f' || c == 'g')) {
		        contains = false;
		        }
		}
		return contains;
		}
	
	
	
	// input omzetten naar integer;	
	public int InputToInteger(String input) {
		String omzet = input.toLowerCase();		
		int returnCol = 7;
					
		switch (omzet) {
		case "a": {
			returnCol = 0;
			break;
		}
		case "b": {
			returnCol = 1;
			break;
		}
		case "c": {
			returnCol = 2;
			break;
		}
		case "d": {
			returnCol = 3;
			break;
		}
		case "e": {
			returnCol = 4;
			break;
		}
		case "f": {
			returnCol = 5;
			break;
		}
		case "g": {
			returnCol = 6;
			break;
		}
		}
		return returnCol;
		} 
		

	// methode die checkt of er een vier op een rij is
		public boolean isWinner(char player, char[][] speelveld) {
		
		// checkt voor vier op een rij horizontaal //alle checkfuncties 'scannen' van
		// links naar rechts
		
		for (int row = 0; row < speelveld.length; row++) {
			
/* eerste for loop cycled per kolom (tot max aantal kolommen (7) - 3
* anders kun je nooit 4 op een rij krijgen).
* tweede for loop cycled per rij naar kolom.
*/
			for (int col = 0; col < speelveld[0].length - 3; col++) { 
				

				if (speelveld[row][col] == player &&
						speelveld[row][col + 1] == player &&
						speelveld[row][col + 2] == player &&
						speelveld[row][col + 3] == player) { // deze functie checkt het character in een rij en
															//  kolom in dezelfde rij in de 3 kolommen rechts
															// hetzelfde karakter heeft
					return true;
				}
			}
		}
		
		// Checken of er 4 op een rij zijn verticaal
		for (int row = 0; row < speelveld.length - 3; row++) {
			
/*eerste for loop cycled per rij (tot max aantal rijen (6) -3, anders
* nooit 4 op een rij) naar kolom
* tweede for loop cycled per kolom 
*/
			
			for (int col = 0; col < speelveld[0].length; col++) { // cycled per kolom
				if (speelveld[row][col] == player &&
						speelveld[row + 1][col] == player &&
						speelveld[row + 2][col] == player &&
						speelveld[row + 3][col] == player) { // 
					return true;
				}
/*deze functie checkt of het karakter in een rij en
* kolom in dezelfde kolom drie rijen erboven hetzelfde
* karakter heeft
*/
			}
		}
		
		// checken of er een diagonale naar boven gaande rij is
		for (int row = 3; row < speelveld.length; row++) { 
			for (int col = 0; col < speelveld[0].length - 3; col++) {
				
/* eerste for loop cycled per rij naar kolom
 * tweede for loop cycled per kolom (tot max koloms (7) - 4, anders nooit 4 op een rij)
 */
				
				if (speelveld[row][col] == player &&
						speelveld[row - 1][col + 1] == player &&
						speelveld[row - 2][col + 2] == player &&
						speelveld[row - 3][col + 3] == player) {
						return true;
				}
/* deze functie checkt of het karakter in een rij
 * en kolom hetzelfde karakter heeft iedere maal
 * 1 rij stapje naar beneden en 1 kolom stapje naar
 * rechts
 */
			}
		}
		
		// checken of er een diagonale naar beneden gaande rij is
		for (int row = 0; row < speelveld.length - 3; row++) {
			
/* eerste for loop cycled per rij (tot max aantal rijen -3 anders nooit 4 op rij) naar kolom
 * tweede for loop cycled per kolom (tot max aantal koloms -3 anders nooit 4 op rij)
 */
			for (int col = 0; col < speelveld[0].length - 3; col++) { // 
				if (speelveld[row][col] == player &&
						speelveld[row + 1][col + 1] == player &&
						speelveld[row + 2][col + 2] == player &&
						speelveld[row + 3][col + 3] == player) {
					return true;
				}
/* deze functie checkt of het karakter in een rij en kolom hetzelfde karakter heeft
 * iedere maal 1 rij stapje naar boven en 1 kolom stapje naar rechts
 */
					
			}
		}
		return false;
	}
}

