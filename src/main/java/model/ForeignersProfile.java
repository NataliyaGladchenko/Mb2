package model;

import converter.CaseConverter;

import javax.persistence.*;

@Entity
@Table(name = "profile")
@DiscriminatorValue("foreigners")
public class ForeignersProfile extends Profile {
    @Column(name = "native_country")
    @Convert(converter = CaseConverter.class)
    private String nativeCountry;
    @Column(name = "years_in_country")
    private int yearsInCountry;

    public ForeignersProfile(int profileId, int userId, String profile, String nativeCountry, int yearsInCountry) {
        super(profileId, userId, profile);
        this.nativeCountry = nativeCountry;
        this.yearsInCountry = yearsInCountry;
    }

    public ForeignersProfile() {
    }

    public String getNativeCountry() {
        return nativeCountry;
    }

    public void setNativeCountry(String nativeCountry) {
        this.nativeCountry = nativeCountry;
    }

    public int getYearsInCountry() {
        return yearsInCountry;
    }

    public void setYearsInCountry(int yearsInCountry) {
        this.yearsInCountry = yearsInCountry;
    }

    @Override
    public String toString() {
        return "ForeignersProfile{" +
                "nativeCountry='" + nativeCountry + '\'' +
                ", yearsInCountry=" + yearsInCountry +
                '}';
    }
}
