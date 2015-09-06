class BinaryOperators
{
    static String evalOperation(String operation, String operand_1,String operand_2)
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
            default: return "";
        }
    }
}