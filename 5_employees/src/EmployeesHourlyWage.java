import java.util.UUID;

/**
 * Created by mustango on 04.01.2017.
 */
public class EmployeesHourlyWage implements Employees {

    private String mName;
    private UUID mId;
    private double average_monthly_salary;

    public EmployeesHourlyWage(){
        mId = UUID.randomUUID();
    }

    public void setName(String name){mName=name;}

    public String getName(){return mName;}

    public double getSalary(){return average_monthly_salary;}


    public void salaryCalc(double hourly_rate){
        average_monthly_salary= 20.8*8* hourly_rate;
    }
}
