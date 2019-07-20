import java.util.*;
import java.io.*;

class Translate{
	private Set<String> consonants;
	private Set<String> vowels;
	String []consonantsArr = {"b","c","d","f","g","h","j","k","l","m","n","p","q","r","s","t","v","w","x","y","z"};
	String []vowelsArr = {"a","e","i","o","u"};
	Translate(){
		this.consonants = new HashSet<String>(Arrays.asList(consonantsArr));
		this.vowels = new HashSet<String>(Arrays.asList(vowelsArr));
	}
	private String TranslateSingleWord(String word){
		boolean questionFlag = word.endsWith("?");
		int length = word.length() - ((questionFlag)?1:0);
		String firstLetter = Character.toString(word.charAt(0));
		if(this.vowels.contains(firstLetter)){
			return word + "way";
		}else{
			int count = 0;
			while(this.consonants.contains(firstLetter)){
				count++;
				if(count < length){
					firstLetter = Character.toString(word.charAt(count));
				}else{
					break;
				}
			}
			if(count > 0){
				StringBuffer translatedText = new StringBuffer();
				translatedText.append(word.substring(count,length));
				translatedText.append(word.substring(0,count));
				if(questionFlag){
					translatedText.append("ay?");
					return  translatedText.toString();
				}else{
					translatedText.append("ay");
					return translatedText.toString();
				}
				
			}else{
				return word;
			}
			
		}		
	}
	public String EnglishPhraseToPigLatin(String englishPhrase){
		String []words = englishPhrase.split(" ");
		StringBuffer translatedText = new StringBuffer();
		for(String word:words){
			translatedText.append(this.TranslateSingleWord(word.toLowerCase()));
			translatedText.append(" ");
		}
		return translatedText.toString();
	}
}


public class PigLatin{
	public static void main(String[] args){
		Translate translate = new Translate();
		Scanner scan = new Scanner(System.in);
		String phrase;
		System.out.println("Enter the phrase to translate: ");
		phrase = scan.nextLine();
		System.out.println(translate.EnglishPhraseToPigLatin(phrase));
		scan.close();
	}
}

