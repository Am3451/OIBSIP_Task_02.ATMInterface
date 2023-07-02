import java.util.Scanner;
 class AtmInterface{
	public static int takeIntegerInput(int limit){
		int input=0;
		boolean flag=false;
		while(!flag){
			try{
				Scanner sc= new Scanner(System.in);
				input = sc.nextInt();
				flag=true;

				if(flag && input > limit || input<1){
					System.out.println("Choose the number between 1 to "+limit);
					flag=false;
				}
			}
			catch(Exception e){
				System.out.println("Enter only Integer value");
				flag = false;
			}
		};
		return input;
   }

	public static void main(String[] args){
		System.out.print("\n ******** WELCOME TO BOI ATM SYSTEM ********\n");
		System.out.println("1. Register\n2. Exit");
		System.out.print("Enter yout choice: ");
		int choice= takeIntegerInput(20);
		
		if(choice==1){
			BankAccount b= new BankAccount();
			b.register();
			while(true){
				System.out.print("\n\n1. login\n2. Exit");
				System.out.print("\nEnter yout choice:");
				int ch= takeIntegerInput(20);
				if(ch==1){
					if(b.login()){
						System.out.print("\n------------- WELCOME BACK "+b.name+ " ------------\n");
						boolean isFinished=false;
						while(!isFinished){
							System.out.print("\n1. Withdraw\n2. Deposit\n3. Transfer\n4. check balance\n5. TransHistory\n6. isFinished");
							System.out.print("\nEnter your choice : ");
				            int c = takeIntegerInput(20);
							switch(c){
								case 1:
								b.withdraw();
								break;
								case 2:
								b.deposit();
								break;
								case 3:
								b.transfer();
								break;
								case 4:
								b.checkBalance();
								break;
								case 5:
								b.transHistory();
								break;
								case 6:
								isFinished=true;
								break;
							}
						}
					}
				}
				else{
						System.exit(0);
				}
				
             }
		}
		else{
			System.exit(0);
		}
}}
class BankAccount{
	String name;
	String userName;
    String password;
	String accountNo;
	double balance=0;
	int transactions=0;
	String transactionHistory="";

	public void register(){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Your Name : ");
		this.name=sc.nextLine();
		System.out.print("Enter Your UserName : ");
		this.userName=sc.nextLine();
		System.out.print("Enter Your Password : ");
		this.password=sc.nextLine();
		System.out.print("Enter Your Account No : ");
		this.accountNo=sc.nextLine();
		System.out.print(" Registration Completed Kindly Login");
		System.out.print("=========================================");

  }
  
   public boolean login(){
		boolean isLogin=false;
		Scanner sc=new Scanner(System.in);
		while(!isLogin){
			System.out.print("Enter your username : ");
			String UserName=sc.nextLine();
			if(UserName.equals(userName)){
				while(!isLogin){
					System.out.print("Enter Your Password : ");
			        String Password=sc.nextLine();
					if(Password.equals(password)){
						System.out.print("Login successfully");
						isLogin=true;
					}
					else{
						System.out.println("Incorrect Password");
					}
				}
			}
            else{
				System.out.println("Username not found");
			}
		}
		return isLogin;
	}


	public void withdraw(){
		System.out.print("Enter amount to withdraw: ");
		Scanner sc=new Scanner(System.in);
		double amount = sc.nextDouble();
		try{
			if(balance>=amount){
				transactions++;
				balance-=amount;
				System.out.print("Withdraw Successful");
				String str= amount+"Rs Withdrawed\n";
				transactionHistory = transactionHistory.concat(str);
			}
			else{
				System.out.println("\nInsufficient Balance");
			}
		}
		catch(Exception e){
		}
    }

	public void deposit(){
		System.out.println("\nEnter amount to deposit : ");
		Scanner sc=new Scanner(System.in);
		double amount=sc.nextDouble();
		try{
			if(amount<=100000){
				transactions++;
				balance +=amount;
				System.out.println("\n Successfully Deposited");
				String str=amount+"Rs deposited \n";
				transactionHistory=transactionHistory.concat(str);
			}
			else{
				System.out.println("\n Sorry.... Limit is 100000.00");
			}
		}
		catch(Exception e){
		}
	}
	
