package myreflection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

//https://github.com/FabianM/brainfuck-java/blob/master/src/test/BrainfuckTest.java

/**
 * The {@link BrainfuckEngine} class is an implementation of the original <code>brainfuck</code>
 * 	language.
 * 
 * @author Fabian M.
 */
public class BrainfuckEngine {

	/**
	 * The memory thats available for this <code>brainfuck</code> program.
	 */
	protected int[] data;
//	protected byte[] data;

	/**
	 * The data pointer that points to the current index in the {@link BrainfuckEngine#data} memory array.
	 */
	protected int dataPointer = 0;

	/**
	 * The character pointer that points to the current index of the character array
	 * 	of value of its file or string.
	 */
	protected int charPointer = 0;

	/**
	 * The {@link BrainfuckEngine#fileReader} allows use to read from a file if one is specified.
	 */
	protected BufferedReader fileReader;

	/**
	 * The {@link BrainfuckEngine#consoleReader} allows us to read from the console for the ',' keyword.
	 */
	protected InputStreamReader consoleReader;

	/**
	 * The {@link BrainfuckEngine#outWriter} allows us to write to the console.
	 */
	protected OutputStream outWriter;

	/**
	 * The current line the engine is at.
	 */
	protected int lineCount = 0;

	/**
	 * The current column the engine is at. 
	 */
	protected int columnCount = 0;

	/**
	 * The {@link Token} class contains tokens in <code>brainfuck</code>.
	 * 
	 * @author Fabian M.
	 */
	
	String input=null;
	int Position=0;
	String output="";
	int maxsteps;
	int maxNumb;
	int step=0;
	
	
	protected static class Token {

		public final static char NEXT = '>';
		public final static char PREVIOUS = '<';
		public final static char PLUS = '+';
		public final static char MINUS = '-';
		public final static char OUTPUT = '.';
		public final static char INPUT = ',';
		public final static char BRACKET_LEFT = '[';
		public final static char BRACKET_RIGHT = ']';
		
	}

	/**
	 * Constructs a new {@link BrainfuckEngine} instance.
	 * 
	 * @param cells
	 *            The amount of memory cells.
	 */
	public BrainfuckEngine(int cells) {
		this(cells, new PrintStream(System.out), System.in);
	}

	/**
	 * Constructs a new {@link BrainfuckEngine} instance.
	 * 
	 * @param cells
	 *            The amount of mem
		interpret(content);ory cells.
	 * @param out The outputstream of this program.
	 */
	public BrainfuckEngine(int cells, OutputStream out) {
		this(cells, out, System.in);
	}

	/**
	 * Constructs a new {@link BrainfuckEngine} instance.
	 * 
	 * @param cells
	 *            The amount of memory cells.
	 * @param out The printstream of this program.
	 * @param in The outputstream of this program.
	 */
	public BrainfuckEngine(int cells, OutputStream out, InputStream in) {
		initate(cells);
		outWriter = out;
		consoleReader = new InputStreamReader(in); 
		maxNumb=Integer.MAX_VALUE;
	}
	
	//Saulius added funtion
	public BrainfuckEngine(int cells,int steps, String in) {
		initate(cells);
		input = in;
		maxsteps=steps;
		maxNumb=Integer.MAX_VALUE;
	}
	
	public BrainfuckEngine(int cells,int maxNumberValue,int steps, String in) {
		initate(cells);
		input = in;
		maxsteps=steps;
		maxNumb=maxNumberValue;
	}
	
	

	/**
	 * Initiate this instance.
	 */
	protected void initate(int cells) {
//		data = new byte[cells];
		data = new int[cells];
		dataPointer = 0;
		charPointer = 0;
	}


	/**
	 * Interprets the given file.
	 * 
	 * @param file
	 * 			  The file to interpret.
	 * @throws Exception  
	 */
	public void interpret(File file) throws Exception {
		fileReader = new BufferedReader(new FileReader(file));
		String content = "";
		String line = "";
		while((line = fileReader.readLine()) != null) {
			content += line;
			lineCount++;

		}

		interpret(content);
	}
	
	public static final char[] EXTENDED = { 0x00C7, 0x00FC, 0x00E9, 0x00E2,
        0x00E4, 0x00E0, 0x00E5, 0x00E7, 0x00EA, 0x00EB, 0x00E8, 0x00EF,
        0x00EE, 0x00EC, 0x00C4, 0x00C5, 0x00C9, 0x00E6, 0x00C6, 0x00F4,
        0x00F6, 0x00F2, 0x00FB, 0x00F9, 0x00FF, 0x00D6, 0x00DC, 0x00A2,
        0x00A3, 0x00A5, 0x20A7, 0x0192, 0x00E1, 0x00ED, 0x00F3, 0x00FA,
        0x00F1, 0x00D1, 0x00AA, 0x00BA, 0x00BF, 0x2310, 0x00AC, 0x00BD,
        0x00BC, 0x00A1, 0x00AB, 0x00BB, 0x2591, 0x2592, 0x2593, 0x2502,
        0x2524, 0x2561, 0x2562, 0x2556, 0x2555, 0x2563, 0x2551, 0x2557,
        0x255D, 0x255C, 0x255B, 0x2510, 0x2514, 0x2534, 0x252C, 0x251C,
        0x2500, 0x253C, 0x255E, 0x255F, 0x255A, 0x2554, 0x2569, 0x2566,
        0x2560, 0x2550, 0x256C, 0x2567, 0x2568, 0x2564, 0x2565, 0x2559,
        0x2558, 0x2552, 0x2553, 0x256B, 0x256A, 0x2518, 0x250C, 0x2588,
        0x2584, 0x258C, 0x2590, 0x2580, 0x03B1, 0x00DF, 0x0393, 0x03C0,
        0x03A3, 0x03C3, 0x00B5, 0x03C4, 0x03A6, 0x0398, 0x03A9, 0x03B4,
        0x221E, 0x03C6, 0x03B5, 0x2229, 0x2261, 0x00B1, 0x2265, 0x2264,
        0x2320, 0x2321, 0x00F7, 0x2248, 0x00B0, 0x2219, 0x00B7, 0x221A,
        0x207F, 0x00B2, 0x25A0, 0x00A0 };
	
