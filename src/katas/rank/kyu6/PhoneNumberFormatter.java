/**
 * The <see cref="PhoneNumberFormatter"/> class provides a method to format an array of 10 integers into a 
 * phone number string.
 * The integers in the array represent the digits of a phone number, and the method formats them into the 
 * standard phone number format: "(xxx) xxx-xxxx", where each "x" is replaced with the corresponding digit 
 * from the array.
 * 
 * Example:
 *  - createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}) will return "(123) 456-7890".
 * 
 * @param numbers An array of 10 integers representing the digits of the phone number.
 * @return A formatted phone number string in the format "(xxx) xxx-xxxx".
 * -------------------------------------------------------------------------------------------------------------
 * -------------------------------------------------------------------------------------------------------------
 * A classe <see cref="FormatadorDeTelefone"/> fornece um método para formatar um array de 10 inteiros em 
 * uma string de número de telefone.
 * Os inteiros no array representam os dígitos de um número de telefone, e o método os formata no formato 
 * padrão de número de telefone "(xxx) xxx-xxxx", onde cada "x" é substituído pelo dígito correspondente 
 * do array.
 * 
 * Exemplo:
 *  - createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}) retornará "(123) 456-7890".
 * 
 * @param numeros Um array de 10 inteiros representando os dígitos do número de telefone.
 * @return Uma string formatada do número de telefone no formato "(xxx) xxx-xxxx".
 */

package katas.rank.kyu6;

public class PhoneNumberFormatter {
	
    /**
     * Formata um array de 10 inteiros em uma string de número de telefone.
     * 
     * @param numeros Um array de 10 inteiros, cada um entre 0 e 9, representando os dígitos do número 
     * de telefone.
     * @return Uma string representando o número de telefone no formato "(xxx) xxx-xxxx".
     */
	public static String createPhoneNumber(int[] numbers) {
		
		StringBuilder phone = new StringBuilder();
		phone.append("(");
		
		for (int i = 0; i < numbers.length; i++) {
			phone.append(numbers[i]);
			if (i == 2) {
				phone.append(") ");
			}
			
			if (i == 5) {
				phone.append("-");
			}
		}
		
		return phone.toString();
	}
}
