package banking2;


public class HighCreditAccount extends Account implements ICustomDefine{
	String CREDIT; // 신용등급 A , B , C 로 나뉘여져있음
	
	int interest_rate; // 이자율
	int credit_interest_rate = 0; // 신용 등급에 따른 이자율
	
//	public 접근 제어자 (어디서든 이 생성자를 쓸 수 있음) NormalAccount (클래스 이름) 
//	String ㅁㅁ (객체를 만들 때 전받을 초기값)
//	요약] public( 어디서든 쓸수있다.) NormalAccount (노말 어카운트에 있는) (String ㅁㅁ) (생성자를 )
	public HighCreditAccount(String account_number, String name, int balance, 
			int interest_rate, String credit_interest_rate) {
		super(account_number, name, balance);
		this.interest_rate = interest_rate;
		this.CREDIT = credit_interest_rate;
	}
	
	
	public void deposit(int money) {
		
//		입력된 문자가 "A" 랑 같으면 ICustomDefine 여기에서 A값을 받아옴 ("A" == 7 )
		if (CREDIT.equals("A")) 
			credit_interest_rate = ICustomDefine.CREDIT.A;
//		입력된 문자가 "B" 랑 같으면 ICustomDefine 여기에서 A값을 받아옴 ("B" == 4 )
		else if (CREDIT.equals("B")) 
			credit_interest_rate = ICustomDefine.CREDIT.B;
//		입력된 문자가 "C" 랑 같으면 ICustomDefine 여기에서 A값을 받아옴 ("C" == 2 )
		else if (CREDIT.equals("C")) 
			credit_interest_rate = ICustomDefine.CREDIT.C;
		
//		입금 전 잔액 + ((입금전 잔액 * 이자%) + (입금전 잔액 * 신용등급 이자%) + 입금 금액)
		balance += ((balance * interest_rate / 100) + 
			(balance * credit_interest_rate / 100) + money);
	}
	
	public void withdraw(int money) {
		balance -= money;
	}
	
	@Override
		public void showAccInfo() {
		System.out.println("---------------------------");
		System.out.println(" 신용 신뢰 계좌 ");
		super.showAccInfo();
		System.out.println(" 이자율 : "+ interest_rate + "%");
		System.out.println(" 신용 등급 : "+ CREDIT);
		System.out.println();
	}
}
/*
신용 신뢰 계좌

Account 의 자식클래스로 신용도가 높은 고객에게 개설이 허용되며 높은 이율의 계좌이다.
생성자를 통해서 이율정보(이자비율의정보)를 초기화 할수있도록 정의한다.

계좌번호(String형), 이름(String형), 잔액(int형)


신용계좌 : 잔고 + (잔고 * 기본이자) + (잔고 * 추가이자) + 입금액
*/