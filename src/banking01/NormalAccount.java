package banking01;
public class NormalAccount extends Account{
private double interestRate;
public NormalAccount(String ANum,String name,long BNum,double interestRate){
super(ANum,name,BNum);
this.interestRate=interestRate;
}
@Override
public void deposit(long amount){
long interest=(long)(BNum*interestRate);
BNum=BNum+interest+amount;
}
@Override
public void showAccInfo(){
System.out.println("----------------------------");
System.out.println("[보통예금계좌]");
System.out.println("계좌번호: "+ANum);
System.out.println("고객이름: "+name);
System.out.println("잔고: "+BNum+"원");
System.out.println("기본이자율: "+(interestRate*100)+"%");
System.out.println("----------------------------");
}
public double getInterestRate(){return interestRate;}
}
