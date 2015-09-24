import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

class Constants
{
    static ArrayList<String[]> constants=new ArrayList<String[]> ();
    static File file=new File("Constants.txt");
    
    static void load() throws IOException
    {
        file.createNewFile();
        Scanner sc=new Scanner(new FileReader(file));
               
        while(sc.hasNext())
        constants.add(new String[]{sc.next(), sc.next()});
        
        sc.close();
        
        if(constants.size()==0)
        constants.add(new String[]{"ans","0"});
    }
    
    static void write() throws IOException
    {
        PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter(file,false)));
        
        for(String[] k:constants)
        out.println(k[0]+" "+k[1]);
        
        out.close();
    }
}