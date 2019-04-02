# previus token type
previus_token = "no_previus_token"

def BuildToken(words):
    global previus_token
    # if previus token is different to current token, build new token
    if(previus_token != words[0]):
        msj = "TOKEN:\n{\n\t//TOKEN's name: t_" + words[0] + "\n\t<t_" + words[1] + ": " + words[2] + ">{ System.out.println(\"t_" + words[1] + "\" + image); } : DEFAULT"
    else:
        # print new regex
        msj = "\t|<t_" + words[1] + ": " + words[2] + ">{ System.out.println(\"t_" + words[1] + ": \" + image); } : DEFAULT"
    print(msj)
    previus_token = words[0]
    return


def MatchFile(path):
    global previus_token
    # open the file, read row by row
    f = open(path, "r")
    for row in f:
        # for each row in the file
        # split the row in words
        words = row.split(",")
        # if previus token is different to current token, close previus token
        if(previus_token != words[0]):
            print("}")
        # for each row, build token
        BuildToken(words)
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
