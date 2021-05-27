package card_game;

import java.util.ArrayList;
import java.util.List;

public class Player {

	List<Card> hand = new ArrayList<Card>();
	Card cards = new Card(0, 0);

	public Player(Deck deck, int i) { // デッキをもたせて、引く枚数も指定する
		for (int x = 0; x < i; x++) {
			deck.shuffle();
			cards = deck.draw();
			System.out.println(cards.getMark() + cards.getNum());
			this.hand.add(cards);
		}
	}

	
}
