import java.security.PrivateKey;
import java.util.HashMap;
import java.util.Map;

public class UserService {
   private Map<String,User> hashMap=new HashMap<>();
public User currentuser=null;
    public boolean registerUser(String username,String password,String fullName ,String contact)
    {
        if(hashMap.containsKey(username))
        {
            System.out.println("Username already exit please take another");
            return false;
        }
        User user=new User(username,password,fullName,contact);
        hashMap.put(username,user);
        System.out.println("Registration Successfull");
        return true;

    }
    public boolean loginUser(String username,String password)
    {
        if(!hashMap.containsKey(username))
        {
            System.out.println("Username not found ");
            return false;
        }
        User user = hashMap.get(username);
        if (!user.getPassword().equals(password))
        {
            System.out.println("Incorrect Password");
            return false;
        }
        currentuser=user;
        System.out.println("Welcome"+user.getFullname()+"!");
        return true;
    }
    public void logoutUser()
    {
        if(currentuser!=null)
        {
            System.out.println("Logged out"+currentuser.getFullname());

        }
        currentuser=null;
    }
    public boolean isLoggedIn()
    {

        return currentuser!=null;
    }
}
