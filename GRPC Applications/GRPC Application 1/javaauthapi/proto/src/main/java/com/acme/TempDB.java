package com.acme;





import java.util.ArrayList;
import java.util.List;

public class TempDB {


    public static List<User> getUsersFromTempDb() {

        return new ArrayList<User>() {
            {
                add(User.newBuilder().setId("1").setUserName("john_doe").setMobile("123-456-7890").setEmail("john.doe@example.com")
                        .setPosition("Manager").setBusinessUnit("Sales").setOid("12345").setGivenName("John").setFamilyName("Doe")
                        .setPreferredUsername("john.doe").setFirstName("John").setLastName("Doe").setSecondaryEmail("john.doe2@example.com")
                        .setPhoneNumber("987-654-3210").setExtension("1234").setDisplayName("John Doe").setManagerId("56789")
                        .setUserRoleId("4567").setIsActive(true).build());

                add(User.newBuilder().setId("2").setUserName("jane_smith").setMobile("987-654-3210").setEmail("jane.smith@example.com")
                        .setPosition("Supervisor").setBusinessUnit("Marketing").setOid("54321").setGivenName("Jane").setFamilyName("Smith")
                        .setPreferredUsername("jane.smith").setFirstName("Jane").setLastName("Smith").setSecondaryEmail("jane.smith2@example.com")
                        .setPhoneNumber("123-456-7890").setExtension("5678").setDisplayName("Jane Smith").setManagerId("12345")
                        .setUserRoleId("7890").setIsActive(false).build());

                // Add more User objects as needed
            }
        };
    }



    }


