/**
 * The <see cref="TribonacciSequence"/> class provides a method to generate a Tribonacci sequence, 
 * which is similar to the Fibonacci sequence, but sums the last 3 numbers (instead of 2) to generate 
 * the next number in the sequence. The method allows for custom initial values (signature) and 
 * generates the first 'n' numbers of the Tribonacci sequence based on that input.
 * 
 * Example:
 * If the signature is [1, 1, 1], the sequence starts as:
 * [1, 1, 1, 3, 5, 9, 17, 31, ...]
 * If the signature is [0, 0, 1], the sequence starts as:
 * [0, 0, 1, 1, 2, 4, 7, 13, 24, ...]
 * 
 * The method should return the first 'n' elements of the Tribonacci sequence, including the signature.
 * 
 * If 'n' equals 0, the method should return an empty array (or NULL in C).
 * 
 * @param signature A 3-element array that serves as the initial values of the Tribonacci sequence.
 * @param n The number of elements to return from the sequence, including the signature.
 * @return A list/array containing the first 'n' elements of the Tribonacci sequence.
 * ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- 
 * ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- 
 * A classe <see cref="SequenciaTribonacci"/> fornece um método para gerar uma sequência Tribonacci, 
 * que é semelhante à sequência Fibonacci, mas soma os últimos 3 números (em vez de 2) para gerar o 
 * próximo número na sequência. O método permite valores iniciais personalizados (assinatura) e gera 
 * os primeiros 'n' números da sequência Tribonacci com base nesse input.
 * 
 * Exemplo:
 * Se a assinatura for [1, 1, 1], a sequência começa como:
 * [1, 1, 1, 3, 5, 9, 17, 31, ...]
 * Se a assinatura for [0, 0, 1], a sequência começa como:
 * [0, 0, 1, 1, 2, 4, 7, 13, 24, ...]
 * 
 * O método deve retornar os primeiros 'n' elementos da sequência Tribonacci, incluindo a assinatura.
 * 
 * Se 'n' for igual a 0, o método deve retornar um array vazio (ou NULL em C).
 * 
 * @param assinatura Um array de 3 elementos que serve como os valores iniciais da sequência Tribonacci.
 * @param n O número de elementos a ser retornado da sequência, incluindo a assinatura.
 * @return Uma lista/array contendo os primeiros 'n' elementos da sequência Tribonacci.
 * https://www.codewars.com/kata/556deca17c58da83c00002db/train/java
 */

package katas.rank.kyu6;

import java.util.stream.Stream;

public class Xbonacci {
	public static double[] tribonacci(double[] s, int n) {
		return Stream.iterate(s, fib -> new double[] {
										fib[1], fib[2], fib[0] + fib[1] +  fib[2] } 
							  )
				.mapToDouble(fib -> fib[0])
				.limit(n)
				.toArray();
	}
	
	
	public static double[] fibonacci(double[] s, int n) {
		return Stream.iterate(s, fib -> new double[] {fib[1], fib[0] + fib[1] } )
							.mapToDouble(fib -> fib[0])
							.limit(n)
							.toArray();
		
	}
	
	public static double[] fibonacci_2(double[] s, int n) {
		
		if(s.length != 2) return new double[] {};
		
		double[] fibo = new double[n];
		
		fibo[0] = s[0];
		fibo[1] = s[1];
		double sum = fibo[0] + fibo[1];
		
		
		for (int i = 2; i < fibo.length; i++) {
			fibo[i] = sum;
			sum = fibo[i] + fibo[i-1];
		}
			
		return fibo;
	}
	
}
