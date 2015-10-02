import java.util.Scanner;

class Functions
{
    static String[][] list={
        {"sqrt(x)","Returns the square root of a number."},
        {"cbrt(x)","Returns the cube root of a number."},
        {"rand()","Returns a random number between 0 and 1."},
        {"randInt(a,b)","Returns a random integer between a and b."},
        {"exp(x)","Returns e to the power x."},
        {"ln(x)","Returns the logarithm of x to the base e."},
        {"log(x)","Returns the logarithm of x to the base 10."},
        {"logab(a,b)","Returns the logarithm of a to the base b."},
        {"sin(x)","Returns the sine of x."},
        {"cos(x)","Returns the cosine of x."},
        {"tan(x)","Returns the tangent of x."},
        {"asin(x)","Returns the inverse sine of x."},
        {"acos(x)","Returns the inverse cosine of x."},
        {"atan(x)","Returns the inverse tangent of x."},
        {"sinh(x)","Returns the hyperbolic sine of x."},
        {"cosh(x)","Returns the hyperbolic cosine of x."},
        {"tanh(x)","Returns the hyperbolic tangent of x."},
        {"asinh(x)","Returns the inverse hyperbolic sine of x."},
        {"acosh(x)","Returns the inverse hyperbolic cosine of x."},
        {"atanh(x)","Returns the inverse hyperbolic tangent of x."},
        {"min(a,b,....z)","Returns the minimum of a,b,...z."},
        {"max(a,b,....z)","Returns the maximum of a,b,...z"},
        {"abs(x)","Retuns the absolute value of x."},
        {"sum(a,b,....z)","Returns a+b+....+z."},
        {"prod(a,b,....z)","Returns a*b*....*z."},
        {"floor(x)","Returns the greatest integer less than or equal to x."},
        {"ceil(x)","Retuns the least integer greater than or equal to x."},
        {"sign(x)","Retuns +1 if x>0, -1 if x<0, 0 if x=0."},
        {"round(x)","Returns the rounded value of x."},
        {"fact(x)", "Returns the factorial of x."},
        {"perm(n,r)","Retuns n!/(n-r)!"},
        {"comb(n,r)","Returns n!/r!/(n-r)!"}};
    
    
    static String evalFunction(String function, String arguments)
    {
        Scanner sc=new Scanner(arguments+",").useDelimiter(",");
        
        try
        {
            double x=sc.nextDouble();

            //general functions
            if(function.equals("sqrt"))
            if(x>=0) return ""+Math.sqrt(x); else return "Square root of negative number is not supported!";
            
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
            if(x>0) return ""+Math.log(x); else return "Logarithm of negative numbers or zero are not supported.";
            
            if(function.equals("log"))
            if(x>0) return ""+Math.log(x)/Math.log(10); else return "Logarithm of negative numbers or zero are not supported.";
            
            if(function.equals("logab"))
            if(x>0) return ""+Math.log(x)/Math.log(sc.nextDouble()); else return "Logarithm of negative numbers or zero are not supported.";
            
            //trigonometric
            if(function.equals("sin"))
            return ""+Math.sin(x);
            
            if(function.equals("cos"))
            return ""+Math.cos(x);
            
            if(function.equals("tan"))
            return ""+Math.tan(x);
            
            if(function.equals("asin"))
            if(x>=-1 && x<=1) return ""+Math.asin(x); else return "sin of a number must lie between -1 and 1.";
            
            if(function.equals("acos"))
            if(x>=-1 && x<=1) return ""+Math.acos(x); else return "cos of a number must lie between -1 and 1.";
            
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
            if(x>=-1 && x<=1) return ""+0.5*Math.log((x+1)/(x-1)); else return "tanh of a number must lie between -1 and 1.";
            
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
            
            if(function.equals("fact"))
            {
                if(x<0) return "Factorial of negative numbers are not supported!";
                int p=1;
                for(int i=1;i<=x;i++) p*=i;
                return ""+p;
            }
            
            if(function.equals("perm"))
            {
                double r=sc.nextDouble(); if(r>x) return "R cannot be greater than N.";
                return ""+Double.parseDouble(evalFunction("fact",""+x))/Double.parseDouble(evalFunction("fact",""+(x-r)));
            }
            
            if(function.equals("comb"))
            {
                double r=sc.nextDouble(); if(r>x) return "R cannot be greater than N.";
                return ""+Double.parseDouble(evalFunction("perm",x+","+r))/Double.parseDouble(evalFunction("fact",""+r));
            }
            
            if(function.equals("floor"))
            return ""+Math.floor(x);
            
            if(function.equals("ceil"))
            return ""+Math.ceil(x);
            
            if(function.equals("sign"))
            return ""+Math.signum(x);
            
            if(function.equals("round"))
            return ""+Math.round(x);
            
            if(function.equals("isPrime"))
            {
                if(x%1!=0 || x<=0) return "The number must be a natural number.";
                
                if(x==1) return "0";
                
                for(int i=2;i<=Math.sqrt(x);i++)
                if(x%i==0)
                return "0";
                return "1";
            }
            
            if(function.equals("gcd"))
            {
                double y=sc.nextDouble();
                
                if(x%1!=0 || y%1!=0 || x<=0 || y<=0) return "The numbers must be natural numbers.";
                
                while(x!=y)
                if(x>y) x=x-y; else y=y-x;
                
                return ""+x;
            }
            
            if(function.equals("lcm"))
            {
                double y=sc.nextDouble();
                
                if(x%1!=0 || y%1!=0 || x<=0 || y<=0) return "The numbers must be natural numbers.";
                
                return ""+(x*y/Double.parseDouble(evalFunction("gcd",arguments)));
            }
            
            return "Function is not supported.";
        }
        catch(Exception e)
        {
            return "Function arguments are not numbers!";
        }
    }
}
        