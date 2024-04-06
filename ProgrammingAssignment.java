import java.util.Scanner;

public class ProgrammingAssignmentSawWinNweHND43 {
    // sta
    ic class
    static int num;
    static String BookList[] = { "1. Most Popular", "2. colleen hoover", "3. john green", "4. William Shakespeare" };
    static String MostPopular[] = { "1. Call me by your name by André Aciman=6000mmk",
            "2 Seven husbands of evelyn hugo by Taylor Jenkins Reid=7800mmk",
            "3. The Midnight Library by Matt Haig=10000mmk", "4. They Both Die at the Ends by Adam Silvera=7000mmk" };
    static String CH[] = { "1. It End With Us=6500mmk", "2. Ugly Love=4500mmk", "3. Remember Me=8000mmk" };
    static String JG[] = { "1. Paper Town=8500mmk", "2. Looking for Alaska=12000mmk",
            "3. the fault in our star=7500mmk", "4. Turtles All the Way Down=6000mmk" };
    static String WS[] = { "1. Romeo and Juliet=2

    ustomer Name

    class my
    method
    ic

    static void CusName() {System.out.println("Enter you ame");

    String nam

        System.out.println("Welcome " + name);
        getBook();//to get book class
    }

        et Book class

        public static void getBook() {
            System.out.println("please select Categories");
            for (String BookList1 : BookList) {
                System.out.println(BookList1);
            }
            System.out.print("Type in numbers: ");
            num = scan.nextInt();
            // System.out.println("here is your result: " + BookList[num - 1].substring(3,
            // BookList[num - 1].length()));
            if (num != 2) {
                if (3 != num)
                    if (num == 4) {
                        getWilliamShakespears();
                    } else {
                        getMP();
                    }
                else {
                    getJohnGreen();
                }
            } else {
                getCollenHoover();
            }
        }

        ost Popular iSystem.out.println("here is your resul

        for(
        String MostPopular1:
        MostPop
        System.out
    }

    em.out.print("Type in numbers: ");

    ng selectedBoo x=0;(

    index=i;
    }}

    System.out.println("thank you for purchasing "+MostPopular[index]);}

    // Colleen Hoover
    public static void getCollenHoover() {
        System.out.println("here is your result: ");
        for (String CH1 : CH) {
            System.out.println(CH1);
        }
        System.out.print("Type in numbers: ");
        String selectedBook = scan.next();
        int index = 0;
        for (int i = 0; i < CH.length; i++) {
            boolean contain = CH[i].startsWith(selectedBook);
            //switch if
            if (contain) {
                index = i;
            }
        }

        System.out.println("thank you for purchasing " + CH[index]);
    }

    // John Green Class
    public static void getJohnGreen() {
        System.out.println("here is your result: ");
        for (String JG1 : JG) {
            System.out.println(JG1);
        }
        System.out.print("Type in numbers: ");
        String selectedBook = scan.next();
        int index = 0;
        for (int i = 0; i < JG.length; i++) {
            boolean contain = JG[i].startsWith(selectedBook);
            if (contain) {
                index = i;
            }
        }

        System.out.println("thank you for purchasing " + JG[index]);
    }

    illaim Shakespears

    public static void getWilliamShakespears() {
        System.out.println("here is your result: ");
        for (String WS1 : WS) {
            System.out.println(WS1);
        }
        System.out.print("Type in numbers: ");
        String selectedBook = scan.next();
        int index = 0;
        for (int i = 0; i < WS.length; i++) {
            boolean contain = WS[i].startsWith(selectedBook);
            if (contain) {
                index = i;
            }
        }

        System.out.println("thank you for purchasing " + WS[index]);

    }

    public static void main(String[] args) {
        CusName();
    }

}
