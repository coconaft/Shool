import java.util.ArrayList;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите солько учеников будет в классе");
        int col = sc.nextInt();
        ArrayList<Grduate> graduate = new ArrayList<>(col);

        sc.nextLine();
        for (int i = 0; i< col; i++) {
            Grduate grad = inputGr();
            sc.nextLine();
            graduate.add(grad);
        }

        System.out.println("\nТекущий список учеников:");
        infoGr(graduate);

        System.out.println("Внести изменения в списке учеников? (1 да 2 нет)");
        int choice = sc.nextInt();
        if (choice == 1) {
            System.out.println("Добавить ученика - 1  Анигилировать - 2  Отмена - 3");
            sc.nextLine();
            int num1 = sc.nextInt();
            if  (num1 == 1) {
                Grduate grad = inputGr();
                sc.nextLine();
                graduate.add(grad);
            }
            else if (num1 == 2) {
                System.out.println("Кого  ученика вы хотите Анигилировать?");
                infoGr(graduate);
                sc.nextLine();
                int num  = sc.nextInt();
                graduate.remove(num-1);
                sc.nextLine();
            }
            else{
                System.out.println("Отмена");
            }

        }
        System.out.println("Итоговый Список:");
        infoGr(graduate);

    }

     public static void infoGr(ArrayList<Grduate> graduate){
        for (int i = 0; i < graduate.size(); i++) {
            System.out.println((i+1) + ". " + graduate.get(i).fIO + ", " + graduate.get(i).age);
        }
    }
     public static Grduate inputGr(){
         Grduate newGrad = new Grduate();
         Scanner ss = new Scanner(System.in);

         System.out.print("Введите ФИО ученика");
         newGrad.fIO = ss.nextLine();

         System.out.println("Введите возраст ученика ");
         newGrad.age = ss.nextInt();
         return newGrad;
    }
}



class Grduate{
    String fIO;
    int age;
    int growing(){
        System.out.println("Взростить на год");
        age++;
        return age;
    }

}
class Clasov {

    int[] cls1;
    int[] cls2;
    int[] cls3;
    int[] cls4;
    int[] cls5;
    int[] cls6;
    int[] cls7;
    int[] cls8;
    int[] cls9;
    int[] cls10;
    int[] cls11;

    void inf(){
        for (int x:cls11){
            System.out.println(x);
        }
        for (int x:cls10){
            System.out.println(x);
        }
        for (int x:cls9){
            System.out.println(x);
        }
        for (int x:cls8){
            System.out.println(x);
        }
        for (int x:cls7){
            System.out.println(x);
        }
        for (int x:cls6){
            System.out.println(x);
        }
        for (int x:cls5){
            System.out.println(x);
        }
        for (int x:cls4){
            System.out.println(x);
        }
        for (int x:cls3){
            System.out.println(x);
        }
        for (int x:cls2){
            System.out.println(x);
        }
        for (int x:cls1){
            System.out.println(x);
        }
    }

    int vv() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Выбери класс (с 1 по 11)");
        int classNumber = sc.nextInt();
        System.out.println("Сколько будет"+classNumber+"классов");
        int stn = sc.nextInt();

        switch (classNumber) {
            case 1:
                cls1 = new int[stn];
                break;
            case 2:
                cls2 = new int[stn];
                break;
            case 3:
                cls3 = new int[stn];
                break;
            case 4:
                cls4 = new int[stn];
                break;
            case 5:
                cls5 = new int[stn];
                break;
            case 6:
                cls6 = new int[stn];
                break;
            case 7:
                cls7 = new int[stn];
                break;
            case 8:
                cls8 = new int[stn];
                break;
            case 9:
                cls9 = new int[stn];
                break;
            case 10:
                cls10 = new int[stn];
                break;
            case 11:
                cls11 = new int[stn];
                break;
            default:
                System.out.println("Неверный номер класса!");
                return -1;
        }

        return classNumber;

    }

}
