import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Master
{
    public static void main() throws IOException
    {
        System.out.println("Expression Evaluator v1.0");
        System.out.println("-------------------------");
        System.out.println("Order of operations:");
        System.out.println("1.Brackets, 2.Functions, 3.Exponents, 4.Multiplication/Division 5.Addition/Subtraction\n");
        System.out.println("Supported Functions: (Functions must be in lowercase.)");
        System.out.println("sqrt, exp, ln, sin, cos, tan, min, max, abs\n");
        System.out.println("Supported Constants: (Constants must in uppercase.)");
        System.out.println("PI, E, H, C");
        System.out.println("Have fun.\n-----------------------");
        
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
        
        System.out.println("Hope your homework is finished by now. :-)");
    }
}