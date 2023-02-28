package CaesarCipherEncryption;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class View {
    //число-секретний ключ
    private static int salat = 3;
    //масив для кнопки на яку юуде зміюватися попередній
    static Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41};
   static JComboBox numberCombo = new JComboBox(numbers);


    public static JFrame createWindow()  {
        JFrame jFrame = doView();


        JButton decipher = new JButton("розшифрувати");
        JButton toEncrypt = new JButton("зашифрувати");
        JButton found = new JButton("визначити секретний ключ з файла");


        numberCombo = new JComboBox(numbers);

        JTextArea jTextArea = new JTextArea();
        JTextArea jTextArea2 = new JTextArea();


        JScrollPane jScrollBefore = createJScrollPane(jTextArea);
        JScrollPane jScrollAfter = createJScrollPane(jTextArea2);


        jFrame.setLayout(new GridLayout(2,3));



        jFrame.add(jScrollBefore);
        jFrame.add(jScrollAfter);
        jFrame.add(numberCombo);
        jFrame.add(toEncrypt);
        jFrame.add(decipher);
        jFrame.add(found);
//дії для кнопок
        ActionListener actionListener = decipher(jTextArea,jTextArea2);
        decipher.addActionListener(actionListener);

        ActionListener actionListener2 = toShine(jTextArea,jTextArea2);
        toEncrypt.addActionListener(actionListener2);

        ActionListener actionListener3 = found(jTextArea,jTextArea2);
        found.addActionListener(actionListener3);

        jFrame.revalidate();
    return jFrame;
    }
    //авто розшифровка
    private static ActionListener found(JTextArea text,JTextArea here){
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texts = text.getText();
                String str = ReadFile.readAllFromFile(texts);
                int num = ReadFile.mirag(str);
                String s = Alphabet.decipher(str,num);
                here.setText("cекретний ключ: "+num +"\n"+s);
            }
        };
        return actionListener;
    }



    private static ActionListener decipher(JTextArea text, JTextArea here){
        ActionListener actionListener =new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String texts = text.getText();
                salat = getSalat();
                if(texts.startsWith("Напишіть тут : ")){
                    texts = texts.substring("Напишіть тут : ".length());
                }
                String s = Alphabet.decipher(texts,salat);
                here.setText("розшифрування з ключем  "+salat + " \n"+s);
            }
        };
        return actionListener;
    }
    private static ActionListener toShine (JTextArea text, JTextArea here){
        ActionListener actionListener =new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String texts = text.getText();
                salat = getSalat();
                if(texts.startsWith("Напишіть тут :")){
                    texts = texts.substring("Напишіть тут :".length());
                }
                String s = Alphabet.toShine(texts,salat);
             //   System.out.println(s);
                here.setText("шифрування з ключем  "+salat + " \n"+s);
            }
        };
        return actionListener;
    }


//просто вигляд
    private static JFrame doView(){
        JFrame jFrame = new JFrame("i'm was trying");
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width/2 -300,dimension.height/2 - 200,600,400);
        return jFrame;
    }
    //панель з кнопками на вибір
    private static JScrollPane createJScrollPane(JTextArea jTextArea){
        jTextArea.setLineWrap(true);
        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        return jScrollPane;
    }



    public static void setSalat(int salat) {
        View.salat = salat;
    }
    public static int getSalat(){
        Integer chosenNumber = (Integer) numberCombo.getSelectedItem();
            return chosenNumber;
    }
}













