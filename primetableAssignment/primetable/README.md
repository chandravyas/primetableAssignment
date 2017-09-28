# primetable

1) To run the code directly

Prerequisite : Java 8 run time environment should be present
run the below command from the primetable folder:

java -cp primetable-1.0-SNAPSHOT.jar com.chandra.task.PrimeMatrix <argument>

For example command and output please refer to output.txt 

2) To Build the Code and run the test cases:

Prerequisite: You need to have maven and java 8 installed on your local machine. 
Here are the steps to install maven locally
https://maven.apache.org/install.html

Once you have maven run the below command from the primetable root folder:

mvn clean install

3) Complexity Considerations

* Generating the multiplication table is O(n**2) complexity since we have to multiply each prime by it's corresponding counterpart

* Displaying the table is O(n**2) since we're just iterating through the table and displaying each row. (there are 'n' number of rows)

* Consider complexity. How fast does your code run? How does it scale? -As the 'N' gets bigger the program is going to start slowing down because we are using trial division to determine if the number is prime. However, for small 'n' number of primes this solution will suffice.

* Consider cases where we want for bigger N primes. -In the case where we want 'N' number of primes, we would need to reimplement our prime check and pre-compute and store a list of primes up to a certain number. Then before testing the number in question for primality, we divide it by the primes in our list first

https://en.wikipedia.org/wiki/Primality_test

4) Unit Testing

PrimeMatrixTest.java is written to do unit testing using JUnit 