import java.util.Scanner;

class Functions
{
    static String evalFunction(String function, String arguments)
    {
        Scanner sc=new Scanner(arguments+",").useDelimiter(",");
        
        if(function.equals("sqrt"))
        return ""+Math.sqrt(sc.nextDouble());
             
        if(function.equals("exp"))
        return ""+Math.exp(sc.nextDouble());
        
        if(function.equals("ln"))
        return ""+Math.log(sc.nextDouble());
        
        if(function.equals("sin"))
        return ""+Math.sin(sc.nextDouble());
        
        if(function.equals("cos"))
        return ""+Math.cos(sc.nextDouble());
        
        if(function.equals("tan"))
        return ""+Math.tan(sc.nextDouble());
        
        if(function.equals("abs"))
        return ""+Math.abs(sc.nextDouble());
        
        if(function.equals("-"))
        return ""+sc.nextDouble()*-1;
        
        return "";
    }
}
        