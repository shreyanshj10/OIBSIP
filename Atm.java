import java.util.Scanner;
class Bank
{
    String name;
    String userName;
    String password;
    String accountNo;
    float balance = 0.0f;
    int transactions = 0;
    String transactionHistory = "";
    
    public void registeraccount()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Your Name: ");
        this.name = sc.nextLine();
        System.out.print("\nEnter Your Username: ");
        this.userName = sc.nextLine();
        System.out.print("\nEnter Your Password: ");
        this.password = sc.nextLine();
        System.out.print("\nEnter Your Account Number: ");
        this.accountNo = sc.nextLine();
        System.out.println("\nRegistration completed..kindly login");
    }
    public boolean loginaccount()
    {
        boolean isLogin = false;
        Scanner sc = new Scanner(System.in);
        while ( !isLogin )
        {
            System.out.print("\nEnter Your Username - ");
            String Username = sc.nextLine();
            if ( Username.equals(userName) )
            {
                while ( !isLogin ) {
                    System.out.print("\nEnter Your Password - ");
                    String Password = sc.nextLine();
                    if ( Password.equals(password) )
                    {
                        System.out.print("\nLogin successful!!");
                        isLogin = true;
                    }
                    else
                    {
                        System.out.println("\nIncorrect Password!!");
                    }
                }
            }
            else
            {
                System.out.println("\nUsername not found!!");
            }
        }
        return isLogin;
    }
    public void withdrawmoney()
    {
        System.out.print("\nEnter amount to withdraw: ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try
        {
            if ( balance >= amount )
            {
                transactions++;
                balance -= amount;
                System.out.println("\nWithdraw Successfully");
                String str = amount + " Rs Withdrawed\n";
                transactionHistory = transactionHistory.concat(str);
            }
            else
            {
                System.out.println("\nInsufficient Balance");
            }
        }
        catch ( Exception e)
        {
        }
    }
    public void depositmoney()
    {
        System.out.print("\nEnter amount to deposit:");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try
        {
            if ( amount <= 100000f )
            {
                transactions++;
                balance += amount;
                System.out.println("\nSuccessfully Deposited");
                String str = amount + " Rs deposited\n";
                transactionHistory = transactionHistory.concat(str);
            }
            else {
                System.out.println("\nSorry...Limit is 100000.00");
            }
        }
        catch ( Exception e)
        {
        }
    }
    public void transfermoney()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Receipent's Name: ");
        String receipent = sc.nextLine();
        System.out.print("\nEnter amount to transfer:");
        float amount = sc.nextFloat();
        try
        {
            if ( balance >= amount )
            {
                if ( amount <= 60000f )
                {
                    transactions++;
                    balance -= amount;
                    System.out.println("\nSuccessfully Transfered money to " + receipent);
                    String str = amount + " Rs transfered to " + receipent + "\n";
                    transactionHistory = transactionHistory.concat(str);
                }
                else
                {
                    System.out.println("\nSorry...Limit is 60000.00");
                }
            }
            else
            {
                System.out.println("\nInsufficient Balance!!");
            }
        }
        catch ( Exception e)
        {
        }
    }
    public void checkBalance()
    {
        System.out.println("\n" + balance + " Rs");
    }
    public void transHistory()
    {
        if ( transactions == 0 )
        {
            System.out.println("\nEmpty");
        }
        else
        {
            System.out.println("\n" + transactionHistory);
        }
    }
}
public class Atm
{
    public static int takeIntegerInput(int limit)
    {
        int input = 0;
        boolean flag = false;
        while ( !flag )
        {
            try
            {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;
                if ( flag && input > limit || input < 1 )
                {
                    System.out.println("Choose the number between 1 to " + limit);
                    flag = false;
                }
            }
            catch ( Exception e )
            {
                System.out.println("Enter only integer value");
                flag = false;
            }
        };
        return input;
    }
    public static void main(String[] args)
    {
        System.out.println("\n**********WELCOME TO SBI ATM SYSTEM**********\n");
        System.out.println("1.Register \n2.Exit");
        System.out.print("Enter Your Choice 1 or 2: ");
        int choice = takeIntegerInput(2);
        if ( choice == 1 )
        {
            Bank b = new Bank();
            b.registeraccount();
            while(true)
            {
                System.out.println("\n1.Login \n2.Exit");
                System.out.print("Enter Your Choice 1 or 2: ");
                int ch = takeIntegerInput(2);
                if ( ch == 1 )
                {
                    if (b.loginaccount())
                    {
                        System.out.println("\n\n**********WELCOME BACK " + b.name + " **********\n");
                        boolean Finished = false;
                        while (!Finished)
                        {
                            System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
                            System.out.print("\nEnter Your Choice: ");
                            int c = takeIntegerInput(6);
                            switch(c)
                            {
                                case 1:
                                    b.withdrawmoney();
                                    break;
                                case 2:
                                    b.depositmoney();
                                    break;
                                case 3:
                                    b.transfermoney();
                                    break;
                                case 4:
                                    b.checkBalance();
                                    break;
                                case 5:
                                    b.transHistory();
                                    break;
                                case 6:
                                    Finished = true;
                                    break;
                            }
                        }
                    }
                }
                else
                {
                    System.exit(0);
                }
            }
        }
        else
        {
            System.exit(0);
        }
    }
}