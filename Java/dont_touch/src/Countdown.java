import java.text.DecimalFormat;

public class Countdown {
    public static void main(String[] args) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        JOptionPane.showMessageDialog(null,
                "Three...\tTwo. . . One..." +
                "Zero...\tLiftoff! \n\t" +
                "Houston, we have a problem");
    }
}
