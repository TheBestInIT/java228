package CaesarCipherEncryption;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ReadFile {
    static String s = "C:\\Users\\kalkulator\\javarush\\3253748\\javarush-project\\src\\CaesarCipherEncryption\\test2";



    // буква якої найбільше в даномі мапі
    private static char theMost(Map<Character,Integer> entr){

        int max=0;
        char symbol = ' ';
            for (Map.Entry<Character,Integer> entry : entr.entrySet()) {
                Character key = entry.getKey();
                Integer value = entry.getValue();
                if(value > max){
                    max =value;
                    symbol = key;
                }
            }
            return symbol;
        }


      // кількість кожнох букви в тексті
    public static Map<Character, Integer> countLetters(String text) {
        Map<Character, Integer> letterCount = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {
                c = Character.toLowerCase(c);
                letterCount.put(c, letterCount.getOrDefault(c, 0) + 1);
            }
        }
        return letterCount;
    }
    //по ідеї має вертати секретний ключ P.S це вже 8  метод який я не можу реалізувати звідти і назва міраж
    //якщо найбільше літер <<о>> тоді рахується що ключ знайдений
    //я пробува ще ставити провірки на багато літер
    //але в мене обмеження по часі тому так 0_о
    public static int mirag (String text){
    int n = 0;
    for (int i = 0; i < 30; i++) {
        Map<Character, Integer> co = countLetters(Alphabet.decipher(text, i));
        System.out.println(theMost(co));
        if(theMost(co) == 'о'){
            n = i;
            break;
        }
    }
     return n;
    }

    //читає текст з силки
    public static String readAllFromFile(String s){
        if(s == null){
            throw new RuntimeException("File not found");
        }
        StringBuilder stringBuilder = new StringBuilder();
        try {
            File file = new File(s);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                line = reader.readLine();
                stringBuilder.append(line + "\n");
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Помилка при зчитуванні файлу: " + e.getMessage());
        }
        return stringBuilder.toString();
    }




}
//    private static void salatPlus(){
//        for(int i = 1; i< Alphabet.alphabet.length;i++){
//          String s1 = Alphabet.toShine(readAllFromFile(s), i);
//            allText.add(s1);
//        }
//    } // static Map<Character, Integer> count = countLetters(readAllFromFile(s));
//   //static String sam = readAllFromFile(s);
//
//
////    private static void vv(){
////        String textToWrite = s;
////        Alphabet.toShine(s,0);
////        Path tempFilePath = null;
////        try {
////            tempFilePath = Files.createTempFile("example", ".txt");
////
////        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFilePath.toFile()));
////        writer.write(textToWrite);
////        writer.close();
////
////        BufferedReader reader = new BufferedReader(new FileReader(tempFilePath.toFile()));
////        StringBuilder sb = new StringBuilder();
////           String line = null;
////            while ((line = reader.readLine()) != null) {
////                sb.append(line);
////        }
////            Map<Character, Integer> count = countLetters(sb.toString());
////        reader.close();
////            //System.out.println(theMost(count));
////        System.out.println(line);
////        }catch (IOException e) {}
////    }