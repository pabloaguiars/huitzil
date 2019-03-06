#library for regular expressions (regex)
import re

#read a word
word = input("Input a word: ")

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

#check if the word matches with a specific regex
result = ""

if(re.search(variable_regex,word)):
    result = "variable"
elif(re.search(number_regex,word)):
    result = "number"
else:
    result = "no coincidence"

#output result
print("The word " + word + " is a " + result + ".")
