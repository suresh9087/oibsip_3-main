import java.util.*;
public class ATM_Interface {    
    static int counter=0;
    static double balance;
    static String user_name;
    static long account_number;
    static String account_name;
    static double deposit_money;
    static double withdraw_money;
    static double transfer_money;
    static void display_balance(String name_user,String name_account,long number_account,double balance)
    {
        System.out.println("***************");
        System.out.println("BALANCE DETAILS");
        System.out.println("_______________");
        System.out.println("User Name : " + name_user);
        System.out.println("Account Holder Name : " + name_account);
        System.out.println("Account Number : " + number_account);
        System.out.println("ACCOUNT BALANCE : " + balance);
    }
    static void deposit_display(String name_user,String name_account,long number_account)
    {
        System.out.println("***********************");
        System.out.println("Welcome to DEPOSIT Menu");
        System.out.println("_______________________");
        System.out.println("User Name : " + name_user);
        System.out.println("Account Holder Name : " + name_account);
        System.out.println("Account Number : " + number_account);
    }
    static double deposit_final(double money_deposit,double balance_deposit)
    {
        balance_deposit=balance_deposit+money_deposit;
        return balance_deposit;
    }
    static void withdraw_display(String name_user,String name_account,long number_account)
    {
        System.out.println("***********************");
        System.out.println("Welcome to WITHDRAW Menu");
        System.out.println("_______________________");
        System.out.println("User Name : " + name_user);
        System.out.println("Account Holder Name : " + name_account);
        System.out.println("Account Number : " + number_account);
    }
    static double withdraw_final(double money_withdraw,double balance_withdraw)
    {
        balance_withdraw=balance_withdraw-money_withdraw;
        return balance_withdraw;
    }
    static void transfer_display(String name_user,String name_account,long number_account)
    {
        System.out.println("***********************");
        System.out.println("Welcome to TRANSFER Menu");
        System.out.println("_______________________");
        System.out.println("User Name : " + name_user);
        System.out.println("Account Holder Name : " + name_account);
        System.out.println("Account Number : " + number_account);
    }
    static double transfer_final(double money_transfer,double balance_transfer)
    {
        balance_transfer=balance_transfer-money_transfer;
        return balance_transfer;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int check=0;
        int pin=1234; //Initializing the PIN
        int enter_pin;
        String recipent_name;
        long recipent_account;
        long recipent_account_again;
        String recipent_ifsc;
        System.out.println("OASIS BANK WELCOMES YOU");
        System.out.println("Enter LOGIN CREDENTIALS to LOGIN = ");
        System.out.println("___________________________________");
        System.out.println("Enter User ID = ");
        user_name=sc.nextLine();
        System.out.println("Enter Account Holder Name = ");
        account_name=sc.nextLine();
        System.out.println("Enter Account Number = ");
        account_number=sc.nextLong();
        int i=0;
        while(i<3)
        {
            System.out.println("Enter PIN = ");
            enter_pin=sc.nextInt();
            if(pin!=enter_pin)
            {
                System.out.println("Wrong pin\n");
                if(i<=1)
                {
                    System.out.println("Please Try Again!!!");
                }
                System.out.println((i+1)+" Invalid attempt");
                System.out.println((3-(i+1))+" Attempts left\n");
                i++;
                continue;
            }
            else
            {
                System.out.println("LOGIN SUCCESSFULL");
                System.out.println("_________________");
                System.out.println("*****************");
                System.out.println("Enter Balance Amount = ");
                balance=sc.nextDouble();
                while(true)
                {
                    System.out.println("\nWELCOME to the OASIS BANK");
                    System.out.println("_________________________");
                    System.out.println("_________________________");
                    System.out.println("BANKING CREDIANTILS for this Session");
                    System.out.println("____________________________________");
                    System.out.println("User Name : " + user_name);
                    System.out.println("Account Holder Name : " + account_name);
                    System.out.println("Account Number : " + account_number);
                    while(true)
                    {               
                        System.out.println("******************");
                        System.out.println("*****ATM MENU*****");
                        System.out.println("******************");
                        System.out.println("Press '0' to check the Total Number of Transactions done till now in this Session");
                        System.out.println("Press '1' to check BALANCE");
                        System.out.println("Press '2' to DEPOSIT");
                        System.out.println("Press '3' to WITHDRAW.");
                        System.out.println("Press '4' to TRANSFER");
                        System.out.println("Press '5' to EXIT & LOG OUT");
                        int input;
                        System.out.println("ENTER your Choice to perform the respective BANKING Function = ");
                        input=sc.nextInt();
                        switch(input)
                        {
                            case 0:
                                if(counter==0)
                                {
                                    System.out.println("No Transactions History for this Session");
                                }
                                else
                                {
                                    System.out.println("Total Transactions found for this Session = "+counter);
                                }
                                break;
                            case 1:
                                display_balance(user_name,account_name,account_number,balance);
                                break;
                            case 2:
                                deposit_display(user_name,account_name,account_number);
                                System.out.println("Enter the Deposit Amount = ");
                                deposit_money=sc.nextDouble();
                                System.out.println("Press '1' to Confirm Deposit or Press '0' to Cancel Deposit");
                                check=sc.nextInt();
                                if(check==1)
                                {
                                    balance=deposit_final(deposit_money,balance);
                                    System.out.println("Deposit Successfull");
                                    counter++;
                                }
                                else if(check==0)
                                {
                                    System.out.println("Deposit Cancelled");
                                }
                                else
                                {
                                    System.out.println("Invalid Input!!!");
                                    System.out.println("Operation Cancelled");
                                    System.out.println("Try again later!!!");
                                }
                                break;
                            case 3:
                                withdraw_display(user_name,account_name,account_number);
                                System.out.println("Enter the Withdraw Amount = ");
                                withdraw_money=sc.nextDouble();
                                System.out.println("Press '1' to Confirm Withdraw or Press '0' to Cancel Withdraw");
                                check=sc.nextInt();
                                if(check==1)
                                {
                                    if(withdraw_money<=balance)
                                    {
                                        balance=withdraw_final(withdraw_money,balance);
                                        System.out.println("Withdraw Successfull");
                                        counter++;
                                    }
                                    else
                                    {
                                        System.out.println("Insufficient Balance to Withdraw");
                                    }
                                }
                                else if(check==0)
                                {
                                    System.out.println("Withdraw Cancelled");
                                }
                                else
                                {
                                    System.out.println("Invalid Input!!!");
                                    System.out.println("Operation Cancelled");
                                    System.out.println("Try again later!!!");
                                }
                                break;
                            case 4:
                                transfer_display(user_name,account_name,account_number);
                                sc.nextLine();
                                System.out.print("\nEnter the Recipent's NAME : ");
                                recipent_name=sc.nextLine();
                                System.out.print("\nEnter the Recipent BANK ACCOUNT NUMBER = ");
                                recipent_account=sc.nextLong();
                                System.out.print("\nEnter the Recipent's BANK ACCOUNT NUMBER again to CONFIRM = ");
                                recipent_account_again=sc.nextLong();
                                sc.nextLine();
                                System.out.print("\nEnter the Recipent BANK IFSC CODE = ");
                                recipent_ifsc=sc.nextLine();
                                System.out.println("Enter the Transfer Amount = ");
                                transfer_money=sc.nextDouble();
                                if(recipent_account==recipent_account_again)
                                {
                                    System.out.println("Press '1' to Confirm Transaction or Press '0' to Cancel Transaction");
                                    check=sc.nextInt();
                                    if(check==1)
                                    {
                                        if(transfer_money<=balance)
                                        {
                                            balance=transfer_final(transfer_money,balance);
                                            System.out.println("Money = " + transfer_money + " successfully transferred to :\nRECIPENT Details : ");
                                            System.out.println("Recipent NAME = "+recipent_name);
                                            System.out.println("Recipent BANK ACCOUNT NUMBER = "+recipent_account);
                                            System.out.println("Recipent BANK IFSC CODE = "+recipent_ifsc);
                                            counter++;
                                        }
                                        else if(check==0)
                                        {
                                            System.out.println("Insufficient Balance to Transfer");
                                        }
                                        else
                                        {
                                            System.out.println("Invalid Input!!!");
                                            System.out.println("Operation Cancelled");
                                            System.out.println("Try again later!!!");
                                        }
                                    }
                                    else
                                    {
                                        System.out.println("Transaction Cancelled");
                                    }
                                }
                                else
                                {
                                    System.out.println("Recipent's Account Number does not Matched\nPlease Check it & Try Again later...");
                                }
                                break;
                            case 5:
                                System.out.println("Press '1' to Confirm LOGOUT or Press '0' to Cancel LOGOUT");
                                check=sc.nextInt();
                                if(check==1)
                                {
                                    System.out.println("LOGGED OUT Successfull");
                                    System.out.println("THANK YOU FOR BANKING WITH US!!!\nSEE YOU AGAIN NEXT TIME");
                                    return;
                                }
                                else if(check==0)
                                {
                                    break;
                                }
                                else
                                {
                                    System.out.println("Invalid Input!!!");
                                    System.out.println("Operation Cancelled");
                                    System.out.println("Try again later!!!");
                                    break;
                                }
                            default:
                                System.out.println("Invalid Input!!!\nPlease Try again...");
                                break;
                        }
                    }  
                }
            }
        }
        if(i>=3)
        {
            System.out.println("No More Chances Left\nAccount has been Temporarily Blocked due to 3 Unsuccesfull Attempts");
            System.out.println("Please try again after sometime...");
        }
        sc.close();
    }
}