	public static final char getAscii(int code) {
        if (code >= 0x80 && code <= 0xAD) {//code <= 0xFF
            return EXTENDED[code - 0x7E];
        }
        return (char) code;
    }
	
	public static final void printChar(int code) {
        System.out.printf("%c%n", getAscii(code));
    }

	/**
	 * Interprets the given string.
	 * 
	 * @param str
	 *            The string to interpret.
	 * @return 
	 * @throws Exception
	 */
	public String interpret(String str) throws Exception {
		Position=0;//input position
		step=0;//to avoid infinite loops
		for (; (charPointer < str.length()) && (step<=maxsteps); charPointer++) 
			interpret(str.charAt(charPointer), str.toCharArray());
		initate(data.length);
		return output;
	}

	/**
	 * Interprets the given char
	 * 
	 * @param c
	 *            The char to interpret.
	 * @throws Exception
	 */
	protected void interpret(char c, char[] chars) throws Exception {
		step++;
		switch (c) {
		case Token.NEXT:
			// increment the data pointer (to point to the next cell to the
			// right).
			if ((dataPointer + 1) > data.length) {
				throw new Exception("Error on line " + lineCount + ", column " + columnCount + ":" 
						+ "data pointer (" + dataPointer
						+ ") on postion " + charPointer + "" + " out of range.");
			}
			dataPointer++;
			break;
		case Token.PREVIOUS:
			// decrement the data pointer (to point to the next cell to the
			// left).
			if ((dataPointer - 1) < 0) {
				throw new Exception("Error on line " + lineCount + ", column " + columnCount + ":" 
						+ "data pointer (" + dataPointer
						+ ") on postion " + charPointer + " " + "negative.");
			}
			dataPointer--;
			break;
		case Token.PLUS:

			// increment (increase by one) the byte at the data pointer.
			
//			if ((((int) data[dataPointer]) + 1) > maxNumb) {
//				throw new Exception("Error on line " + lineCount + ", column " + columnCount + ":" 
//						+ "byte value at data pointer ("
//						+ dataPointer + ") " + " on postion " + charPointer
//						+ " higher than byte max value.");
//			}
//			data[dataPointer]++;
			data[dataPointer]=(++data[dataPointer])%(maxNumb+1);
//			System.out.println(data[dataPointer]);
			
			break;
		case Token.MINUS:
			// decrement (decrease by one) the byte at the data pointer.
//			if ((data[dataPointer] - 1) < 0) {
//				throw new Exception("Error on line " + lineCount + ", column " + columnCount + ":" 
//						+ "at data pointer " + dataPointer
//						+ " on postion " + charPointer
//						+ ": Value can not be lower than zero.");
//			}
			data[dataPointer]--;
			if (data[dataPointer]<0) data[dataPointer]=maxNumb;
//			data[dataPointer]=(--data[dataPointer])%(maxNumb+1);
			break;
		case Token.OUTPUT:
			// Output the byte at the current index in a character.
//			outWriter.write((char) data[dataPointer]);
//			output+=(char) data[dataPointer];
//			 System.out.printf("%c%n", getAscii(data[dataPointer]));
			int temmp=data[dataPointer];
			char temp=getAscii(temmp);
			
			System.out.print(temp); 
//			printChar((int) data[dataPointer]);
			
			
//			System.out.printf("%d %c%n", data[dataPointer],getAscii((int) data[dataPointer]));
			
//			output+=getAscii(data[dataPointer]);
			break;
		case Token.INPUT:
			// accept one byte of input, storing its value in the byte at the data pointer.
			//data[dataPointer] = (byte) consoleReader.read();
			
			if (Position>(input.length()-1)) Position=0;
			data[dataPointer] = (byte) input.charAt(Position);
			Position+=1;
			break;
		case Token.BRACKET_LEFT:
			if (data[dataPointer] == 0) {
				int i = 1;
				while (i > 0) {
					char c2 = chars[++charPointer];
					if (c2 == Token.BRACKET_LEFT)
						i++;
					else if (c2 == Token.BRACKET_RIGHT)
						i--;
				}
			}
			break;
		case Token.BRACKET_RIGHT:
			int i = 1;
			while (i > 0) {
				char c2 = chars[--charPointer];
				if (c2 == Token.BRACKET_LEFT)
					i--;
				else if (c2 == Token.BRACKET_RIGHT)
					i++;
			}
			charPointer--;
			break;
		}
		columnCount++;
	}
}