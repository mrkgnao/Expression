class BinaryOperators
{
    static String operators="!E^/*%_+,";
    
    static String[][] list=
    {{"a+b","Adds a to b."},
    {"a-b","Subtracts b form a."},
    {"a*b","Multiplies a and b."},
    {"a/b","Divides a by b."},
    {"a%b","Returns a modulo b."},
    {"a^b","Returns a to the power b."},
    {"aEb","Shorthand for a*10^b."},
    {"a!","Returns the factorial of a."}};

    static String evalOperation(String operation, String operand_1,String operand_2)
    {
        try   
        {
            double a=Double.parseDouble(operand_1);
            double b=Double.parseDouble(operand_2);
            
            switch(operation.charAt(0))
            {
                case '+': return ""+(a+b);
                case '_': return ""+(a-b);
                case '*': return ""+(a*b);
                case '/': if(b!=0) return ""+(a/b); else return "Division by zero!";
                case '^': return ""+(Math.pow(a,b));
                case '%': return ""+a%b;
                case ',': return ""+a+","+b;
                case 'E': return ""+a*Math.pow(10,b);
                case '!': if(a%1!=0 || a<0) return "Factorial function works only with positive integer numbers!";
                          int p=1;
                          for(int i=1;i<=a;i++)
                          p*=i;
                          return ""+p;
                default: return "";
            }
        }
        catch(Exception e)
        { return "Arguments are not numbers!";}
    }
}