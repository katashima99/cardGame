package card_game;

import java.util.ArrayList;
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
		System.out.println("1:山札からドローする　"
						+ "2：カードの強さを比較する "
						+ "3:カードを5枚引いて一番強いカードを表示する"
						+ " 4:ペアを作る");
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
			int compare = card1.fight(card2);

			if (compare > 0) {
				System.out.println("1枚目" + card1.getMark() + card1.getNum() + "の勝ちです。");
			} else {
				System.out.println("2枚目" + card2.getMark() + card2.getNum() + "の勝ちです。");
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
				compare = maxCard.fight(hands.get(i));
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
			
		case 4: //ペアを取得するゲーム
			//5枚カードを所持したプレーヤー
			Player p = new Player(deck,5);
			//ワンペアメソッド
			int pair = p.isOnePair();
			//ツーペアメソッド
			p.isTwoPair(pair);
			//ペアのプリント文
			judg(p,pair);
			
			//カードチェンジする番号を入力
			System.out.println("-----------------------");
			System.out.print("交換する手札番号をを入力してください[1-5]：");
			int cardIndex = scanner.nextInt();
			System.out.println("-----------------------");
			System.out.println("変更する手札");
			//カードチェンジメソッド
			p.changeCard(cardIndex, deck);
			System.out.println("-----------------------");
			System.out.println("変更後の手札");
			for(int a = 0; a<p.hand.size(); a++) {
				System.out.print(p.hand.get(a).getMark() + p.hand.get(a).getNum() + " ");				
			}
			
			//ワンペアメソッド
			pair = p.isOnePair();
			//ツーペアメソッド
			p.isTwoPair(pair);
			//ペアのプリント文
			judg(p,pair);
			break;
		default:
			System.out.println("無効な番号です。");
			break;
		}
	}
	
	//ペアのプリント文
	public static void judg(Player p, int pair) {
		if(pair == 1) {
			System.out.println(": ワンペアです");		
		}else if(p.isTwoPair(pair) == true) {
			System.out.println(": ツーペアです");				
		}else {
			System.out.println(": ノーペアです");				
		}
	}
}
