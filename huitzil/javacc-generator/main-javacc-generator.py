# previus token type
previus_word = "no_previus_word"

def BuildMain(words):
    global previus_token
    # if previus token is different to current token, build new OR
    if(previus_word != words[1]):
        msj = "-\n\t|<t_" + words[1] + ">-"
        print(msj)
    previus_token = words[1]
    return


def MatchFile(path):
    global previus_token
    # open the file, read row by row
    f = open(path, "r")
    msj = "void Main() : \n{}\n{\n("
    print(msj)
    for row in f:
        # for each row in the file
        # split the row in words
        words = row.split(",")
        # for each row, build token
        BuildMain(words)
    msj = ")+\n<EOF>\n}"
    print(msj)
    return

go = True
while(go):
    # input a file path
    #path = input("Input a file path [.txt] with tha tokens table: ")
    path = input()
    MatchFile(path)

    # new input?
    #answer = input("\nNew input file?[y/n]: ")
    answer = input()
    if(answer == "n"):
        go = False
    else:
        go = True
