package lesson6.homework;

public class MyMainCreditCard {
    public static void main(String[] args) {

        CreditCard creditCardOne = new CreditCard("BELARUSBANK",42551111, 1000);
        System.out.println("\n=========================================");
        System.out.println("\t\t\tCredit card №1" + "\n-----------------------------------------");
        creditCardOne.getCardOperation();
        System.out.print("=========================================\n\n\n");

        CreditCard creditCardTwo = new CreditCard("MTБ Банк",42552222,5000);
        System.out.println("=========================================");
        System.out.println("\t\t\tCredit card №2" + "\n-----------------------------------------");
        creditCardTwo.getCardOperation();
        System.out.print("=========================================\n\n\n");

        CreditCard creditCardThree = new CreditCard("Tincoff-Bank",42553333, 3500);
        System.out.println("=========================================");
        System.out.println("\t\t\tCredit card №3" + "\n-----------------------------------------");
        creditCardThree.getCardOperation();
        System.out.print("=========================================\n\n\n");

        System.out.println("\t   Current status of all cards");
        System.out.println("\n========================================="); ;

        creditCardOne.getGlobalInfoAboutCard();
        creditCardTwo.getGlobalInfoAboutCard();
        creditCardThree.getGlobalInfoAboutCard();
        System.out.print("=========================================\n\n\n");
    }
}
