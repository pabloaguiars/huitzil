#library for regular expressions (regex)
import re

#function matches the word
def MatchWord(word):
    #define the symbols
    minus = "a-z"
    mayus = "A-Z"
    digits = "0-9"

    #define the regular expressions

    #variables
    variable_regex = "^[" + minus + mayus + "][" + minus + mayus + digits + "]*$"

    #natural numbers
    natural = "[" + digits + "]+"
    #rational numbers
    fraction = "([,|.]" + natural + ")?"
    #scientific notation
    scientific_not = "(([e|E])([+|-])?" + natural + ")?"
    #numbers
    number_regex = "^" + natural + fraction + scientific_not + "$"

    #email
    email_regex = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$"

    #url
    url_regex = "^(http:\/\/www\.|https:\/\/www\.|http:\/\/|https:\/\/)?[a-z0-9]+([\-\.]{1}[a-z0-9]+)*\.[a-z]{2,5}(:[0-9]{1,5})?(\/.*)?$"

    #check if the word matches with a specific regex
    result = ""

    if(re.search(variable_regex,word)):
        result = "VARIABLE"
    elif(re.search(number_regex,word)):
        result = "NUMBER"
    elif(re.search(email_regex,word)):
        result = "EMAIL"
    elif(re.search(url_regex,word)):
        result = "URL"
    else:
        result = "NO COINCIDENCE"

    #output result
    print("The word " + word + " is a " + result + ".")

    return;

#function matches the file
def MatchFile(path):
    #open the file, read row by row
    f = open(path, "r")
    for row in f:
        #for each row in the file
        #split the row in words
        words = row.split()
        for word in words:
            #for each word in the row
            #match the word
            MatchWord(word)
    return;

go = True
while(go):
    #input a file path
    path = input("Input a file path [.txt]: ")
    MatchFile(path)

    #new input?
    answer = input("\nNew input file?[y/n]: ")
    if(answer == "n"):
        go = False
    else:
        go = True
        
