package banking01;

import banking.NormalAccount;

public class HighCreditAccount extends NormalAccount implements ICustomDefine{
private double extraRate;
public HighCreditAccount(String ANum,String name,long BNum,double interestRate,String creditGrade){
super(ANum,name,BNum,interestRate);
switch(creditGrade.toUpperCase()){
case "A":this.extraRate=A;break;
case "B":this.extraRate=B;break;
case "C":this.extraRate=C;break;
default:this.extraRate=0;
}
}
@Override
public void deposit(long amount){
long interest=(long)(BNum*(getInterestRate()+extraRate));
BNum=BNum+interest+amount;
}
@Override
public void showAccInfo(){
System.out.println("----------------------------");
System.out.println("[신용신뢰계좌]");
System.out.println("계좌번호: "+ANum);
System.out.println("고객이름: "+name);
System.out.println("잔고: "+BNum+"원");
System.out.println("기본이자율+추가이자율: "+(getInterestRate()*100+extraRate*100)+"%");
System.out.println("----------------------------");
}
}
