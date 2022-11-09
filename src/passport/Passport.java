package passport;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

public class Passport {
    private final int number;
    private String lastName;
    private String name;
    private String middleName;
    private LocalDate localDate;

    public Passport(int number, String lastName, String name, String middleName,
                    LocalDate localDate) {
        this.number = checkIsNotNull(number);
        this.lastName = checkIsNotNull(lastName);
        this.name = checkIsNotNull(name);
        this.middleName = checkIsNotNull(middleName);
        this.localDate = checkIsNotNull(localDate);
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        if (number == passport.number) {
            lastName = passport.lastName;
            name = passport.name;
            middleName = passport.middleName;
            localDate = passport.localDate;
        }
        return number == passport.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    private String checkIsNotNull(String name) {
        if (name == null) {
            throw new RuntimeException("Поле не может быть пустым");
        }
        return name;
    }

    private int checkIsNotNull(int number) {
        if (number == 0) {
            throw new RuntimeException("Поле number не может быть пустым");
        }
        return number;
    }

    private LocalDate checkIsNotNull(LocalDate localDate) {
        if (localDate == null) {
            throw new RuntimeException("Поле localDate не может быть пустым");
        }
        return localDate;
    }
}
