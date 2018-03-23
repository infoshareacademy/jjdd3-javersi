package dto;

public class UserDto {
    private String email;
    private String id;
    private String name;
    private String locale;
    private String nickname;
    private Boolean roleAdministration;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
