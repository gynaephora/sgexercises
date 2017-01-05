import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by mustango on 04.01.2017.
 */
public class EmployeesMain {

    ArrayList<Object> mEmployeesBase=new ArrayList<>();
    Object employees;

    public static void main(String[] args) {
        String button;
        EmployeesMain main=new EmployeesMain();
        do{
            System.out.println("Для сортировки работников и отображения списка  -      введите: 1");
            System.out.println("--- отображения 5 первых сотрудников из списка  -      введите: 2");
            System.out.println("--- отображения ID 3-х последних из списка сотрудников введите: 3");
            System.out.println("--- записи списка сотрудников из файла -               введите: 4");
            System.out.println("--- вывода списка сотрудников в файл   -               введите: 5");
            System.out.println("--- завершения работі с программой     -               введите: 6");
            button=main.stringReader();
            switch(button) {
                case "1":
                    main.writeAllInformationOfEmployees();
                    break;
                case "2":
                    main.writeSomeNumberInformationOfEmployees();
                    break;
                case "3":
                    main.writeIdOfEmployees();
                    break;
                case "4":
                    main.writeFromFile();
                    break;
                case "5":
                    main.writeToFile();
                    break;
                default:
                    break;
            }

        }while(!button.equals("6"));



    }

    public String stringReader(){
        String string;
        Scanner in = new Scanner(System.in);
        string=in.next();
        return string;
    }

    /*
    * Метод возвращает заполненный данными обьект Работник
    * */

    public Object formEmployeesBase(String name,String salary,String flag){

         if(flag.equals("0")){
             EmployeesHourlyWage employeesHourlyWage=new EmployeesHourlyWage();
             employeesHourlyWage.setName(name);
             employeesHourlyWage.salaryCalc(Double.valueOf(salary));
             employees=employeesHourlyWage;
         }
             else {
             EmployeesFixedPayment employeesFixedPayment=new EmployeesFixedPayment();
             employeesFixedPayment.setName(name);
             employeesFixedPayment.salaryCalc(Double.valueOf(salary));
             employees=employeesFixedPayment;
        }
        return employees;
    }

    public void sortByAvarageMonthlySalary(){

    }

    public void writeAllInformationOfEmployees(){



    }

    public void writeSomeNumberInformationOfEmployees(){

        if(mEmployeesBase!=null){
            for(int i=0;i<5;i++){
                employees=mEmployeesBase.get(i);
                
                System.out.println(employees.);
            }
        }

    }

    public void writeIdOfEmployees(){

    }

    public void writeToFile(){

    }
    public void writeFromFile(){

      //  StringBuilder sb = new StringBuilder();
        File file = new File("in.txt");
      /*  if (!file.exists()){
            throw new FileNotFoundException(file.getName());
        }*/
        try {
            //Объект для чтения файла в буфер
            BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
            try {
                //В цикле построчно считываем файл
                String s;
                String token="\t";
                while ((s = in.readLine()) != null) {

                    StringTokenizer st =
                            new StringTokenizer(s, token, false);

                    Object obj=new Object();
                    obj=formEmployeesBase(st.nextElement().toString(),st.nextElement().toString(),st.nextElement().toString());
                    mEmployeesBase.add(obj);
//                    System.out.print("Имя "+st.nextElement()+" ");
//                    System.out.print("Зарплата "+st.nextElement()+" ");
//                   System.out.println("flag "+st.nextElement());
                /*   while(st.hasMoreTokens())
                    {
                        System.out.print(st.nextToken());
                    }*/
                 //   sb.append(s);
                  //  System.out.print(s);
                //    sb.append("\n");

                }
               // System.out.print(sb);
            } finally {
                //Также не забываем закрыть файл
                in.close();
            }




        } catch(IOException e) {
            throw new RuntimeException(e);
        }



    }
}
