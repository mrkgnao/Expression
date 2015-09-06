import java.util.ArrayList;

class Evaluate
{
    static String eval(ArrayList<String> list)
    {
        //manage brackets
        while(true)
        {
            int i=-1,j=-1;
            for(int k=0;k<list.size();k++)
            {
                if(list.get(k).equals("("))
                i=k;
                if(list.get(k).equals(")"))
                { j=k; break;}
            }
            
            if(j!=-1)
            {
                String ans=eval(new ArrayList<String> (list.subList(i+1,j)));
                list.subList(i+1,j+1).clear();
                list.set(i,ans);
            }
            else
            break;      
        }
        
        //manage functions
        while(true)
        {
            int i=-1;
            for(int k=list.size()-1;k>=0;k--)
            {
                if(Character.isLetter(list.get(k).charAt(0)) || list.get(k).equals("-"))
                {i=k; break;}
            }
                
            if(i!=-1)
            {
                String ans=Functions.evalFunction(list.get(i),list.get(i+1));
                list.remove(i+1);
                list.set(i,ans);
            }
            else
            break;
        }
        
        //manage binary operations
        String operators="^/*_+,";
        int i=0;
        while(i!=operators.length())
        {
            int j=-1;
            for(int k=0;k<list.size();k++)
            {
                if(list.get(k).equals(""+operators.charAt(i)))
                {j=k; break;}
            }
            
            if(j!=-1)
            {
                String ans=BinaryOperators.evalOperation(list.get(j),list.get(j-1),list.get(j+1));
                list.remove(j); list.remove(j);
                list.set(j-1,ans);
            }
            else
            i++;
        }
        return list.get(0);
    }
    
    static String eval(String s)
    { return eval(Tokenizer.tokenize(s)); }
}