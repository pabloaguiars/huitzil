import re

txt = "The rain in Spain"
x = re.search("^The.*Spain$", txt)

if(x):
    print("YES! We found a match")
else:
    print("no match")
