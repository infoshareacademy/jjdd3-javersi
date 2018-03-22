package cdi;

import dao.UsersDao;
import dto.UserDto;
import model.UserName;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class UserBean {

    @Inject
    UsersDao usersDao;

    public UserName getUser(UserDto userDto) {
        UserName userName = usersDao.findById(userDto.getId());
        if (userName != null)
            return userName;
        else {

        }
    }


}
