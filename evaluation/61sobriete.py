def RLE(texte):
    # si le texte est vide on renvoie une chaine vide
    if not texte:
        return ""

    resultat = []

    # initialise le compteur et le caractère
    compteur = 1
    caractere = texte[0]

    # on parcours le texte a partir du deuxième caractère
    for i in range(1, len(texte)):
        # si le caractère actuel est le même que le précédent et que le compteur est inférieur à 9
        if texte[i] == caractere and compteur < 9:
            compteur += 1
        else:
            # sinon on ajoute le compteur et le caractère au résultat
            resultat.extend([str(compteur), caractere])
            # on remets les variables a jour
            compteur = 1
            caractere = texte[i]

    # on ajoute ce qu'il reste au resultat
    resultat.extend([str(compteur), caractere])

    # on mets la liste sous foeme de chaine et on la renvoie
    return "".join(resultat)


def RLE_recursif(chaine, nombre):
    resultat = chaine
    for _ in range(nombre):
        resultat = RLE(resultat)
    return resultat


def unRLE(chaine):
    result = ""
    for i in range(0, len(chaine), 2):
        nombre = int(chaine[i])
        caractere = chaine[i+1]
        result += caractere * nombre
    return result

def unRLE_recursif(chaine, nombre):
    resultat = chaine
    for i in range(nombre):
        resultat = unRLE(resultat)
    return resultat