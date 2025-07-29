import java.util.ArrayList;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Shool> scools = new ArrayList<>();
        System.out.println("Сколько школ вы хотите добавить?");
        int x = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < x; i++) {
            Shool s = inputSho(sc);
            scools.add(s);
        }

        System.out.println("сКОЛЬКО УЧЕНИКОВ ДОБАВИТЬ В ШКОЛЛУ");
        int col = sc.nextInt();
        ArrayList<Grduate> graduate = new ArrayList<>();

        sc.nextLine();
        for (int i = 0; i < col; i++) {
            Grduate grad = inputGr(sc);
            System.out.println("Выберите школу для класса");
            for (int j = 0; j < scools.size(); j++) {
                System.out.println((j+1) + ". " + scools.get(j).name + ", " + scools.get(j).address);
            }
            int ch =  sc.nextInt();
            sc.nextLine();
            grad.school = scools.get(ch - 1);
            scools.get(ch - 1).Studens.add(grad);
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
                Grduate grad = inputGr(sc);
                sc.nextLine();
                graduate.add(grad);

                System.out.println("Выберите школу для нового ученика");
                for (int j = 0; j < scools.size(); j++) {
                    System.out.println((j+1) + ". " + scools.get(j).name + ", " + scools.get(j).address);
                }
                int ch = sc.nextInt();
                sc.nextLine();
                grad.school = scools.get(ch - 1);
                scools.get(ch - 1).Studens.add(grad);
            }
            else if (num1 == 2) {
                System.out.println("Кого ученика вы хотите Анигилировать?");
                infoGr(graduate);
                sc.nextLine();
                int num  = sc.nextInt();
                sc.nextLine();
                Grduate toRemove = graduate.get(num - 1);
                toRemove.school.Studens.remove(toRemove);  // Удаляем из списка учеников школы
                graduate.remove(num - 1);
            }
            else{
                System.out.println("Отмена");
            }
        }

        System.out.println("Информация по школам:");
        for (Shool s : scools) {
            s.printInfo();
        }

        //System.out.println("Итоговый Список:");
        //infoGr(graduate);
    }

     public static void infoGr(ArrayList<Grduate> graduate){
        for (int i = 0; i < graduate.size(); i++) {
            System.out.println((i+1) + ". " + graduate.get(i).fio + ", " + graduate.get(i).age + ", " + graduate.get(i).school);
        }
    }

     public static Grduate inputGr(Scanner sc){
         Grduate newGrad = new Grduate();
         Scanner ss = new Scanner(System.in);

         System.out.print("Введите ФИО ученика");
         newGrad.fio = ss.nextLine();


         System.out.println("Введите возраст ученика ");
         newGrad.age = ss.nextInt();
         ss.nextLine();

         System.out.println("Введите номер класса");
         newGrad.numClas = ss.nextInt();
         ss.nextLine();

         System.out.println("Введите букву класса");
         String lit = ss.nextLine();
         newGrad.litera = lit.charAt(0);

         return newGrad;
    }
    public static Shool inputSho(Scanner sc){
        Shool newSho = new Shool();
        Scanner ss = new Scanner(System.in);

        System.out.println("Введите название школы");
        newSho.name = ss.nextLine();

        System.out.println("Ведите адресс");
        newSho.address = ss.nextLine();
        return newSho;
    }
}

class Grduate {
    String fio;
    int age;
    int numClas;
    char litera;
    Shool school;

    int growing() {
        System.out.println("Взростить на год");
        age++;
        return age;
    }
}
class Shool {
    String name;
    String address;
    ArrayList<Grduate> Studens = new ArrayList<>();
    public void printInfo() {
        System.out.println(name + " - " + address);
        System.out.println("Ученики - [");
        for (int i = 0; i < Studens.size(); i++) {
            Grduate g = Studens.get(i);
            System.out.println((i + 1) + ". " + g.fio + ", " + g.age + " - " + g.numClas + g.litera);
        }
        System.out.println("]");
    }
    public String toString() {
        return name + " - " + address;
    }
}
