# word-count
Returns the word(s) with the min/max length in a sentence.

# Notes:
The project structure employs the standard maven format i.e:

src/main/java/WordCount.java

src/test/java/WordCountTest.java


The Main class shows the output from the simple sentence:

".The fat cat played with its toy on the mat." ==> 

       Max Words:
       
       W: [played], L:[6]
       
       Min Words:
       
       W: [on], L:[2]
       
It takes no arguments it just runs with the pre defined string.

#Assumptions
I made only two significant assumptions:

1. The function will return an empty list if provided with an empty or null String

2. The function can return more than one max value if they both have the same length
as in **Seventy and fat-cat** being the words with the min/max length in the same sentence.
