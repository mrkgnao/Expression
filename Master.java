import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Master
{
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    
    public static void main() throws IOException
    {
        try
        { Constants.load(); }
        
        catch(Exception e)
        { System.out.println("Error loading constants.txt. Make sure it is written in proper syntax."); return; }
        
        System.out.println("Expression Evaluator v3.0");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Type help to get help on the various functions and operators.");
        System.out.println("Have fun. :-)");
        System.out.println("-------------------------------------------------------------------");
        
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
                else if(response.indexOf("=")!=-1 && response.indexOf("==")==-1 && response.indexOf("!=")==-1)
                set(response);
                else if(response.equalsIgnoreCase("help"))
                help();
                else
                System.out.println(format(Evaluate.eval(response)));
            }
            catch(Exception e)
            {
                System.out.println("Parse Error. :-(");
                System.out.println("Could not detect error. Check the expression.");
            }
        }
        
        System.out.println("-------------------------------------------------------------------\nHope your homework is finished by now. :-)");
        Constants.constants.set(0,new String[]{"ans","0"});
        Constants.constants.remove(0);
        Constants.write();
    }
    
    static String format(String s) //to make integer ouptuts look pretty.
    {
        if(s.endsWith(".0"))
        s=s.substring(0,s.length()-2);
        
        if(s.equals("-0"))
        s="0";
        
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
    
    static void help() throws IOException
    {
        System.out.println("What do you want help with?");
        System.out.print("1. Functions, 2. Operators, 3. Constants, 4. Order of operations :");
        
        switch(br.readLine().charAt(0))
        {
            case '1': System.out.println("\nFunction with syntax\t\t\tPurpose\n-------------------------------------------------------------------");
                      for(String[] k:Functions.list)
                      System.out.format("%1$-25s %2$s %n",k[0],k[1]);
                      break;
                      
            case '2': System.out.println("\nOperator with syntax\t\t\tPurpose\n-------------------------------------------------------------------");
                      for(String[] k:BinaryOperators.list)
                      System.out.format("%1$-25s %2$s %n",k[0],k[1]);
                      break;
                      
            case '3': System.out.println("\nConstants are stored in the file constants.txt in the same directory as the parent.");
                      System.out.println("If the file does not exist when the program is started, a blank one will be created.");
                      System.out.println("To set a constant to a value, type <constant>==<value>. Ex: m==2 or pi==3.");
                      System.out.println("To delete a constant, set its value to 0.");
                      System.out.println("The ans constant stores the previous answer.");
                      System.out.println("The following constants are available with their corresponding values.");
                      
                      System.out.println("\nConstant\tValue\n-------------------------------------------------------------------");
                      for(String[] k:Constants.constants)
                      System.out.println(k[0]+"\t\t"+k[1]);
                      break;
                    
            case '4': System.out.println("\nThe order of operations are as follows:");
                      System.out.println("1.Brackets, 2.Functions, 3.Exponents, 4.Multiplication/Division 5.Addition/Subtraction\n");
                      break;
                     
            default: System.out.println("Invalid choice.");
        }
    }
}
