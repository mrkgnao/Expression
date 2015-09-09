import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Master
{
    public static void main() throws IOException
    {
        System.out.println("Expression Evaluator v1.1");
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
                
                if(!(response.equalsIgnoreCase("exit") || response.equalsIgnoreCase("quit")))
                System.out.println(Evaluate.eval(response));
                else
                break;
                
            }
            catch(Exception e)
            {
                System.out.println("Parse Error. :-(");
                System.out.println("Check whether brackets were matching, legal functions were used and case conventions were followed.");
            }
        }
        
        System.out.println("----------------------------\nHope your homework is finished by now. :-)");
    }
}