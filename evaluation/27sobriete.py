def RLE(text :str ) -> str:
    if not text:
        return ""

    result = []
    count = 1
    length = len(text)

    for i in range(1, length):
        if text[i] == text[i - 1]:
            count += 1
        else:
            result.append(f"{count}{text[i - 1]}")
            count = 1

    result.append(f"{count}{text[-1]}")

    return ''.join(result)


def RLEit(chaine :str, iteration:int) -> str:
    if iteration != 1 :
        nvlchaine = RLE(chaine)
        return RLEit(nvlchaine,iteration-1)  #Pour la récursivité on enleve 1 jusqua que ce soit égale à 1
    return RLE(chaine)
    


def unRLE(chaine : str)->str:
    nvlchaine = ""
    for i in range(0,len(chaine),2):
        nvlchaine = nvlchaine + int(chaine[i])*chaine[i+1]    
    return nvlchaine


def unRLEit(chaine :str, iteration:int) -> str:
    if iteration != 1 :
        nvlchaine = unRLE(chaine)
        return unRLEit(nvlchaine,iteration-1) #Pour la récursivité on enleve 1 jusqua que ce soit égale à 1
    return unRLE(chaine)

