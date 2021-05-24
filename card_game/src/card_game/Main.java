package card_game;

public class Main {

	public static void main(String[] args) {
		Card card = new Card(0, 0);
		Deck deck = new Deck();
		deck.shuffle();

		for (int x = 0; x < 55; x++) {
			try {
				card = deck.draw();
				System.out.println(card.getMark() + card.getNum());
			} catch (NullPointerException e) {
				System.out.println("山札がありません");
			}

		}
		System.out.println();
	}

}
