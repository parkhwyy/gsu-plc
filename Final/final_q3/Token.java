class Token {  
 
    public static final int SEMICOLON = 0; 
    public static final int COMMA = 1;
    public static final int NOT_EQ = 2;     
    public static final int ADD_OP = 3;   
    public static final int SUB_OP = 4;   
    public static final int MULT_OP = 5;   
    public static final int DIV_OP = 6;  
    public static final int MOD_OP = 7;
    public static final int ASSIGN_OP = 8;   
    public static final int EQ_OP = 9;
    public static final int GREATER_OP = 10;
    public static final int GREATER_EQ_OP = 11;
    public static final int LESSER_OP = 12;
    public static final int LESSER_EQ_OP = 13;
    public static final int LEFT_PAREN= 14;   
    public static final int RIGHT_PAREN= 15;   
    public static final int LEFT_BRACE= 16;   
    public static final int RIGHT_BRACE= 17;   
    public static final int ID = 18;   
    public static final int INT_LIT  = 19;
    public static final int KEY_IF = 20;
    public static final int KEY_INT = 21;
    public static final int KEY_ELSE = 22;
    public static final int KEY_WHILE = 23;
    
    private static String[] lexemes = {   
        ";", ",", "!=", "+", "-", "*", "/", "=", ">", "<", "(", ")", "{", "}", "id", "int_lit", "if", "int", "else", "while", "end"
    };   
    
    public static String toString (int i) {   
        if (i < 0 || i > KEY_WHILE)   
        return "";   
        else return lexemes[i];   
    }

} 
