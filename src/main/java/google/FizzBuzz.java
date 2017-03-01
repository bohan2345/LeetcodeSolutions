package google;

/**
 * <p>
 * Created by Bohan Zheng on 7/1/16.
 *
 * @author Bohan Zheng
 */
public class FizzBuzz {
  /**
   * This program plays the game "Fizzbuzz".  It counts to 100, replacing each
   * multiple of 5 with the word "fizz", each multiple of 7 with the word "buzz",
   * and each multiple of both with the word "fizzbuzz".  It uses the modulo
   * operator (%) to determine if a number is divisible by another.
   **/
  public static void main(String[] args) {
    for (int i = 1; i <= 100; i++) {                     // count from 1 to 100
      if (((i % 5) == 0) && ((i % 7) == 0))            // A multiple of both?
        System.out.print("fizzbuzz");
      else if ((i % 5) == 0) System.out.print("fizz"); // else a multiple of 5?
      else if ((i % 7) == 0) System.out.print("buzz"); // else a multiple of 7?
      else System.out.print(i);                        // else just print it
      System.out.print(" ");
    }
    System.out.println();
  }
}
