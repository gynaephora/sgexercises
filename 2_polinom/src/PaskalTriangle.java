import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Volodymyr Korzhovskyi  on 03.01.2017.
 */
public class PaskalTriangle {

    Integer number;
    Integer[][] in;

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
    public Integer[] numberOut(int n){
        Integer[][] out=numberForming(n);
        Integer[] koef=new Integer[n+1];
        int j=n;
      //  System.out.println("n-ный ряд Треугольника Паскаля:");
        for(int i=0;i<=n;i++){
            System.out.print(out[i][j]+" ");
            koef[i]=out[i][j];
            j=j-1;
        }
        return koef;
    }

}
