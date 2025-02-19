package org.tc.ecommerce.users;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User {

    protected String name;
    protected String email;

    public User(final String name,final String email) {
        this.name = name;
        this.email = email;
    }
    public void login() {
        System.out.println(name +" login with email id: "+email);
    }
}
