package banking2;

public class AccountManager{
	
	String account_number, name, credit_interest_rate; 
	int balance, interest_rate;
	
	private Account[] accounts;
	private int numOfAccounted;
	
	public AccountManager(int num) {
		accounts = new Account[num];
		numOfAccounted = 0 ;
		
	}
	public void makeAccount() {
		System.out.println(" ☆★☆계좌 선택☆★☆ ");
		System.out.println(" (1) 신용 신뢰 계좌 ");
		System.out.println(" (2) 보통 예금 계좌 ");
		System.out.print(" 선택해주세요! : ");
		int choice = BankingSystemMain.scan.nextInt();
		BankingSystemMain.scan.nextLine();
		
		System.out.println(" ☆★☆신규 계좌 개설☆★☆ ");
//		값을 입력받아 옴 그 값으로 무언가를 호출함
		
//		계좌번호 , 이름 , 계좌잔액을 호출한다.
		
//		1. 계좌 번호를 입력받는다.
		System.out.print(" 계좌 번호 : ");
//			계좌잔액에 입력받은(스캔) 값을 넣는다.
			account_number = BankingSystemMain.scan.nextLine();
			
//		2. 이름을 입력받는다.
		System.out.print(" 이름 : ");
//			이름에 입력받은(스캔) 값을 넣는다.
			name = BankingSystemMain.scan.nextLine();
			
//		3. 계좌 잔액을 입력받는다.
		System.out.print(" 계좌 잔액 : ");

//			계좌 잔액에 입력받은 값을 넣는다.
//			balance(계좌 잔액)은 계산이 필요하니 숫자형태로 바꿔준다.
			balance = BankingSystemMain.scan.nextInt();
			BankingSystemMain.scan.nextLine();
		
//		이자율을 입력받는다.
		System.out.print(" 이자율 : ");
			interest_rate = BankingSystemMain.scan.nextInt();
			BankingSystemMain.scan.nextLine();
			
		if(choice==1) {
			
		}
		
		else if (choice==2) {}
			if(choice==1) {
				System.out.println(" A, B, C 중에서 골라주세요! ");
				System.out.print(" 신용 등급 : ");
					credit_interest_rate = BankingSystemMain.scan.nextLine();
				
				HighCreditAccount high = 
					new HighCreditAccount(account_number, name, balance, interest_rate, credit_interest_rate);
				accounts[numOfAccounted++] = high;
				
			}
			
			else if(choice==2) {
				System.out.print("");
				accounts[numOfAccounted++] = new
				NormalAccount(account_number, name, balance, interest_rate);
			}
		
		
		System.out.println();
		System.out.println(" 계좌정보 입력이 완료되었습니다! ");
		System.out.println();
		System.out.println("=====================================");
	}

	public void depositMoney() { // 입금
		
		System.out.println(" 입금할 계좌를 선택해주세요! ");
		System.out.println(" 계좌번호와 입금할 금액을 입력해주세요! ");
		System.out.print(" 계좌번호 : ");
		String Accountsed = BankingSystemMain.scan.nextLine();
		System.out.print(" 입금할 금액 : ");
		int money = BankingSystemMain.scan.nextInt();
		BankingSystemMain.scan.nextLine();
		
//		신용계좌에서 0부터 1씩 늘어나면서 같은걸 찾음
		for(int i = 0; i < numOfAccounted ; i++) {
//			신용계좌에서 계좌번호가 같은 것을 찾음
			if(accounts[i].account_number.equals(Accountsed)) { 
				accounts[i].deposit(money);
				System.out.println();
				System.out.println(" 입금이 완료되었습니다! ");
				System.out.println();
				System.out.println(" 입금하신 계좌의 현제 금액은 : " + accounts[i].balance + "원 입니다.");
				System.out.println("=====================================");
				return;
			}
		}
		System.out.println();
		System.out.println(" 동일한 계좌가 없습니다. ");
		System.out.println();
		System.out.println("=====================================");
	}

	public void withdrawMoney() { // 출금
		
		System.out.println(" 출금할 계좌를 선택해주세요! ");
		System.out.println(" 계좌번호와 출금할 금액을 입력해주세요! ");
		System.out.print(" 계좌번호 : ");
		String accounted = BankingSystemMain.scan.nextLine();
		System.out.print(" 출금할 금액 : ");
		int money = BankingSystemMain.scan.nextInt();
		BankingSystemMain.scan.nextLine();
		
//		신용계좌에서 0부터 1씩 늘어나면서 같은걸 찾음
		for(int i = 0; i < numOfAccounted ; i++) {
//			신용계좌에서 계좌번호가 같은 것을 찾음
			if(accounts[i].account_number.equals(accounted)) { 
				accounts[i].withdraw(money);;
				
				System.out.println();
				System.out.println(" 출금이 완료되었습니다! ");
				System.out.println();
				System.out.println(" 출금하신 계좌의 현제 금액은 : " + accounts[i].balance + " 원 입니다.");
				System.out.println("=====================================");
				return;
			}
		}
		System.out.println();
		System.out.println(" 동일한 계좌가 없습니다. ");
		System.out.println();
		System.out.println("=====================================");
	}

	public void showAccInfo() { // 계좌 정보 출력
		
		System.out.println("☆★☆계좌정보가 출력되었습니다☆★☆");
		
		for(int i = 0 ; i < numOfAccounted ; i++) {
			accounts[i].showAccInfo();
		}
		System.out.println("=====================================");
	}
}								// 시마이
/*
컨트롤 클래스로 프로그램의 전반적인 기능을 구현한다.
*/