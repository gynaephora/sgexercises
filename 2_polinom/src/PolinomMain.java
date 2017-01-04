import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by mustango on 03.01.2017.
 */
public class PolinomMain {


    public static void main(String[] args) {

        PolinomMain paskalTMain=new PolinomMain();
        paskalTMain.stringIn();


    }

    /*
      Метод считывает данные аргументов полинома с клавиатуры и отправляет на обработку
      в метод polinomWrite.
     */

    public void stringIn(){
        Integer a,b,n;
        System.out.println("Введите числа а, b, n - для расчета полинома n-ной степени:");
        Scanner in = new Scanner(System.in);
        System.out.print("а=");
        a=in.nextInt();
        System.out.print("b=");
        b=in.nextInt();
        System.out.print("n=");
        n=in.nextInt();
        polinomWrite(a,b,n);
    }

    /*
     Метод формирует элементы полинома и выводит в строку каждый элемент и значение полинома
     */

    public void polinomWrite(Integer a1,Integer b1,Integer n1) {
        int n_a = n1;
        int n_b = 0;
        ArrayList<String[]> members=new ArrayList<String[]>();
        PaskalTriangle koefObject = new PaskalTriangle();//создаем обьект массив коэфициентов полтнома
        Integer[] koef = koefObject.numberOut(n1);//получаем масив коэфициентов полинома

        for (int i = 0; i < koef.length; i++) {
            String[] polinom=new String[9];
            // заполняем массив элементов текущего члена полинома
            // String[9]=[коэфициент][*][а][^][текущая степень а][*][b][^][текущая степень b]
            if(koef[i]==1) {
                polinom[0] = "";//коефициент
                polinom[1] = "";//знак *
                if (n_a == 0) {
                    polinom[2] = "";//аргумент - а
                    polinom[3] = "";//знак степени ^
                    polinom[4] = "";//текущая степень n_a
                    polinom[5] = "";//знак *

                    polinom[6] = "b";//аргумент - b
                    polinom[7] = "^";//знак степени ^
                    polinom[8] = ""+n_b;//текущая степень n_b
                }
                else if (n_b == 0) {
                    polinom[2] = "a";//аргумент - а
                    polinom[3] = "^";//знак степени ^
                    polinom[4] = ""+n_a;//текущая степень n_a

                    polinom[5] = "";//знак *
                    polinom[6] = "";//аргумент - b
                    polinom[7] = "";//знак степени ^
                    polinom[8] = "";//текущая степень n_b
                                      }

            }else {
                       polinom[0] = ""+koef[i];//коефициент
                       polinom[1] = "*";//знак *
                       polinom[5] = "*";//знак *
                       if(n_a==1){
                           polinom[2] = "a";//аргумент - а
                           polinom[3] = "";//знак степени ^
                           polinom[4] = "";//текущая степень n_a
                       }else {
                           polinom[2] = "a";//аргумент - а
                           polinom[3] = "^";//знак степени ^
                           polinom[4] = ""+n_a;//текущая степень n_a
                             }
                       if(n_b==1){
                           polinom[6] = "b";//аргумент - b
                           polinom[7] = "";//знак степени ^
                           polinom[8] = "";//текущая степень n_b
                       }else {
                           polinom[6] = "b";//аргумент - b
                           polinom[7] = "^";//знак степени ^
                           polinom[8] = ""+n_b;//текущая степень n_b
                             }

                   }



              members.add(polinom);

              n_a=n_a-1;
              n_b=n_b+1;

        }
        String pol="";
        for(int j=0;j<members.size();j++){
            for(int y=0;y<9;y++) {
                pol=pol+members.get(j)[y];
            }
            if(j==(members.size()-1))System.out.print(pol + "="+polynomResult(a1,b1,n1));
            else System.out.print(pol + "+");

            pol="";
            }

    }

    /*
      Метод, который подсчитывает значение полинома и возвращает это значение
    */

    public Integer polynomResult(Integer a1,Integer b1,Integer n1){
        Integer result=1;
        for(int i=0;i<n1;i++){
           result=(a1+b1)*result;
        }
        return result;
    }



}
