import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/*
  @author   george
  @project   sofserve-testing-maven
  @class  MyUtilsTest
  @version  1.0.0 
  @since 13.03.23 - 19.18
*/

class MyUtilsTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "username@gmail.com", // simple
            "Username@gmail.com", // Upper case in username
            "user.name@gmail.com", // dot in username
            "user.name.login@gmail.com",  // complex username
            "user1.name@gmail.com",      // number in username
            "user.name@Gmail.com",    // upper case in domain
            "user.name@edu.kv.ua",       // three domains
            "user.name@sacura.edu.kv.ua",  // four domains
            "user.name@1edu.k2v.ua3"      // number in domains
    })
    void checkValidEmail(String email) {
        assertTrue(MyUtils.checkEmail(email));
    }
        @ParameterizedTest
    @ValueSource(strings = {
            "",
            "username#gmail.com", // @ absent
            "username.gmail.com",  // @ absent
            "1username@gmail.com",  // begins from number
            ".user.name@gmail.com", // begins from dot
            "user_name@gmail.com",  // underscore in username
            "user-name@gmail.com",   // -  in username
            "user$name@gmail.com",   // $  in username
            "user name@gmail.com",    //  space   in username
            "user.name@gmail-com",  // - in domains instead of dot
            "user.name@gmail com",  // space domains instead of dot
            "username@gmail,com"    // coma in domains instead of dot
    })
    void checkWrongEmail(String email) {
        assertFalse(MyUtils.checkEmail(email));
    }



}
