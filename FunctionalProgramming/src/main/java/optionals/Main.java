package optionals;

import javax.swing.text.html.Option;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Object value = Optional.ofNullable("Hello")
                .orElseThrow(() -> new IllegalStateException("exception"));

        Optional.ofNullable("john@gmail.com")
                .ifPresentOrElse(email -> System.out.println("Sending email to " + email),
                                 () -> System.out.println("Cannot send email") );
    }
}
