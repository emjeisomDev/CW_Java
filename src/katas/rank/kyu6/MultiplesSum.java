/**
 * The <see cref="MultiplesSum"/> class provides a method to calculate the sum of all natural numbers 
 * below a given number that are multiples of 3 or 5. The method ensures that if a number is a multiple 
 * of both 3 and 5, it is only counted once.
 * 
 * For example, for the input number 10, the multiples of 3 and 5 below 10 are 3, 5, 6, and 9. 
 * The sum of these multiples is 23.
 * The method should return the sum of all multiples of 3 or 5 below the given number.
 * 
 * Example:
 *  - multiplesSum(10) will return 23.
 *  - multiplesSum(20) will return 78.
 * 
 * @param number The upper limit (exclusive) below which the sum of multiples of 3 or 5 will be calculated.
 * @return The sum of all the multiples of 3 or 5 below the given number.
 * -------------------------------------------------------------------------------------------------------------
 * -------------------------------------------------------------------------------------------------------------
 * A classe <see cref="SomaMultiplos"/> fornece um método para calcular a soma de todos os números naturais 
 * abaixo de um número dado que são múltiplos de 3 ou 5. O método garante que, se um número for múltiplo de 
 * 3 e 5, ele será contado apenas uma vez.
 * 
 * Por exemplo, para o número 10, os múltiplos de 3 e 5 abaixo de 10 são 3, 5, 6 e 9. A soma desses múltiplos 
 * é 23.
 * O método deve retornar a soma de todos os múltiplos de 3 ou 5 abaixo do número fornecido.
 * 
 * Exemplo:
 *  - somaMultiplos(10) retornará 23.
 *  - somaMultiplos(20) retornará 78.
 * 
 * @param numero O limite superior (exclusivo) abaixo do qual será calculada a soma dos múltiplos de 3 ou 5.
 * @return A soma de todos os múltiplos de 3 ou 5 abaixo do número fornecido.
 * https://www.codewars.com/kata/514b92a657cdc65150000006/train/java
 */

package katas.rank.kyu6;

import java.util.stream.IntStream;

public class MultiplesSum {
	
	public static int solution(int number) {
		return IntStream.range(0, number)
				        .filter(i -> i % 3 == 0 || i % 5 == 0)
				        .sum();
	}
	
	public static int solution2(int number) {
		int sumResult = 0;
		for (int i = 0; i < number; i++) {
			
			if (i % 3 == 0 || i % 5 == 0) {
				sumResult += i;
			}
			
		}
		return sumResult;
	}
}
