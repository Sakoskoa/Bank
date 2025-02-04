package sakoskoa.bank;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank santander = new Bank("0001");
        // C = Criar Conta
        // E = Sair (exit)
        while (true) {
            System.out.println("O que deseja fazer? C=Criar conta, E=Sair do programa");
            String op = scanner.nextLine();

            if (op.equals("C")) {
                System.out.println("Digite o seu nome:");
                String name = scanner.nextLine();
                Account account = santander.generateAccount(name);
                santander.insertAccount(account);

                operateAccount(account);
            } else if (op.equals("E")) {
                break;
            } else {
                System.out.println("Comando inválido, tente novamente!");
            }
        }

        List<Account> accountsList = santander.getAccounts();
        for (Account cc : accountsList) {
            System.out.println(cc);
        }
        santander.outputTotal();
    }

    static void operateAccount(Account account) {
        Scanner scanner = new Scanner(System.in);

        // D = Deposito
        // S = Saque
        // E = Sair (exit)
        while (true) {
            System.out.println(" O que Deseja fazer? D=Deposito,  S=Saque, E=Sair da Conta");
            String op = scanner.nextLine();

            if (op.equals("D")) {
                System.out.println("Qual valor deseja Depositar?");
                double value = scanner.nextDouble();
                account.deposit(value);
            } else if (op.equals("S")) {
                System.out.println("Qual vlaor deseja sacar?");
                double value = scanner.nextDouble();
                if (!account.withDraw(value)) {
                    System.out.println("Ops! Você não tem saldo suficiente para saque");
                }
            } else if (op.equals("E")) {
                break;
            } else {
                System.out.println("Comando invalido tente novamente");
                System.out.println("Volte novamento");
            }
        }
    }
}







