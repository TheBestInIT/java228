package CaesarCipherEncryption;

import javax.swing.*;

/**
 * Інструкція
 * *************
 * 1. перше текстове поле, сюди потрібно вводити текст який потрібно зашифрувати чи розшифрувати або ж
 *    силку на текстовий файл для <<brute force>>
 *        1.1 якщо це <<brute force>> то потрібно ввести зашифрований текст в перше тестове поле та
 *        натиснути кнопку <<визначити секретний ключ>> в тестовому полі з пррва появить розшифрований текст файла
 *        P.S не встиг організувати виключення і помилки бо мав тількии 2 дні.
 *        1.2 якщо просто зашифрувати/розшифрувати текс, тоді в поле з ліва ввести текст/шифр,
 *        вибрати на кнопці зліва число-секретний ключ, натиснути
 *        кнопку зашифрувати/рощшифрувати.
 * 2. в текстовому полі зліва буде виводитися вся інформація про шифровку/розшифровку
 * 3. в кнопці з права вибрати чило на скільки буде заміщена наступна буква
 * 4. прощу вибачення за нечитабильний код, мало часу(((
 * 5. ще тут не має багатьох провірок на null тому подібне інколи в консоль може виводитися
 *    помилка але вона нічим не заважає
 *      щераз вибачте :)
 */
public class MainKrypta {
    Alphabet alphabet = new Alphabet();
    public static void main(String[] args) {
        JFrame jFrame = View.createWindow();

    }

}
/*C:\Users\kalkulator\javarush\3253748\javarush-project\src\CaesarCipherEncryption\test2*/
