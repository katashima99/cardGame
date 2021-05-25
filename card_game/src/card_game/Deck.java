package card_game;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Deck {
	List<Card> cards = new ArrayList<Card>();

	// 54枚のカードを実体化する
	public Deck() {
		for (int i = 1; i < 5; i++) {
			for (int j = 1; j <= 13; j++) {
				Card card = new Card(i, j);
				cards.add(card);
			}
		}
		cards.add(Card.addJoker());
		cards.add(Card.addJoker());
	}

	// ランダムで持つようにする
	public void shuffle() {
		Collections.shuffle(cards);
	}

	// カードを引く
	public Card draw() {
		Card card = null;
		if (cards.size() > 0) {
			//山札から1枚引く
			int i = cards.size() - 1;
			//要素を取り出す
			card = cards.get(i);
			//要素を削除
			cards.remove(i);
		}
		return card;
	}
	
	//カードを置く
	public void put(Card card) {
		//54枚以下の時に
		if(cards.size() < 55) {
			//同じカードがないか判定
			if(!cards.contains(card)) {
				cards.add(card);							
			}
		}
	}

	
}
