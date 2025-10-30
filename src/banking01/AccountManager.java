package banking01;

import java.util.Scanner;
	
	public class AccountManager implements ICustomDefine{
		
		private Account[] accounts;
		
		private int numOfAccounts;
public AccountManager(int num){
accounts=new Account[num];
numOfAccounts=0;
}
public void makeAccount(int choice){
Scanner sc=BankingSystemMain.scan;
System.out.print("계좌번호: ");
String ANum=sc.nextLine();
System.out.print("고객이름: ");
String name=sc.nextLine();
System.out.print("잔고: ");
long BNum=Long.parseLong(sc.nextLine());
System.out.print("기본이자율(%) 입력: ");
double interestRate=sc.nextDouble()/100;
sc.nextLine();
if(choice==1){
accounts[numOfAccounts++]=new NormalAccount(ANum,name,BNum,interestRate);
}else if(choice==2){
System.out.print("신용등급 입력 (A,B,C): ");
String grade=sc.nextLine().toUpperCase();
accounts[numOfAccounts++]=new Account(ANum,name,BNum);
}
System.out.println("## 계좌 개설 완료 ##\n");
}
public void depositMoney(){
Scanner sc=BankingSystemMain.scan;
System.out.print("입금할 계좌번호: ");
String num=sc.nextLine();
for(int i=0;i<numOfAccounts;i++){
if(accounts[i].getAccountNum().equals(num)){
System.out.print("입금액: ");
long amount=Long.parseLong(sc.nextLine());
if(amount<=0){
System.out.println("0원 이하는 입금할 수 없습니다.");
return;
}
accounts[i].deposit(amount);
System.out.println("입금 완료! 현재 잔고: "+accounts[i].BNum+"원");
return;
}
}
System.out.println("해당 계좌를 찾을 수 없습니다.");
}
public void withdrawMoney(){
Scanner sc=BankingSystemMain.scan;
System.out.print("출금할 계좌번호: ");
String num=sc.nextLine();
for(int i=0;i<numOfAccounts;i++){
if(accounts[i].getAccountNum().equals(num)){
System.out.print("출금액: ");
long amount=Long.parseLong(sc.nextLine());
accounts[i].withdraw(amount);
return;
}
}
System.out.println("해당 계좌를 찾을 수 없습니다.");
}
public void showAccInfo(){
for(int i=0;i<numOfAccounts;i++){
accounts[i].showAccInfo();
}
}
}
