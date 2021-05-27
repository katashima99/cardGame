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

	// ワンペア
	public int isOnePair() {
		int pair = 1;
		int pairs = 0;
		//1枚目とペア比較
		for (int x = 1; x < 5; x++) {
			pair = hand.get(0).compareTo(hand.get(x));
			//ペアがあればカウントして、処理からぬける
			if(pair==0) {
				pairs++;
				break;
			}
		}
		//2枚目とペア比較
		for (int x = 2; x < 5; x++) {
			pair = hand.get(1).compareTo(hand.get(x));
			if(pair==0) {
				pairs++;
				break;
			}
		}
		//3枚目とペア比較
		for (int x = 3; x < 5; x++) {
			pair = hand.get(2).compareTo(hand.get(x));
			if(pair==0) {
				pairs++;
				break;
			}
		}
		//４枚目とペア比較
		for (int x = 4; x < 5; x++) {
			pair = hand.get(3).compareTo(hand.get(x));
			if(pair==0) {
				pairs++;
				break;
			}
		}
		//ペアの数を返す
		if (pairs == 1) {
			return 1;
		} else if (pairs == 0) {
			return 0;
		} else {
			return 2;
		}
	}

	// ツーペア
	public boolean isTwoPair(int isOnePair) {
		if (isOnePair == 2) {
			return true;
		} else {
			return false;
		}
	}

	
}
