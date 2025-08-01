/**
 * This class provides two functions: one to convert a Roman numeral to an integer and another 
 * to convert an integer to a Roman numeral.
 * Modern Roman numerals are written by expressing each digit separately, starting with the 
 * leftmost digit and skipping any digit with a value of zero.
 * The Roman numeral system uses letters like M, D, C, L, X, V, and I to represent values. 
 * The numeral is constructed from left to right, with smaller values placed before larger ones 
 * to indicate subtraction (e.g., IV for 4, IX for 9).
 * 
 * The input range for the integer is between 1 and 3999 inclusive.
 * 
 * Example usage:
 *  - toRoman(2000) returns "MM".
 *  - toRoman(1666) returns "MDCLXVI".
 *  - toRoman(86) returns "LXXXVI".
 *  - toRoman(1) returns "I".
 * 
 *  - fromRoman("MM") returns 2000.
 *  - fromRoman("MDCLXVI") returns 1666.
 *  - fromRoman("LXXXVI") returns 86.
 *  - fromRoman("I") returns 1.
 * 
 * Roman Numeral Mapping:
 * +--------+-------+
 * | Symbol | Value |
 * +--------+-------+
 * |    M   |  1000 |
 * |   CM   |   900 |
 * |    D   |   500 |
 * |   CD   |   400 |
 * |    C   |   100 |
 * |   XC   |    90 |
 * |    L   |    50 |
 * |   XL   |    40 |
 * |    X   |    10 |
 * |   IX   |     9 |
 * |    V   |     5 |
 * |   IV   |     4 |
 * |    I   |     1 |
 * +--------+-------+
 * 
 * @param n The integer to be converted to Roman numeral.
 * @param roman The Roman numeral string to be converted to an integer.
 * @return The corresponding integer value for the Roman numeral or the Roman numeral for the 
 * integer value.
 * ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- 
 * ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- 
 * Esta classe fornece duas funções: uma para converter um número romano em um inteiro e outra para 
 * converter um inteiro em um número romano.
 * Os números romanos modernos são escritos expressando cada dígito separadamente, começando pelo 
 * dígito mais à esquerda e ignorando qualquer dígito com valor zero.
 * O sistema de numerais romanos usa letras como M, D, C, L, X, V e I para representar valores. 
 * O numeral é construído da esquerda para a direita,
 * com valores menores colocados antes de valores maiores para indicar subtração (exemplo: 
 * IV para 4, IX para 9).
 * 
 * O intervalo de entrada para o número inteiro é entre 1 e 3999 inclusivo.
 * 
 * Exemplos de uso:
 *  - toRoman(2000) retorna "MM".
 *  - toRoman(1666) retorna "MDCLXVI".
 *  - toRoman(86) retorna "LXXXVI".
 *  - toRoman(1) retorna "I".
 * 
 *  - fromRoman("MM") retorna 2000.
 *  - fromRoman("MDCLXVI") retorna 1666.
 *  - fromRoman("LXXXVI") retorna 86.
 *  - fromRoman("I") retorna 1.
 * 
 * Mapeamento de Números Romanos:
 * +--------+-------+
 * | Símbolo | Valor |
 * +--------+-------+
 * |    M   |  1000 |
 * |   CM   |   900 |
 * |    D   |   500 |
 * |   CD   |   400 |
 * |    C   |   100 |
 * |   XC   |    90 |
 * |    L   |    50 |
 * |   XL   |    40 |
 * |    X   |    10 |
 * |   IX   |     9 |
 * |    V   |     5 |
 * |   IV   |     4 |
 * |    I   |     1 |
 * +--------+-------+
 * 
 * @param n O inteiro a ser convertido para número romano.
 * @param roman A string do número romano a ser convertida para um inteiro.
 * @return O valor inteiro correspondente ao número romano ou o número romano correspondente ao valor 
 * inteiro.
 * https://www.codewars.com/kata/51b66044bce5799a7f000003/train/csharp
 */
/**
 * public static String toRoman(int n)
 * Converte um número inteiro para um número romano.
 * @param n O inteiro a ser convertido.
 * @return A representação do número romano do inteiro.
*/
/**
 * public static int fromRoman(String romanNumeral)
 * Converte uma string de número romano para um inteiro.
 * @param roman A string do número romano a ser convertida.
 * @return O valor inteiro do número romano.
*/

package katas.rank.kyu4;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumerals {
	
	public static String toRoman(int n) {
		
		StringBuilder romanNumber = new StringBuilder();
		var romanRef = romanRef();
		
		for (String key: romanRef.keySet()) {
			while (n >= romanRef.get(key)) {
				n-=romanRef.get(key);
				romanNumber.append(key);
			}
		}
		return romanNumber.toString();
	}
	
	
	public static int fromRoman(String romanNumeral) {
		
		long result = 0;
		var decNum = romanNumeral.chars()
				                 .mapToLong(r -> romanRef().get(String.valueOf((char) r)))
				                 .boxed()
				                 .mapToLong(Long::longValue)
				                 .toArray();
		
		if (decNum.length >= 1) { result = decNum[decNum.length - 1]; }
		
		for (int i = 0; i < (decNum.length - 1); i++) {
            if (decNum[i] >= decNum[i + 1])
            {
                result += decNum[i];
            }
            else
            {
                result -= decNum[i];
            }
		}
		
		return (int) result;
	}
	
	private static Map<String, Integer> romanRef() {
	    return new LinkedHashMap<>(Map.ofEntries(
	        Map.entry("M",  1000),
	        Map.entry("CM", 900),
	        Map.entry("D",  500),
	        Map.entry("CD", 400),
	        Map.entry("C",  100),
	        Map.entry("XC", 90),
	        Map.entry("L",  50),
	        Map.entry("XL", 40),
	        Map.entry("X",  10),
	        Map.entry("IX", 9),
	        Map.entry("V",  5),
	        Map.entry("IV", 4),
	        Map.entry("I",  1)
	    ));
	}
	
	
}
