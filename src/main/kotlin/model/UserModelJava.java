package model;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class UserModelJava {

    @NotNull
    private Long userId;
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String specialInfo;

    private UserModelJava() {

    }

    public UserModelJava(Long userId, String name, String email, String specialInfo) {
        this.email = email;
        this.name = name;
        this.specialInfo = specialInfo;
        this.userId = userId;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpecialInfo() {
        return specialInfo;
    }

    public void setSpecialInfo(String specialInfo) {
        this.specialInfo = specialInfo;
    }

    @Override
    public String toString() {
        return "UserModelJava{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", specialInfo='" + specialInfo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModelJava that = (UserModelJava) o;
        return userId.equals(that.userId) &&
                name.equals(that.name) &&
                email.equals(that.email) &&
                Objects.equals(specialInfo, that.specialInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, email, specialInfo);
    }
}
