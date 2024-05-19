package com.acme.Entity;

import lombok.*;

import javax.persistence.*;


@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user") // Specify the actual table name
public class DbUser {

    @Id
    // Use appropriate strategy for your database
    @Column(name = "id")
    private String id;

    @Column(name = "user_name")
    private String user_name;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "email")
    private String email;

    @Column(name = "position")
    private String position;

//    @Column(name = "business_unit")
//    private String businessUnit;

    @Column(name = "oid")
    private String oid;

    @Column(name = "given_name")
    private String givenName;

    @Column(name = "family_name")
    private String familyName;

    @Column(name = "preferred_username")
    private String preferredUsername;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "secondary_email")
    private String secondaryEmail;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "extension")
    private String extension;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "manager_id")
    private String managerId;

    @Column(name = "user_role_id")
    private String userRoleId;

    @Column(name = "is_active")
    private boolean isActive;

    // Constructors, getters, setters, etc.
}