	public void transfer(){
		Scanner sc=new Scanner(System.in);
		System.out.println("\n Enter Receipent's Name :");
		String receipent=sc.nextLine();
		System.out.println("\n Enter amount to transfer:");
		double amount = sc.nextDouble();
		
		try{
			if(balance>=amount){
				if(amount<=50000){
					transactions++;
					balance-=amount;
					System.out.println("\n Successfully Transferad to "+ receipent);
					String str=amount + "Rs transefered to " +receipent+"\n";
					transactionHistory= transactionHistory.concat(str);
				}
			else{
				System.out.println("\n Sorry... Limit si 50000.00");
			}
		}
		}
		catch(Exception e){
		}
	}

	public void checkBalance(){
		System.out.println("\n"+balance+"Rs");
	}
	public void transHistory(){
		if(transactions==0){
			System.out.println("\n Empty");
		}
		else{
			System.out.println("\n"+transactionHistory);
		}
	}
}



class BankAccount{
	String name;
	String userName;
    String password;
	String accountNo;
	double balance=0;
	int transactions=0;
	String transactionHistory="";

	public void register(){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Your Name : ");
		this.name=sc.nextLine();
		System.out.print("Enter Your UserName : ");
		this.userName=sc.nextLine();
		System.out.print("Enter Your Password : ");
		this.password=sc.nextLine();
		System.out.print("Enter Your Account No : ");
		this.accountNo=sc.nextLine();
		System.out.print(" Registration Completed Kindly Login");
		System.out.print("=========================================");

  }
  
   public boolean login(){
		boolean isLogin=false;
		Scanner sc=new Scanner(System.in);
		while(!isLogin){
			System.out.print("Enter your username : ");
			String UserName=sc.nextLine();
			if(UserName.equals(userName)){
				while(!isLogin){
					System.out.print("Enter Your Password : ");
			        String Password=sc.nextLine();
					if(Password.equals(password)){
						System.out.print("Login successfully");
						isLogin=true;
					}
					else{
						System.out.println("Incorrect Password");
					}
				}
			}
            else{
				System.out.println("Username not found");
			}
		}
		return isLogin;
	}


	public void withdraw(){
		System.out.print("Enter amount to withdraw: ");
		Scanner sc=new Scanner(System.in);
		double amount = sc.nextDouble();
		try{
			if(balance>=amount){
				transactions++;
				balance-=amount;
				System.out.print("Withdraw Successful");
				String str= amount+"Rs Withdrawed\n";
				transactionHistory = transactionHistory.concat(str);
			}
			else{
				System.out.println("\nInsufficient Balance");
			}
		}
		catch(Exception e){
		}
    }

	public void deposit(){
		System.out.println("\nEnter amount to deposit : ");
		Scanner sc=new Scanner(System.in);
		double amount=sc.nextDouble();
		try{
			if(amount<=100000){
				transactions++;
				balance +=amount;
				System.out.println("\n Successfully Deposited");
				String str=amount+"Rs deposited \n";
				transactionHistory=transactionHistory.concat(str);
			}
			else{
				System.out.println("\n Sorry.... Limit is 100000.00");
			}
		}
		catch(Exception e){
		}
	}
	
	public void transfer(){
		Scanner sc=new Scanner(System.in);
		System.out.println("\n Enter Receipent's Name :");
		String receipent=sc.nextLine();
		System.out.println("\n Enter amount to transfer:");
		double amount = sc.nextDouble();
		
		try{
			if(balance>=amount){
				if(amount<=50000){
					transactions++;
					balance-=amount;
					System.out.println("\n Successfully Transferad to "+ receipent);
					String str=amount + "Rs transefered to " +receipent+"\n";
					transactionHistory= transactionHistory.concat(str);
				}
			else{
				System.out.println("\n Sorry... Limit si 50000.00");
			}
		}
		}
		catch(Exception e){
		}
	}

	public void checkBalance(){
		System.out.println("\n"+balance+"Rs");
	}
	public void transHistory(){
		if(transactions==0){
			System.out.println("\n Empty");
		}
		else{
			System.out.println("\n"+transactionHistory);
		}
	}
}
