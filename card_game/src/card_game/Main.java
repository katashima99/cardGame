package card_game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Card card = new Card(0, 0);
		Deck deck = new Deck();
		deck.shuffle();

		Scanner scanner = new Scanner(System.in);
		// 処理を選ばせる
		System.out.println("実行する処理を選んでください。");
		System.out.println("1:山札からドローする　2：カードの強さを比較する 3:カードを5枚引いて一番強いカードを表示する");
		int select = scanner.nextInt();

		switch (select) {

		case 1: // 54枚ドローする
			for (int x = 0; x < 55; x++) {
				try {
					card = deck.draw();
					System.out.println(card.getMark() + card.getNum());
				} catch (NullPointerException e) {
					System.out.println("山札がありません");
				}
			}
			break;

		case 2: // カードの強さを比較する
			Card card1 = deck.draw();
			Card card2 = deck.draw();
			System.out.println("1枚目" + card1.getMark() + card1.getNum());
			System.out.println("2枚目" + card2.getMark() + card2.getNum());

			System.out.println("-----------------------");
			int compare = card1.compareTo(card2);

			if (compare > 0) {
				System.out.println("1枚目" + card1.getMark() + card1.getNum() + "の勝ちです。");
			} else if (compare < 0) {
				System.out.println("2枚目" + card2.getMark() + card2.getNum() + "の勝ちです。");
			} else {
				System.out.println("引き分けです。");
			}
			break;

		case 3: // カードを5枚引いて、一番強いカードを取得
			System.out.println("5枚ドロー!");
			// 手札リスト
			List<Card> hands = new ArrayList<Card>();
			// カードを1枚引く
			card = deck.draw();
			System.out.println(card.getMark() + card.getNum());
			hands.add(card);
			Card maxCard = hands.get(0);
			// カードを4枚引く
			for (int i = 1; i < 5; i++) {
				card = deck.draw();
				System.out.println(card.getMark() + card.getNum());
				hands.add(card); // listに持たせる
				// 強いカードを比較
				compare = maxCard.compareTo(hands.get(i));
				if (compare <= 0) {
					maxCard = hands.get(i);
				}
			}
			System.out.println("---------------------");
			System.out.println("一番強いカードは" + maxCard.getMark() + maxCard.getNum() + "です");
			// カードを戻して、引く
			deck.put(maxCard);
			card = deck.draw();
			System.out.println("カードを戻して、もう一度引く");
			System.out.println(card.getMark() + card.getNum());
			break;

		default:
			System.out.println("無効な番号です。");
			break;

		}
	}
}
