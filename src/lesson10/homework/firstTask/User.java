package lesson10.homework.firstTask;

import java.util.Objects;

public class User {

    String nickname;
    String password;
    String email;

    public User(String nickname, String password, String email) {
        this.nickname = nickname;
        this.password = password;
        this.email = email;
    }

    @Override
    public String toString() {
        return "\nUser: " + "\n" +
                "\tNickname: " + this.nickname +"\n" +
                "\tPassword: " + this.password + "\n" +
                "\tUser email: " + this.email + "\n";
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname, password, email);
    }

    @Override
    public boolean equals(Object obj) {
        // сравниваем два объекта одного класса
        if (this == obj)
            return true;
        // объект не должен быть null; это не один и тот же объект
        if (obj == null || getClass() != obj.getClass())
            return false;

        User user = (User) obj;
        return Objects.equals(nickname, user.nickname)
                && Objects.equals(password, user.password)
                && Objects.equals(email, user.email);
    }
}
