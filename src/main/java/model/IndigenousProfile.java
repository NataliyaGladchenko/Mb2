package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "profile")
@DiscriminatorValue("indigenous")
public class IndigenousProfile extends Profile {
    @Column(name = "number_of_trips_abroad")
    private int numberOfTripsAbroad;

    public IndigenousProfile(int profileId, int userId, String profile, int numberOfTripsAbroad) {
        super(profileId, userId, profile);
        this.numberOfTripsAbroad = numberOfTripsAbroad;
    }

    public IndigenousProfile() {
    }

    public int getNumberOfTripsAbroad() {
        return numberOfTripsAbroad;
    }

    public void setNumberOfTripsAbroad(int numberOfTripsAbroad) {
        this.numberOfTripsAbroad = numberOfTripsAbroad;
    }

    @Override
    public String toString() {
        return super.toString() + numberOfTripsAbroad;
    }
}
