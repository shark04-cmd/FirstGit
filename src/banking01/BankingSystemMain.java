package banking01;
import java.util.InputMismatchException;
import java.util.Scanner;
public class BankingSystemMain implements ICustomDefine{
public static Scanner scan=new Scanner(System.in);
public static void menuShow(){
System.out.println("====== 메뉴 ======");
System.out.println(" 1. 계좌개설");
System.out.println(" 2. 입 금");
System.out.println(" 3. 출 금");
System.out.println(" 4. 계좌정보출력");
System.out.println(" 5. 프로그램 종료");
System.out.print(" 번호를 선택하세요 :");
}
public static void main(String[] args){
AccountManager handler=new AccountManager(50);
while(true){
try{
menuShow();
int choice=scan.nextInt();
scan.nextLine();
if(choice<1||choice>5)
throw new MenuSelectException("메뉴는 1~5 사이만 선택 가능합니다.");
switch(choice){
case MAKE:
System.out.print("1. 보통계좌  2. 신용계좌 ▶ ");
int accType=scan.nextInt();
scan.nextLine();
handler.makeAccount(accType);
break;
case DEPOSIT:
handler.depositMoney();
break;
case WITHDRAW:
handler.withdrawMoney();
break;
case INQUIRE:
handler.showAccInfo();
break;
case EXIT:
System.out.println("프로그램 종료");
return;
}
}catch(MenuSelectException e){
System.out.println(e.getMessage());
}catch(InputMismatchException e){
System.out.println("숫자만 입력하세요.");
scan.nextLine();
}
}
}
}
