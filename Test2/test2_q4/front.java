package test2_q4;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.Character;

public class front {
	
	public final static int LETTER = 0;
	public final static int DIGIT = 1;
	public final static int UNKNOWN = 99;

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
    
	public static void main(final String[] args) {
		try {
			inFp = new RandomAccessFile("front.in", "r");
			getChar();
			do {
				lex();
			} while(nextToken != EOF);
		} catch(final IOException ex) {
			inFp = null;
			System.out.println("ERROR - cannot open front.in ");
		}
    	}

    	public static int lookup(final byte ch) {
		switch(ch) {
		case '(':
			addChar();
			nextToken = LEFT_PAREN;
			break;
		case ')':
			addChar();
			nextToken = RIGHT_PAREN;
			break;
		case '+':
			addChar();
			nextToken = ADD_OP;
			break;
		case '-':
			addChar();
			nextToken = SUB_OP;
			break;
		case '*':
			addChar();
			nextToken = MULT_OP;
			break;
		case '/':
			addChar();
			nextToken = DIV_OP;
			break;
		default:
			addChar();
			nextToken = EOF;
			break;
		}
		return nextToken;
	}

	public static void addChar() {
		if (lexLen <= 98) {
			lexeme[lexLen++] = nextChar;
			lexeme[lexLen] = '\0';
		} else {
			System.out.println("Error - lexeme is too long ");
		}
    	}
    
	public static void getChar() {
		try {
			if((nextChar = (byte)inFp.read()) != EOF) {
				if(Character.isLetter(nextChar) != false) {
					charClass = LETTER;
				} else if(Character.isDigit(nextChar) != false) {
					charClass = DIGIT;
				} else {
					charClass = UNKNOWN;
				}
			} else {
				charClass = EOF;
			}
		} catch(final IOException ex) {
			throw new RuntimeException(ex);
		}
	}
    
	public static void getNonBlank() {
		while(Character.isWhitespace(nextChar) != false) {
			getChar();
		}
    	}
    
    	public static int lex() {
		lexLen = 0;
		getNonBlank();
		switch(charClass) {
        
        case LETTER:
			addChar();
			getChar();
			while(charClass == LETTER || charClass == DIGIT) {
				addChar();
				getChar();
			}
			nextToken = IDENT;
			break;

		case DIGIT:
			addChar();
			getChar();
			while(charClass == DIGIT) {
				addChar();
				getChar();
			}
			nextToken = INT_LIT;
			break;

		case UNKNOWN:
			lookup(nextChar);
			getChar();
			break;

		case EOF:
			nextToken = EOF;
			lexeme[0] = 'E';
			lexeme[1] = 'O';
			lexeme[2] = 'F';
			lexeme[3] = '\0';
			break;
		}

		System.out.println("Next token is: " + nextToken + ", Next lexeme is " + lexeme);
		return nextToken;
	}
}
