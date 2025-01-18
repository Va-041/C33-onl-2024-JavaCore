package lesson10.homework.taskWithAsterisk;

import java.util.Objects;

public class User implements Cloneable {

    int id;
    String nickname;
    String password;
    String email;

    public User(int id, String nickname, String password, String email) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
        this.email = email;
    }

    public int getID() {
        return id;
    }
    public void setID(int id) {
        this.id = id;
    }

    public String getNickname () {
        return nickname;
    }
    public void setNickname (String nickname) {
        this.nickname = nickname;
    }
    public String getPassword () {
        return password;
    }
    public void setPassword (String password) {
        this.password = password;
    }
    public String getEmail () {
        return email;
    }
    public void setEmail (String email) {
        this.email = email;
    }

    public User shallowClone() {
        try {
            return (User) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public User deepClone() {
        try {
            User newUser = (User) super.clone();
            newUser.nickname = new String(this.nickname);
            newUser.password = new String(this.password);
            newUser.email = new String(this.email);
            return newUser;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nickname, password, email);
    }

    @Override
    public String toString() {
        return "\nUser: " + "\n" +
                "\tID: " + this.id + "\n" +
                "\tNickname: " + this.nickname +"\n" +
                "\tPassword: " + this.password + "\n" +
                "\tUser email: " + this.email + "\n";
    }

}


