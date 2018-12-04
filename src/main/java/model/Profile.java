package model;

import converter.CaseConverter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "profile", uniqueConstraints = {@UniqueConstraint(columnNames = "profile_id")})
@DiscriminatorColumn(name = "discriminator", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("null")
public class Profile extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private int profileId;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "profile")
    @Convert(converter = CaseConverter.class)
    private String profile;

    public Profile(int profileId, int userId, String profile) {
        this.profileId = profileId;
        this.userId = userId;
        this.profile = profile;
    }

    public Profile() {
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return profile ;
    }
}
