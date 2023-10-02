import java.util.*;
import java.util.Scanner;

class Atm_interface{
   Scanner sc1=new Scanner(System.in);
   private int balance;
   private String AccountHolder_name;
   public String Bank_name;
   public String Ifsc_code;
   private int Atm_pin;
   public String Atm_branch;

  //using constructor to assign values for private and public attributes
  Atm_interface(int xbalance,String xAccountHolder_name,String xBank_name,String xIfsc_code,int xAtm_pin, String xAtm_branch){
    balance=xbalance;
    AccountHolder_name=xAccountHolder_name;
    Bank_name=xBank_name;
    Ifsc_code=xIfsc_code;
    Atm_pin=xAtm_pin;
    Atm_branch=xAtm_branch;
    }

  //Displaying values of account for aurthorized persons
  public void display_values(){
    System.out.println("total balance:"+balance);
   System.out.println("Accountholder name:"+AccountHolder_name);
   System.out.println("Name of the Bank:"+Bank_name);
   System.out.println("Ifsc code:"+Ifsc_code);
   System.out.println("Atm Branch is:"+Atm_branch);
 }

 //For Depositing
  public void deposit(int deposit){
      balance+=deposit;
      System.out.println("Deposited amount:"+deposit);
      System.out.println("total balance after depositing:"+balance);
    }
    //For Withdrawing
  public void withdrawal(int withdrawal){
     if(balance>=withdrawal){
      balance-=withdrawal;
      System.out.println("Withdrawal amount:"+withdrawal);
      System.out.println("Total balance after withdrawal:"+balance);
     }else{
      System.out.println("INSUFFICIENT BALANCE!!!");
      System.out.println("Cannot able to withdraw,Remove your Atm card");
     }

    }

    //For Displaying values
  public void display_balance(int pin){
     if(Atm_pin==pin){
      System.out.println("Total balance in your account:"+balance);
    }else{
        System.out.println("Incorrect pin!!!");
        System.out.println("Enter correct pin for displaying balance");
    }

  }

 //For Changing old pin to new pin 
  public void change_pin(){
  int chance=0;
  while(chance<5) {
  System.out.println("Enter old Atm pin:");
  int old_pin=sc1.nextInt();
  if(Atm_pin==old_pin){
     System.out.println("Enter new Atm pin:");
     int New_pin=sc1.nextInt();
      Atm_pin=New_pin;
      System.out.println("Your Atm pin was updated to new pin");
      break;
    }
    else{
      System.out.println("Incorrect old Atm pin!!!");
      System.out.println("Enter correct Atm pin to update old pin");
    }
    chance+=1;
  }
  
}


    
}


class Main{
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("$$$ATM INTERFACE$$$");
    System.out.println("Account Opening:");
    //Inputting values from user to open account in a bank
    System.out.println("Enter balance in your account:");
    int balance=sc.nextInt();
    System.out.println("Enter AccountHolder name:");
    String AccountHolder=sc.next();
    System.out.println("Input Bank name:");
    String Bank_name=sc.next();
    System.out.println("Input Ifsc code of bank:");
    String Ifsc_code=sc.next();
    System.out.println("Enter your Atm pin:");
    int Atm_pin=sc.nextInt();
    System.out.println("Enter the Branch:");
    String Atm_branch=sc.next();


Atm_interface d1=new Atm_interface(balance,AccountHolder,Bank_name,Ifsc_code,Atm_pin,Atm_branch);//assigning values to constructor 
while(true){
System.out.println("1.Display Account details in Atm \n 2.Deposit \n 3.Withdrawal\n 4.Total balance \n 5.Change Atm pin \n6.EXIT");
System.out.println("Enter above operation number:");
int choice=sc.nextInt();
switch(choice){
    case 1:
         System.out.println("Displaying Account Details in Atm:");
        d1.display_values();
        break;
    case 2:
        System.out.println("Enter Deposit amount:");
        int deposit=sc.nextInt();
        d1.deposit(deposit);
        break;
    case 3:
        System. out. println("Enter Withdrawal amount:");
        int withdraw=sc.nextInt();
        d1.withdrawal(withdraw);
        break;
    case 4:
        System.out.println("Enter pin to check you or not:");
        int pin=sc.nextInt();
        d1.display_balance(pin);
        break;
    case 5:
         d1.change_pin();
         break;
    case 6:
         System.exit(0);

    default:
    System.out.println("Invalid option");
    break;
     }
}


  }
}