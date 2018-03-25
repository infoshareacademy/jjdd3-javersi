package cdi;

import dao.UsersDao;
import dto.UserDto;
import model.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class UserBean {

    @Inject
    UsersDao usersDao;

    public User getUser(UserDto userDto) {
        User user = usersDao.findById(userDto.getId());
        if (user != null)
            return user;
        else {
            User newUser = User.createFromUserDto(userDto);
            if (usersDao.findAll().size() == 0) {
                newUser.setRoleAdministration(true);
            }
            usersDao.save(newUser);
            return newUser;
        }
    }
}
