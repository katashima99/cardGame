package card_game;

import java.util.ArrayList;
import java.util.List;

public class Player {

	List<Card> hand = new ArrayList<Card>();

	public Player(Deck deck, int cardSet) { // デッキをもたせて、引く枚数も指定する
		for (int x = 0; x < cardSet; x++) {
			deck.shuffle();
			hand.add(deck.draw());
			System.out.print(hand.get(x).getMark() + hand.get(x).getNum() + " ");
		}
	}

	// ワンペア
	public int isOnePair() {
		int pair = 1;
		int pairs = 0;
		// ペア比較 (バブルソート参照)
		for (int x = 0; x < hand.size() - 1; x++) {
			for (int y = hand.size() - 1; y > x; y--) {
				pair = hand.get(y).compareTo(hand.get(x));
				// ペアがあればカウントして、処理からぬける
				if (pair == 0) {
					pairs++;
					break;
				}
			}
		}
		// ペアの数を返す
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

	// カードチェンジ

	// プレーヤーはデッキから手札をドローできる
	// 手札から任意の番号を捨てる
	// デッキからドローする
	// ドローしたカードを手札に加える
	public void changeCard(int cardIndex, Deck deck) {
		if (cardIndex - 1 < hand.size()) {
			System.out.print(hand.get(cardIndex - 1).getMark() + hand.get(cardIndex - 1).getNum() + " ");
			hand.remove(cardIndex - 1); // あったカードを捨てる
			System.out.print(" → ");
			hand.add(cardIndex - 1, deck.draw());// 新しいカードを増やす
			System.out.println(hand.get(cardIndex - 1).getMark() + hand.get(cardIndex - 1).getNum() + " ");
		} else {
			System.out.println("無効な番号です。");
		}
	}
}
