/**
 * This method checks if a given string is a pangram. A pangram is a sentence that contains every single 
 * letter of the English alphabet (A-Z) at least once, regardless of case. Numbers, punctuation, and 
 * spaces should be ignored while checking for the presence of each letter.
 * Example:
 *  - isPangram("The quick brown fox jumps over the lazy dog") will return true, as it contains every 
 *  letter from A-Z.
 *  - isPangram("Hello World") will return false, as it does not contain every letter of the alphabet.
 * 
 * @param sentence A string that needs to be checked for being a pangram.
 * @return true if the string is a pangram, false otherwise.
 * ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- -----
 * ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- ----- -----
 * Este método verifica se uma string dada é um pangrama. Um pangrama é uma frase que contém todas as letras 
 * do alfabeto inglês (A-Z) pelo menos uma vez, independentemente da capitalização. Números, pontuação e 
 * espaços devem ser ignorados ao verificar a presença de cada letra.
 * Exemplo:
 *  - isPangram("The quick brown fox jumps over the lazy dog") retornará verdadeiro, pois contém todas as 
 *  letras de A-Z.
 *  - isPangram("Hello World") retornará falso, pois não contém todas as letras do alfabeto.
 * 
 * @param frase A string que precisa ser verificada para determinar se é um pangrama.
 * @return verdadeiro se a string for um pangrama, falso caso contrário.
 * https://www.codewars.com/kata/545cedaa9943f7fe7b000048/train/java
 */

package katas.rank.kyu6;

import java.util.Set;
import java.util.stream.Collectors;

public class PangramChecker {
	public static boolean check(String sentence){
		Set<Character> pangram = sentence
									.toLowerCase()
									.replaceAll("\\s+", "")
									.replaceAll("\\p{P}+", "")
									.replaceAll("\\d+", "")
									.trim()
									.chars()
									.mapToObj(c -> (char) c).collect(Collectors.toSet() );
		return pangram.size() == 26 ? true : false;
	}
	
    boolean check_2(final String sentence) {
        return sentence.chars()
            .filter(Character::isLetter)
            .map(Character::toLowerCase)
            .distinct()
            .count() == 26;
    }
    
    
    
}
