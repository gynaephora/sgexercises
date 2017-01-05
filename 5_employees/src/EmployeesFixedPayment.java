import java.util.UUID;

/**
 * Created by mustango on 04.01.2017.
 */
public class EmployeesFixedPayment  extends Object implements Employees{


    private String mName;
    private UUID mId;
    private double average_monthly_salary;

    public EmployeesFixedPayment(){
        mId = UUID.randomUUID();
    }

    public void setName(String name){mName=name;}

    public String getName(){return mName;}

    public double getSalary(){return average_monthly_salary;}

    public void salaryCalc(double fixed_monthly_payment){
        average_monthly_salary= fixed_monthly_payment;
    }
}
