package iut.sae.algo;

public class Algo1 {
    public static String RLE(String in) {
        if (in == null || in.isEmpty()) return "";
        String out = ""; int c = 1;
        for (int i = 1; i < in.length(); i++) {
            if (in.charAt(i) == in.charAt(i - 1) && c < 9) c++;
            else { out += "" + c + in.charAt(i - 1); c = 1; }
        }
        return out + c + in.charAt(in.length() - 1);
    }
}
