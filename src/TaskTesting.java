import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class TaskTesting {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Write digit, please. It's must been positive and no more 10000");
        int decDigit = in.nextInt();
        System.out.println("Write binary value, please. It's  must to consists only '0' or '1'");
        int binDigit = in.nextInt();

        // 1 способ конвертации в 16ую и 2ую  систему из 10ой
        if (cheackDec(decDigit)) {
            System.out.printf("Input value = %d in Hex system = %s and in binary system = %s"
                    , decDigit, convertDecToHexAndBinary(decDigit, 16),
                    convertDecToHexAndBinary(decDigit, 2));
            //2 способ конвертации в 16ую и 2ую  систему из 10ой
            convertInHexAndBinary(decDigit);
        } else {
            System.out.println("You're wrote digits wronge.Please, trying again.");
        }
        if (cheackBinary(binDigit)) {
            System.out.printf("\nInput value = %d in decimal system = %s "
                    , binDigit, convertBinToDec(binDigit));
        } else {
            System.out.println("You're wrote digits wronge.Please, trying again.");
        }
        //
    }

    public static boolean cheackDec(int decimal) {
        return decimal > 0 && decimal < 10000;
    }

    static boolean cheackBinary(int binary) {
        String bin = Integer.toString(binary);
        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(i) == '0' || bin.charAt(i) == '1') {
            } else {
                return false;
            }
        }
        return true;
    }

    static String convertDecToHexAndBinary(int decDigit, int HexOrBinaryIndex) {
        Map<Integer, String> map = new HashMap<>();
        map.put(10, "A");
        map.put(11, "B");
        map.put(12, "C");
        map.put(13, "D");
        map.put(14, "E");
        map.put(15, "F");
        int rest;
        String result = "";
        while (decDigit > 0) {
            rest = (decDigit % HexOrBinaryIndex);
            if (HexOrBinaryIndex == 16 && rest >= 10) {
                result = map.get(rest) + result;
                decDigit = decDigit / HexOrBinaryIndex;
                continue;
            }
            result = Integer.toString(rest) + result;
            decDigit = decDigit / HexOrBinaryIndex;
        }
        return result;
    }

    static int convertBinToDec(int binDigit) {
        int decimalDig = 0;
        int n = 0;
        int temp = 0;
        while (binDigit > 0) {
            temp = binDigit % 10;
            decimalDig += temp * Math.pow(2, n);
            binDigit = binDigit / 10;
            n++;
        }
        return decimalDig;
    }

    public static void convertInHexAndBinary(int dicValue) {
        String convertInHex = Integer.toHexString(dicValue).toUpperCase();
        String convertInBinary = Integer.toBinaryString(dicValue);
        System.out.println("\nHexdecimal value = " + convertInHex + " and  binary value = " + convertInBinary);

    }


}


