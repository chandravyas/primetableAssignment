# primetable

1) To run the code directly

run the below command from the primetable folder:
java -cp primetable-1.0-SNAPSHOT.jar com.chandra.task.PrimeMatrix <argument>

Eg 1: java -cp primetable-1.0-SNAPSHOT.jar com.chandra.task.PrimeMatrix 12

     |    2    3    5    7   11   13   17   19   23   29   31   37
------------------------------------------------------------------
    2|    4    6   10   14   22   26   34   38   46   58   62   74
    3|    6    9   15   21   33   39   51   57   69   87   93  111
    5|   10   15   25   35   55   65   85   95  115  145  155  185
    7|   14   21   35   49   77   91  119  133  161  203  217  259
   11|   22   33   55   77  121  143  187  209  253  319  341  407
   13|   26   39   65   91  143  169  221  247  299  377  403  481
   17|   34   51   85  119  187  221  289  323  391  493  527  629
   19|   38   57   95  133  209  247  323  361  437  551  589  703
   23|   46   69  115  161  253  299  391  437  529  667  713  851
   29|   58   87  145  203  319  377  493  551  667  841  899 1073
   31|   62   93  155  217  341  403  527  589  713  899  961 1147
   37|   74  111  185  259  407  481  629  703  851 1073 1147 1369

Eg 2: If you dont specify any argument or wrong number of arguments then by default value 10 is assigned and below ouput is given in case of no argument

No argument is entered so default value of 10 is assigned 
************
 You should try to pass the argument in the below format
java -cp primetable-1.0-SNAPSHOT.jar com.chandra.task.PrimeMatrix <argument>
************
    |   2   3   5   7  11  13  17  19  23  29
---------------------------------------------
   2|   4   6  10  14  22  26  34  38  46  58
   3|   6   9  15  21  33  39  51  57  69  87
   5|  10  15  25  35  55  65  85  95 115 145
   7|  14  21  35  49  77  91 119 133 161 203
  11|  22  33  55  77 121 143 187 209 253 319
  13|  26  39  65  91 143 169 221 247 299 377
  17|  34  51  85 119 187 221 289 323 391 493
  19|  38  57  95 133 209 247 323 361 437 551
  23|  46  69 115 161 253 299 391 437 529 667
  29|  58  87 145 203 319 377 493 551 667 841
 

2) To Build the Code and run the test cases:

Prerequisite: You need to have maven installed on your local machine. 
Here are the steps to install maven locally
https://maven.apache.org/install.html

Once you have maven run the below command from the primetable root folder:
mvn clean install