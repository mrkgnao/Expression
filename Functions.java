import java.util.Scanner;

class Functions
{
    static String[] list={"sqrt","cbrt", "rand", "randInt", "exp", "ln", "log", "logab", "sin", "cos", "tan", "asin", "acos", "atan",
                       "sinh", "cosh", "tanh", "asinh", "acosh", "atanh", "min", "max", "abs", "-", "sum", "prod", "floor", "ceil", "sign", "round"};
    
    
    static String evalFunction(String function, String arguments)
    {
        Scanner sc=new Scanner(arguments+",").useDelimiter(",");
        
        try
        {
            String s=sc.next();
            double x=s.indexOf("x")==-1?Double.parseDouble(s):0;

            //general functions
            if(function.equals("sqrt"))
            return ""+Math.sqrt(x);
            
            if(function.equals("cbrt"))
            return ""+Math.cbrt(x);
            
            if(function.equals("rand"))
            return ""+Math.random();
            
            if(function.equals("randInt"))
            return ""+Math.floor(x+Math.random()*(sc.nextDouble()-x));
            
            //exponential and logarithmic
            if(function.equals("exp"))
            return ""+Math.exp(x);
            
            if(function.equals("ln"))
            return ""+Math.log(x);
            
            if(function.equals("log"))
            return ""+Math.log(x)/Math.log(10);
            
            if(function.equals("logab"))
            return ""+Math.log(x)/Math.log(sc.nextDouble());
            
            //trigonometric
            if(function.equals("sin"))
            return ""+Math.sin(x);
            
            if(function.equals("cos"))
            return ""+Math.cos(x);
            
            if(function.equals("tan"))
            return ""+Math.tan(x);
            
            if(function.equals("asin"))
            return ""+Math.asin(x);
            
            if(function.equals("acos"))
            return ""+Math.acos(x);
            
            if(function.equals("atan"))
            return ""+Math.atan(x);
            
            //hyperbolic trigonometric
            if(function.equals("sinh"))
            return ""+Math.sinh(x);
            
            if(function.equals("cosh"))
            return ""+Math.cosh(x);
            
            if(function.equals("tanh"))
            return ""+Math.tanh(x);
            
            if(function.equals("asinh"))
            return ""+Math.log(x+Math.sqrt(x*x+1));
            
            if(function.equals("acosh"))
            return ""+Math.log(x+Math.sqrt(x*x-1)); 
            
            if(function.equals("atanh"))
            return ""+0.5*Math.log((x+1)/(x-1));
            
            //number theory
            if(function.equals("max"))
            {
                double max=x;
                while(sc.hasNext())
                max=Math.max(max,sc.nextDouble());
                return ""+max;
            }
            
            if(function.equals("min"))
            {
                double min=x;
                while(sc.hasNext())
                min=Math.min(min,sc.nextDouble());
                return ""+min;
            }
            
            if(function.equals("abs"))
            return ""+Math.abs(x);
            
            if(function.equals("-"))
            return ""+x*-1;
            
            if(function.equals("sum"))
            {
                double sum=x;
                while(sc.hasNext())
                sum+=sc.nextDouble();
                return ""+sum;
            }
            
            if(function.equals("prod"))
            {
                double prod=x;
                while(sc.hasNext())
                prod*=sc.nextDouble();
                return ""+prod;
            }
            
            if(function.equals("floor"))
            return ""+Math.floor(x);
            
            if(function.equals("ceil"))
            return ""+Math.ceil(x);
            
            if(function.equals("sign"))
            return ""+Math.signum(x);
            
            if(function.equals("round"))
            return ""+Math.round(x);
            
            return "";
        }
        catch(Exception e)
        {
            return function+"("+arguments+")";
        }
    }
    
    static boolean isFunction(String f)
    {
        for(String k:list)
        if(k.equals(f))
        return true;
        return false;
    }
}
        