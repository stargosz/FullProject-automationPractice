package Models;

public class User {

    private Gender gender;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private String address;
    private String city;
    private int state;
    private int zipCode;
    private int country;
    private int mobilePhone;

    public User(Gender gender, String firstName, String lastName, String email, String password, int dayOfBirth, int monthOfBirth, int yearOfBirth, String address, String city, int state, int zipCode, int country, int mobilePhone) {
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
        this.mobilePhone = mobilePhone;
    }

    public Gender getGender() {
        return gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getDayOfBirth() {
        return dayOfBirth;
    }

    public int getMonthOfBirth() {
        return monthOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public int getState() {
        return state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public int getCountry() {
        return country;
    }

    public int getMobilePhone() {
        return mobilePhone;
    }

    public static final class Builder{
        private Gender gender;
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private int dayOfBirth;
        private int monthOfBirth;
        private int yearOfBirth;
        private String address;
        private String city;
        private int state;
        private int zipCode;
        private int country;
        private int mobilePhone;

        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }
        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }
        public Builder email(String email){
            this.email = email;
            return this;
        }
        public Builder password(String password){
            this.password = password;
            return this;
        }
        public Builder gender(Gender gender){
            this.gender = gender;
            return this;
        }
        public Builder dayOfBirth(int dayOfBirth){
            this.dayOfBirth = dayOfBirth;
            return this;
        }
        public Builder monthOfBirth(int monthOfBirth){
            this.monthOfBirth = monthOfBirth;
            return this;
        }
        public Builder yearOfBirth(int yearOfBirth){
            this.yearOfBirth = yearOfBirth;
            return this;
        }
        public Builder address(String address){
            this.address = address;
            return this;
        }
        public Builder city(String city){
            this.city = city;
            return this;
        }
        public Builder state(int state){
            this.state = state;
            return this;
        }
        public Builder zipCode(int zipCode){
            this.zipCode = zipCode;
            return this;
        }
        public Builder country(int country){
            this.country = country;
            return this;
        }
        public Builder mobilePhone(int mobilePhone){
            this.mobilePhone = mobilePhone;
            return this;
        }

        public User build(){
           if (firstName.isEmpty()) throw new IllegalStateException("Name cannot be empty");
           if (lastName.isEmpty()) throw new IllegalStateException("Name cannot be empty");
           if (password.isEmpty()) throw new IllegalStateException("Name cannot be empty");

           return new User(gender, firstName, lastName, email, password, dayOfBirth, monthOfBirth, yearOfBirth, address, city, state, zipCode, country, mobilePhone);
        }
    }
}
