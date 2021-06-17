package application;

import java.util.Scanner;

import model.entities.Account;
import model.exception.DomainException;

public class Program {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			String holder = sc.next();
			sc.nextLine();
			Account account;
			System.out.println("Want to add a starting balance and set your account withdrawal limit?(y/n)");
			System.out.println("if you do not wish to set a withdrawal limit, your limit value will be 300 conto");
			char c = sc.nextLine().toUpperCase().charAt(0);
			if(c =='Y') {
				System.out.print("Initial balance:");
				double balance = sc.nextDouble();
				System.out.print("Withdrawal limit: ");
				double withDrawalLimit = sc.nextDouble();
				account = new Account(number,holder,balance,withDrawalLimit);
			}else{
				account = new Account(number,holder);
			}
			// Execução de um saque
			System.out.println("Enter amount for withdraw:");
			double amount = sc.nextDouble();
			account.withdraw(amount);
			System.out.print("New balance: "+account.getBalance());
		}catch(RuntimeException e){
			System.out.println("Unexpected error");
		}catch(DomainException e) {
			System.out.println("Withdraw error: "+e.getMessage());
		}
		sc.close();
	}

}
