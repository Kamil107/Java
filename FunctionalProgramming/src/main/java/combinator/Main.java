package combinator;

import java.time.LocalDate;

import static combinator.CustomerRegistrationValidator.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Alice", "alice@gmail.com", "+0328573697", LocalDate.of(2000, 1, 1));
        //System.out.println(new CustomerValidatorService().isValid(customer));

        //using combinator pattern
        ValidationResult result = isEmailValid()
                .and(isAnAdult())
                .and(isAnAdult())
                .apply(customer);

        System.out.println(result);

        if(result != ValidationResult.SUCCESS){
            throw new IllegalStateException(result.name());
        }
    }


}
