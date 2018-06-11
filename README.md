# word-count
Returns the word(s) with the max length in a sentence.

# Notes:
The project structure employs the standard maven format i.e:

src/main/java/WordCount.java

src/test/java/WordCountTest.java

src/test/java/WordCountTestRunner.java

The Main class shows the output from the simple sentence:

".The fat cat used on the mat." ==> 4 used

I have also included a jar file to provide for simple execution.

It takes no arguments it just runs with the pre defined string.

#Assumptions
I made only two significant assumptions:

1. The function will return an empty list if provided with an empty or null String

2. The function can return more than one max value if they both have the same length
as in **Seventy and fat-cat** being the words with the max length in the same sentence.
