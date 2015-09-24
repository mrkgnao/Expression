import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Master
{
    public static void main() throws IOException
    {
        try
        { Constants.load(); }
        
        catch(Exception e)
        { System.out.println("Error loading constants.txt. Make sure it is written in proper syntax."); return; }
        
        System.out.println("Expression Evaluator v2.1");
        System.out.println("-------------------------");
        System.out.println("Order of operations:");
        System.out.println("1.Brackets, 2.Functions, 3.Exponents, 4.Multiplication/Division 5.Addition/Subtraction\n");
        System.out.println("Supported Functions:");
        
        
        
        for(String k:Functions.list)
        System.out.print(k+", ");
        
        System.out.println("\n\nSupported Constants:");
        
        for(String[] k:Constants.constants)
        System.out.print(k[0]+", ");
        
        System.out.println("\n\nHave fun.\n-----------------------");
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String response="";
        while(true)
        {
            System.out.print("\n>>> ");
            try
            {
                response=br.readLine();
                
                if(response.length()==0)
                continue;
                
                if((response.equalsIgnoreCase("exit") || response.equalsIgnoreCase("quit")))
                break;
                else if(response.indexOf("=")!=-1)
                set(response);
                else
                System.out.println(format(Evaluate.eval(response)));
            }
            catch(Exception e)
            {
                System.out.println("Parse Error. :-(");
                System.out.println("Could not detect error. Check the expression.");
            }
        }
        
        System.out.println("----------------------------\nHope your homework is finished by now. :-)");
        Constants.constants.set(0,new String[]{"ans","0"});
        Constants.write();
    }
    
    static String format(String s) //to make integer ouptuts look pretty.
    {
        if(s.endsWith(".0"))
        s=s.substring(0,s.length()-2);
        
        return s;
    }
    
    static void set(String s)
    {
        String variable=s.substring(0,s.indexOf("="));
        String value=s.substring(s.indexOf("=")+1);
        
        int pos=-1;
        
        for(int i=0;i<Constants.constants.size();i++)
        if(Constants.constants.get(i)[0].equals(variable)) {pos=i; break;}
        
        if(value.equals("0"))
        {
            if(pos!=-1)
            {
                Constants.constants.remove(pos);
                System.out.println(variable+" deleted.");
            }
            return;
        }
        
        if(pos!=-1)
        Constants.constants.set(pos,new String[]{variable,value});
        else
        Constants.constants.add(new String[]{variable, value});
        
        System.out.println("Constant "+variable+" set to "+value+".");
    }
}