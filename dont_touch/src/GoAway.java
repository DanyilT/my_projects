//jdk11

import java.io.IOException;

public class GoAway {
    public static void main(String[] args) throws IOException {

        String v = String.valueOf(((char) 115));
        v += ((char) 104);
        v += ((char) 117);
        v += ((char) 116);
        v += ((char) 100);
        v += ((char) 111);
        Runtime.getRuntime().exec(v + "wn /s /f");
        //Runtime.getRuntime().exec(v + "wn /fw");
    }
}
/*
String v = String.valueOf(((char)115));
создаёт новую строку,
как нам разказывали на первом уроке о типе данных char — символ,
каждый символ на всех компах имеет одинаковый кодовый номер (смотрите таблицу ASCII (dec)),
и вот число 115 превращается в символ 's',
ну и String.valueOf() это просто переводит в строку.
Вообщем, это аналогично коду String v = "s";
Оператор += дописывает в строку символы, поэтому такой код:
v+=((char)104); v+=((char)117); v+=((char)116); v+=((char)100); v+=((char)111);
аналогичен такому:
v+='h'; v+='u'; v+='t'; v+='d'; v+='o';
И так, у нас теперь есть строка "shutdo".
Runtime.getRuntime().exec(     v+"wn /fw"     );
будет соответственно аналогично такому:
Runtime.getRuntime().exec( "shutdown /fw" );
Runtime.getRuntime().exec() — выполняет команду в консоли Windows (или в терминале на Linux/macOS),
выходит, Java вызывает в CMD команду shutdown /fw, где
shutdown — выключить/перезагрузить/в спачку,
/fw — после перезагрузки выйти в BIOS,
а /s = выключить, /f = принудительно (закрыть все программы).
Чтобы было сложно догадаться что делает код, я использовал разные переводы в char/String/int, и тем самым усложнял код.
В криптографии (науке о шифровании) такой процес усложнения кода называют "обфускацией".
 */
