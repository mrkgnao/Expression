class BinaryOperators
{
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
                case '=': return a==b?"1":"0";
                case '<': return a<b?"1":"0";
                case '>': return a>b?"1":"0";
                case '~': return a!=b?"1":"0";
                case '&': return (a==1)&&(b==1)?"1":"0";
                case '|': return (a==1)||(b==1)?"1":"0";
                default: return "";
            }
        }
        catch(Exception e)
        { return "Arguments are not numbers!";}
    }
}