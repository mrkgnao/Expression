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
                case '/': return ""+(a/b);
                case '^': return ""+(Math.pow(a,b));
                case ',': return ""+a+","+b;
                case 'E': return ""+a*Math.pow(10,b);
                case '!': int p=1;
                          for(int i=1;i<=a;i++)
                          p*=i;
                          return ""+p;
                default: return "";
            }
        }
        catch(Exception e)
        {
            return operand_1+operation+operand_2;
        }
    }
}