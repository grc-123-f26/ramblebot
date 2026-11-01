import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A tokenizer that converts text input to lowercase and splits it 
 * into a list of tokens, where each token is either a word or a period.
 */
public class LowercaseSentenceTokenizer implements Tokenizer {
  /**
   * Tokenizes the text from the given Scanner. The method should 
   * convert the text to lowercase and split it into words and periods.
   * Words are separated by spaces, and periods are treated as separate tokens.
   * 
   * For example:
   * If the input text is: "Hello world. This is an example."
   * The tokenized output should be: ["hello", "world", ".", "this", "is", "an", "example", "."]
   * 
   * Notice that the text is converted to lowercase, and each period is treated as a separate token.
   * 
   * However, a period should only be considered a separate token if it occurs at the end
   * of a word. For example:
   * 
   * If the input text is: "Hello world. This is Dr.Smith's example."
   * The tokenized output should be: ["hello", "world", ".", "this", "is", "dr.smith's", "example", "."]
   * 
   * The internal period in Dr.Smith's is not treated as its own token because it does not occur at the end of the word.
   * 
   * @param scanner the Scanner to read the input text from
   * @return a list of tokens, where each token is a word or a period
   */
  public List<String> tokenize(Scanner scanner) {
    List<String> tokens = new ArrayList<>();

    while (scanner.hasNext()) {
      String token = scanner.next();
      String lowerCaseToken = token.toLowerCase();

      // Split the token into its individual characters and store them in a char array, tokenChars
      char[] tokenChars = lowerCaseToken.toCharArray();

      // Check if the last character of the token is a period. 
      // If so, add the original token without the period and add the period as a separate token
      // Otherwise, add the token like normal
      if (tokenChars[tokenChars.length - 1] == '.') {
        String tokenWithoutPeriod = "";

        for (int i = 0; i < tokenChars.length - 1; i++) {
          tokenWithoutPeriod += tokenChars[i];
        }
        
        tokens.add(tokenWithoutPeriod);
        tokens.add(".");
      } else { 
        tokens.add(lowerCaseToken);
      }
    } 

    return tokens;
  }
}

