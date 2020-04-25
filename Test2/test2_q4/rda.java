
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.Character;

public class rda {

    public final static int INT_LIT = 10;
    public final static int IDENT = 11;
    public final static int ASSIGN_OP = 20;
    public final static int ADD_OP = 21;
    public final static int SUB_OP = 22;
    public final static int MULT_OP = 23;
    public final static int DIV_OP = 24;
    public final static int LEFT_PAREN = 25;
    public final static int RIGHT_PAREN = 26;

	public final static int EOF = -1;

	public static int charClass;
	public static byte[] lexeme = new byte[100];
	public static byte nextChar;
	public static int lexLen;
	public static int token;
	public static int nextToken;
    public static RandomAccessFile inFp;
    
	public static void expr() {
		System.out.println("Enter <expr>");
		term();
		while(nextToken == ADD_OP || nextToken == SUB_OP) {
			lex();
			term();
		}
		System.out.println("Exit <expr>");
	}

	public static void term() {
		System.out.println("Enter <term>");
		factor();
		while(nextToken == MULT_OP || nextToken == DIV_OP) {
			lex();
			factor();
		}
		System.out.println("Exit <term>");
	}

	public static void factor() {
		
		System.out.println("Enter <factor>");

		if(nextToken == IDENT || nextToken == INT_LIT) {
			lex();

		} else if(nextToken == LEFT_PAREN) {
			
			lex();
			expr();
			
			if(nextToken == RIGHT_PAREN) {
				lex();
			} else {
				error();
			}

		} else {
			error();
		}

		System.out.println("Exit <factor>");
	}
}