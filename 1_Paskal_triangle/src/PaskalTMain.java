import java.util.Scanner;

/**
 * Created by Volodymyr Korzhovskyi  on 02.01.2017.
 */
public class PaskalTMain {
    Integer number;
    Integer[][] in;

    public static void main(String[] args) {

           PaskalTMain paskalTMain=new PaskalTMain();

           try {
               int n = paskalTMain.numberIn();
               System.out.println(n);
               paskalTMain.numberOut(n);
           }catch(Exception e){
               System.out.println("Ошибка. Вы ввели некоректные данные");

           }
    }
    /*
    * Метод считывает введенный пользователем аргумент
    * и возвращает его значение
    * */


    public Integer numberIn(){
        System.out.println("Введите целое число:");
        Scanner in = new Scanner(System.in);
        number=in.nextInt();
        return number;
    }

    /*
    * Метод заполняет двумерный массив коэффициентами Треугольника Паскаля и возвращает его содержание
    * Столбец 1 и 1 ряд всегда равны 1, другие как сума 2 чисел которые над ними:
    * 1   1   1   1   1
    * 1   2   3   4   5
    * 1   3   6   10
    * 1   4   10
    * 1   5
    *
    * */

    public Integer[][] numberForming(int n){
        in=new  Integer[n+1][n+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(i==0) in[i][j]=1;
                else if (j==0) in[i][j]=1;
                     else in[i][j]=in[i-1][j]+in[i][j-1];
            }
        }

        return in;
    }

    /*
    * Метод выводит результат n-ный ряд коеффициентов Треугольника Паскаля
    * */

    public void numberOut(int n){
        Integer[][] out=numberForming(n);
        int j=n;
        System.out.println("n-ный ряд Треугольника Паскаля:");
        for(int i=0;i<=n;i++){
            System.out.print(out[i][j]+" "); //извлекаем необходимую диагональ из таблицы, которая и есть n-ный ряд Треугольника Паскаля
            j=j-1;
        }
    }
}
