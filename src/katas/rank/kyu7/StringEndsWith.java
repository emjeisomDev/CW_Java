/**
 * The <see cref="StringEndsWith"/> class provides a method to check if a given string ends with a specified 
 * suffix.
 * The method takes two string arguments: the first string is the one to be checked, and the second string is 
 * the suffix to be compared with the end of the first string. The method will return true if the first string 
 * ends with the second string, and false otherwise.
 * 
 * Example:
 *  - solution("abc", "bc") returns true because "abc" ends with "bc".
 *  - solution("abc", "d") returns false because "abc" does not end with "d".
 * 
 * @param input The main string to be checked.
 * @param suffix The suffix to be compared with the end of the input string.
 * @return true if the input string ends with the suffix; false otherwise.
 * --------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------
 * A classe <see cref="StringTerminaCom"/> fornece um método para verificar se uma string dada termina com 
 * um sufixo especificado.
 * O método recebe dois argumentos do tipo string: a primeira string é a que será verificada, e a segunda 
 * string é o sufixo que será comparado com o final da primeira string. O método retornará true se a primeira 
 * string terminar com o sufixo, e false caso contrário.
 * 
 * Exemplo:
 *  - solution("abc", "bc") retorna true porque "abc" termina com "bc".
 *  - solution("abc", "d") retorna false porque "abc" não termina com "d".
 * 
 * @param entrada A string principal a ser verificada.
 * @param sufixo O sufixo a ser comparado com o final da string de entrada.
 * @return true se a string de entrada terminar com o sufixo; false caso contrário.
 * https://www.codewars.com/kata/51f2d1cafc9c0f745c00037d/train/java
 */

package katas.rank.kyu7;

import java.util.stream.IntStream;

public class StringEndsWith {
	
	  public static boolean solution(String str, String ending) {
		    return str.endsWith(ending);
		  }
	
	public static boolean solution2(String str, String ending) {
	    if(ending.length() > str.length()){
	        return false;
	      }
	    int endingStartIndex  = str.length() - ending.length();
		return IntStream
				.range(endingStartIndex , str.length())
				.allMatch(i -> str.charAt(i) == ending.charAt(i  - endingStartIndex ));
	}
	
	public static boolean solution3(String str, String ending) {
		int gapLength = str.length() - ending.length();
		char[] newStr = str.toCharArray();
		char[] newEnding = ending.toCharArray();
		
	    if(ending.length() > str.length()){
	        return false;
	      }
		
		for (int i = 0; i < ending.length(); i++) {
			if (newStr[i + gapLength] != newEnding[i]) {
				return false;
			}
		}
		return true;
	}
}
