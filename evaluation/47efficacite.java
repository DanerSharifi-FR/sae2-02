package iut.sae.algo;

public class efficacite {

    // Méthode pour compresser une chaîne en utilisant l'algorithme RLE
    public static String RLE(String entree) {
        if (entree == null || entree.isEmpty()) {
            return "";  // Retourne une chaîne vide si l'entrée est nulle ou vide
        }

        StringBuilder messageCompresse = new StringBuilder();  // Chaîne pour stocker le message compressé
        int cpt = 1;  // Compteur pour les occurrences d'un caractère
        char caractere = entree.charAt(0);  // Premier caractère de la chaîne

        // Parcourir chaque caractère de la chaîne d'entrée à partir du deuxième caractère
        for (int i = 1; i < entree.length(); i++) {
            char currentChar = entree.charAt(i);

            if (currentChar == caractere) {
                // Si le caractère courant est le même que le précédent
                if (cpt == 9) {  // Limite à 9 pour éviter de dépasser un seul chiffre
                    messageCompresse.append(cpt).append(caractere);  // Ajoute le caractère et son compte
                    cpt = 0;  // Réinitialise le compteur
                }
                cpt++;  // Incrémente le compteur
            } else {
                // Si le caractère courant est différent du précédent
                messageCompresse.append(cpt).append(caractere);  // Ajoute le caractère et son compte
                caractere = currentChar;  // Met à jour le caractère
                cpt = 1;  // Réinitialise le compteur pour le nouveau caractère
            }
        }

        // Ajoute la dernière séquence de caractère et son compte
        messageCompresse.append(cpt).append(caractere);

        return messageCompresse.toString();  // Retourne la chaîne compressée
    }

    // Méthode pour compresser une chaîne en utilisant RLE plusieurs fois
    public static String RLE(String entree, int iteration) {
        if (entree == null || entree.isEmpty()) {
            return "";  // Retourne une chaîne vide si l'entrée est nulle ou vide
        }

        for (int i = 0; i < iteration; i++) {
            entree = RLE(entree);  // Applique la compression RLE plusieurs fois
        }

        return entree;  // Retourne la chaîne compressée après les itérations
    }

    // Méthode pour décompresser une chaîne utilisant l'algorithme RLE
    public static String unRLE(String entree) {
        if (entree == null || entree.isEmpty()) {
            return "";  // Retourne une chaîne vide si l'entrée est nulle ou vide
        }

        StringBuilder messageDecrypte = new StringBuilder();  // Chaîne pour stocker le message décompressé

        // Parcourir chaque paire de caractères (nombre, caractère) de la chaîne compressée
        for (int i = 0; i < entree.length(); i += 2) {
            int count = Character.getNumericValue(entree.charAt(i));  // Nombre de répétitions
            char currentChar = entree.charAt(i + 1);  // Caractère à répéter

            // Ajoute le caractère décompressé le nombre de fois indiqué
            for (int j = 0; j < count; j++) {
                messageDecrypte.append(currentChar);
            }
        }

        return messageDecrypte.toString();  // Retourne la chaîne décompressée
    }

    // Méthode pour décompresser une chaîne utilisant RLE plusieurs fois
    public static String unRLE(String entree, int iteration) {
        if (entree == null || entree.isEmpty()) {
            return "";  // Retourne une chaîne vide si l'entrée est nulle ou vide
        }

        for (int i = 0; i < iteration; i++) {
            entree = unRLE(entree);  // Applique la décompression RLE plusieurs fois
        }

        return entree;  // Retourne la chaîne décompressée après les itérations
    }
}
