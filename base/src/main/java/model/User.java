package model;

import dto.UserDto;

import javax.persistence.*;

@Entity
@Table(name = "USER_INFO")
public class User {

    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "locale")
    private String locale;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "role_administration")
    private Boolean roleAdministration;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Boolean getRoleAdministration() {
        return roleAdministration;
    }

    public void setRoleAdministration(Boolean roleAdministration) {
        this.roleAdministration = roleAdministration;
    }

    public static User createFromUserDto(UserDto dto) {
        User user = new User();
        user.userId = dto.getId();
        user.email = dto.getEmail();
        user.name = dto.getName();
        user.locale = dto.getLocale();
        user.nickname = dto.getNickname();
        user.setRoleAdministration(false);
        return user;
    }
}
