package card_game;


public class Card {

	// カードのマーク
	private int mark;
	// カードの番号
	private int num;
	//カードパワー
	private int power;

	// カード コンストラクタ
	public Card(int mark, int num) {
		this.mark = mark;
		this.num = num;
	}

	//getter
	public String getNum() {
		String str;
		switch (num) {
			case 11:
				str = "J";
				break;
			case 12:
				str = "Q";
				break;
			case 13:
				str = "K";
				break;
			case 1:
				str = "A";
				break;
			case 14:
				str = "(ジョーカー)";
				break;
			default:
				str = Integer.toString(num);
				break;
		}
		return str;
	}
	
	//getter
	public String getMark() {
		String str;
		switch (mark) {
			case 1:
				str = "♣";
				break;
			case 2:
				str = "♦";
				break;
			case 3:
				str = "♥";
				break;
			case 4:
				str = "♠";
				break;
			default:
				str = "joker";
				break;
		}
		return str;
	}
	
	//ジョーカー追加
	public static Card addJoker() {
		return new Card(5,14);
	}
	
	//カードを比較する
		public int compareTo(Card anotherCard) {
			if(this.num == anotherCard.num ) {
				return 0;
			} else if(this.num > anotherCard.num) {
				return 1;
			} else {
				return -1;
			}
		}
	
	//カードを比較する(パワーで比較)
	public int fight(Card anotherCard) {
		if(power() > anotherCard.power()) {
			return 1;
		} else {
			return -1;
		} 
	}
	
	//カードパワー
	public int power() {
		if(mark == 5 && num == 14) {
			power = 15;
		}else if (num == 1) {
			power = 14;
		}else {
			power = num;
		}
		power += power*10 + mark;
		return power;
	}

}
