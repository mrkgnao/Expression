import java.util.ArrayList;

class Evaluate
{
    static String eval(ArrayList<String> list)
    {
        //empty inputs
        if(list.size()==0)
        return "";
        
        //substitute constants
        for(int i=0; i<list.size(); i++)
        for(int j=0; j<Constants.constants.size(); j++)
        if( list.get(i).equals(Constants.constants.get(j)[0]) )
        list.set(i,Constants.constants.get(j)[1]);
            
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
            
            if(i!=-1 && j==-1) {j=list.size(); list.add(")");}
            if(j<i || (i==-1 && j!=-1)) return "Unmatching brackets.";
            
            if(i!=-1)
            {
                String ans=eval(new ArrayList<String> (list.subList(i+1,j)));
                if(Character.isLetter(ans.charAt(0)))
                return ans;
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
                if((Character.isLetter(list.get(k).charAt(0)) || list.get(k).equals("-")) && !list.get(k).equals("E"))
                {i=k; break;}
            }
            
            if(i!=-1)
            {
                String ans=Functions.evalFunction(list.get(i),list.get(i+1));
                if(Character.isLetter(ans.charAt(0)))
                return ans;
                list.remove(i+1);
                list.set(i,ans);
            }
            else
            break;
        }
        
        //manage binary operations
        int i=0;
        while(i!=BinaryOperators.operators.length())
        {
            int j=-1;
            for(int k=0;k<list.size();k++)
            {
                if(list.get(k).equals(""+BinaryOperators.operators.charAt(i)))
                {j=k; break;}
            }
            
            if(j!=-1)
            {
                String ans=BinaryOperators.evalOperation(list.get(j),list.get(j-1),list.get(j+1));
                if(Character.isLetter(ans.charAt(0)))
                return ans;
                list.remove(j); list.remove(j);
                list.set(j-1,ans);
            }
            else
            i++;
        }
        
        Constants.constants.set(0, new String[]{"ans",list.get(0)});
        return list.get(0);
    }
    
    static String eval(String s)
    { return eval(Tokenizer.tokenize(s)); }
}