import java.util.ArrayList;
class Tokenizer
{       
    static ArrayList<String> list=new ArrayList<String> ();
    
    enum States
    {
        NULL,LEFT_BRACKET,RIGHT_BRACKET,NUMBER,FUNCTION,OPERATOR;
    }
    
    static String simplify(String s)        //make the string suitable
    {
        String temp="";
        
        //remove spaces
        s=s.replaceAll(" ","");
        
        //for factorials
        s=s.replaceAll("!","!0");
        
        //take account for implied multiplication
        temp+=s.charAt(0);
        for(int i=1;i<s.length();i++)
        {
            char c=s.charAt(i);
            char d=s.charAt(i-1);
            
            if(  (c=='(' && Character.isDigit(d)) ||
                 (Character.isLetter(c) && c!='E' && (Character.isDigit(d) || d==')')) ||
                 (Character.isDigit(c) && (d==')' || Character.isLetter(d) && d!='E'))  )
            temp+="*";
            
            temp+=c;
        }
        s=temp; temp="";
        
        //take account for implied addition
        temp+=s.charAt(0);
        for(int i=1;i<s.length();i++)
        {
            char c=s.charAt(i);
            char d=s.charAt(i-1);
            
            if(c=='-' && "+*^/,E!(".indexOf(d)==-1)
            {temp+="_"; continue;}
            
            temp+=c;
        }
        s=temp; temp="";
        
        return s;
    }
    
    static ArrayList<String> tokenize(String s)
    {
        list.clear();
        s=simplify(s);
        States Old_State=States.NULL;
        States State=States.NULL;
        String temp="";
        
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(c=='(')
            { State=States.LEFT_BRACKET; add(temp); temp="";}
            else if(c==')')
            { State=States.RIGHT_BRACKET; add(temp); temp="";}
            else if((Character.isLetter(c) && c!='E') || c=='-')
            State=States.FUNCTION;
            else if("+_*/E,^!".indexOf(c)!=-1)
            State=States.OPERATOR;
            else
            State=States.NUMBER;
            
            if(Old_State!=State)
            {
                add(temp); temp=""+c;
            }
            else
            temp+=c;
            
            Old_State=State;
        }
        
        add(temp);
        return list;
    }
    
    static void add(String token)
    {
        if(token.length()!=0)
        list.add(token);
    }
}