import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Volodymyr Korzhovskyi  on 03.01.2017.
 */
public class StringMain {
    String mString;
    ArrayList<String> massString;
    ArrayList<Integer> intMass;
    String[] number=new String[]{"0","1","2","3","4","5","6","7","8","9"};
    String[] operators=new String[]{"+","-","*","/"};

    public static void main(String[] args) {

        StringMain stringMain=new StringMain();
        ArrayList<String> mass=stringMain.getMassString();
        ArrayList<Integer> output=new ArrayList<Integer>();
        try {
             //проходим по масиву строк конвертируя числовые текстовые представления в числа и
            //арифмеические операции при удовлетворении условия [число][операция][число] возвращаем результат операции
            //заполняем новый масив полученными числовыми значениями

        for(int i=0;i<mass.size();i++) {

            if (!stringMain.ifOperator(mass.get(i))) {
                if (i == (mass.size() - 1)) {
                    int res1 = Integer.parseInt(mass.get(i));
                    output.add(res1);

                } else {
                    if (mass.get(i + 1) != null & !stringMain.ifOperator(mass.get(i + 1))) {
                        int res2 = Integer.parseInt(mass.get(i));
                        output.add(res2);
                        //System.out.println( res2+ "\n");
                    } else if (mass.get(i + 2) != null) {
                        int res3 = stringMain.math(mass.get(i + 1), mass.get(i), mass.get(i + 2));
                        output.add(res3);
                        // System.out.println(res3 + "\n");
                        i = i + 2;
                    }

                }
            }
        }
            if(output!=null){
                if(output.size()<2) {
                    System.out.println(output.get(0) + "\n");
                    System.out.println("Недостаточно аргументов для вычисления большего и меньшего числа");
                }
                else {

                    //выводим результат согласно поставленной задачи
                    for (int f = 0; f < output.size(); f++) {
                        System.out.println(output.get(f) + "\n");
                    }
                    System.out.println("Max="+stringMain.Max(output) + "\n");
                    System.out.println("Min="+stringMain.Min(output) + "\n");
                }
            }

        }catch(Exception e){
            System.out.println("Ошибка. Некорректный ввод");

        }
    }

     /*
    * Метод находит максимальный элемент массива чисел
    * */

    public Integer Max(ArrayList<Integer> output){
           int max=output.get(0);
           for (int f = (output.size()-1); f >=0 ; f--) {
               if(output.get(f)>max) max=output.get(f);
        }
           return max;
    }

    /*
    * Метод находит маинимальный элемент массива чисел
    * */

    public Integer Min(ArrayList<Integer> output){
        int min=output.get(0);
        for (int f = (output.size()-1); f >=0; f--) {
            if(output.get(f)<min) min=output.get(f);

        }
        return min;
            }

    /*
      Метод считывает введенную пользователем строку
    */
    public String stringIn(){
        System.out.println("Введите строку:");
        Scanner in = new Scanner(System.in);
        mString=in.next();
        return mString;
    }
    /*
    * Метод создает массив строк которые представляют числа или арифметические опперации
    * и возвращает его содержание
    * */

    public  ArrayList<String> getMassString() {
        String s=stringIn();
        ArrayList<String> massS=new ArrayList<String>();
        ArrayList<String> massS2=new ArrayList<String>();
        char[]  chars=s.toCharArray();
        for(int j=0;j<chars.length;j++){
            massS.add(Character.toString(chars[j]));

        }
        String nummerTemp="";;
        int i=0;
        do{
            String v=massS.get(i);
            if(ifNumber(v)){
                nummerTemp=nummerTemp+v;
                if(i==(massS.size()-1)) massS2.add(nummerTemp);
            }
                    else {
                           if(!nummerTemp.equals("")) massS2.add(nummerTemp);
                           nummerTemp="";
                           if (ifOperator(v)){

                               massS2.add(v);
                           }
            }
            i=i+1;

            }while(i<massS.size());

        return massS2;
    }

    /*
   * Метод проверяет является ли передаваемый аргумент числом
   * */
    public boolean ifNumber(String s){
        boolean m=false;
        for(int i=0;i<number.length;i++){
            if(s.equals(number[i])){
                m=true;
                }
            }
        return m;
    }

    /*
    * Метод проверяет является ли передаваемый аргумент оператором
    * */

    public Boolean ifOperator(String s){
        boolean m=false;
        for(int i=0;i<operators.length;i++){
            if(s.equals(operators[i])) m=true;
        }
        return m;
    }

    /*
    * Метод выполняет математические операции и возвращает рещультат
    * */
    public Integer math(String operators,String a1,String b1){
        int result=0;
        int a = Integer.parseInt(a1);
        int b = Integer.parseInt(b1);
        switch(operators) {
            case "*":
                result=a*b;
                break;
            case "/":
                result=a/b;
                break;
            case "+":
                result=a+b;
                break;
            case "-":
                result=a-b;
                break;
            default:
                break;
        }
        return result;
    }

}
