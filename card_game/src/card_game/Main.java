package card_game;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Card card = new Card(0, 0);
		Deck deck = new Deck();
		deck.shuffle();

		Scanner scanner = new Scanner(System.in);
		// 処理を選ばせる
		System.out.println("実行する処理を選んでください。");
		System.out.println("1:山札からドローする　2：カードの強さを比較する");
		int select = scanner.nextInt();

		if (select == 1) {
			// 54枚ドローする
			for (int x = 0; x < 55; x++) {
				try {
					card = deck.draw();
					System.out.println(card.getMark() + card.getNum());
				} catch (NullPointerException e) {
					System.out.println("山札がありません");
				}
			}

		} else if (select == 2) {
			// カードの強さを比較する
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

		}

	}

}
