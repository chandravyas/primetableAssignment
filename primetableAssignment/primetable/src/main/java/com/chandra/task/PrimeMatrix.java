package com.chandra.task;

import java.util.stream.Stream;

public class PrimeMatrix {

    public static final char WHITE_SPACE=' ';
    public static final int DEFAULT_NO_PRIMES=10;

    public static void main(String[] args) {

        int numberOfPrimes=0;

        // If the number of input args are 0 or more than 1 assign default value to the numberOfPrimes variable
        if(args.length==0 ) {
            System.out.println("No argument is entered so default value of "+ DEFAULT_NO_PRIMES +" is assigned ");
            numberOfPrimes = DEFAULT_NO_PRIMES;
            exampleFormatQueryString();

        }
        else if(args.length>1){
            System.out.println("Wrong number of arguments is entered so default value of "+ DEFAULT_NO_PRIMES +" is assigned ");
            numberOfPrimes = DEFAULT_NO_PRIMES;
            exampleFormatQueryString();
        }
        else
        {
            try {
                // If the number of input args is 1 then assign that value to numberOfPrimes variable
                numberOfPrimes = Integer.parseInt(args[0]);
                if (numberOfPrimes<=0)
                {
                    System.out.println("-ve integer or Zero argument value is not allowed so default value of "+ DEFAULT_NO_PRIMES +" is assigned ");
                    numberOfPrimes = DEFAULT_NO_PRIMES;
                    exampleFormatQueryString();
                }
            }
            catch (Exception e)
            {
                System.out.println("The input argument is not in correct format, it should always be an Integer");
                exampleFormatQueryString();
                System.exit(0);

            }
        }
        // Calculate the prime numbers of size numberOfPrimes
        int[] primes = getNPrimes(numberOfPrimes);

        // Create a table to store the table multiplication of prime numbers
        int[][] primeTable = new int[numberOfPrimes][numberOfPrimes];

        // Calculate the table multiplication of prime numbers
        for (int row = 0; row < numberOfPrimes; row++) {
            for (int column = 0; column < primes.length; column++) {
                primeTable[row][column] = primes[row] * primes[column];
            }
        }

        // print the formatted prime table
        printFormattedTable(primeTable,primes);

    }

    /**
     * Example query string shown to user to guide him
     */
    private static void exampleFormatQueryString()
    {

        System.out.println("************");
        System.out.println(" You should try to pass the argument in the below format");
        System.out.println("java -cp primetable-1.0-SNAPSHOT.jar com.chandra.task.PrimeMatrix <argument>");
        System.out.println("************");
    }

    /**
     * This function is responsible to print and format the prime multiplication table
     *
     * @param primeTable Calcualted table of prime numbers multiplication
     * @param primes contains array of primes of size numberOfPrimes
     */

    private static void printFormattedTable(int[][] primeTable,int[] primes)
    {
        // To calcualte the amount of padding needed
        int padding = 1 + Integer.toString(primes[primes.length - 1] * primes[primes.length - 1]).length();

        // Header of multiplication table
        System.out.printf("%s|", repeat(padding,WHITE_SPACE));
        for (int row = 0; row < primeTable.length; row++) {
            System.out.printf("%s", span(primes[row], padding));
        }
        System.out.printf("%n");

        // Padding separating the header with actual multiplication data
        int hrLine = padding * (primes.length + 1) + 1;
        System.out.println(repeat(hrLine, '-'));

        // Actual multiplication table data with formatting
        for (int row = 0; row < primeTable.length; row++) {

            System.out.printf("%s|", span(primes[row], padding));

            for (int column = 0; column < primeTable[0].length; column++) {
                System.out.printf("%s", span(primeTable[row][column], padding));
            }

            System.out.printf("%n");
        }
    }


    /**
     * Does left padding to number n using varible length
     *
     * @param n  number to be padded
     * @param length length of padding
     * @return left padded number
     */

    public static String span(int n, int length) {
        String txt = Integer.toString(n);
        int remLength = length - txt.length();

        StringBuilder padCharsLeft = new StringBuilder();
        for(int i=0;i<length;i++) {
            if (i < remLength)
                padCharsLeft.append(WHITE_SPACE);
            else
                padCharsLeft.append(txt.charAt(i - remLength));
        }
        return padCharsLeft.toString();

    }


    /**
     * This function creates a string of given length using character 'c'
     *
     * @param length length of the string to create
     * @param c character using which we have to create a string of given length
     * @return returns a string of given length using character 'c'
     */

    public static String repeat(int length, final char c) {
        StringBuilder repeatedChars = new StringBuilder();
        for(int i=0;i<length;i++)
            repeatedChars.append(c);
        return repeatedChars.toString();
    }

    /**
     * This method is used to iterate the numbers starting from 2
     *
     * @return stream of integers starting from 2
     */

    private static Stream<Integer> iterateNumbers() {
        return Stream.iterate(2, it -> it + 1);
    }

    /**
     * This method is used to calculate first n prime numbers
     *
     * @param n integer
     * @return array of first n prime numbers
     */

    public static int[] getNPrimes(int n) {
        return iterateNumbers().filter(PrimeMatrix::isPrime).limit(n).mapToInt(Integer::intValue).toArray();
    }

    /**
     * This function is used to check whether the given number k is prime or not
     *
     * @param k integer
     * @return is prime of not
     */

    public static boolean isPrime(int k) {
        int n = Math.abs(k);
        if (n <= 1) return false;
        return !iterateNumbers().limit(n - 2).filter(it -> n % it == 0).findAny().isPresent();
    }

}