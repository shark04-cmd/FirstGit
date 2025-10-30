package banking01;
public class Account{
protected String ANum;
protected String name;
protected long BNum;
public Account(String ANum,String name,long BNum){
this.ANum=ANum;
this.name=name;
this.BNum=BNum;
}
public void deposit(long amount){
BNum+=amount;
}
public void withdraw(long amount){
if(amount<=0){
System.out.println("출금 금액은 0보다 커야 합니다.");
return;
}
if(BNum<amount){
System.out.println("잔액이 부족합니다.");
return;
}
BNum-=amount;
System.out.println(amount+"원이 출금되었습니다. 현재 잔액: "+BNum+"원");
}
public void showAccInfo(){
System.out.println("----------------------------");
System.out.println("계좌번호: "+ANum);
System.out.println("고객이름: "+name);
System.out.println("잔고: "+BNum+"원");
System.out.println("----------------------------");
}
public String getAccountNum(){return ANum;}
}
