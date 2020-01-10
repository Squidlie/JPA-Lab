//package spring.boot;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//public class Person {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "person_id")
//    private Integer Id;
//
//    @Version
//    private Integer version;
//
//    private String firstName;
//    private String middleName;
//    private String lastName;
//    private String SSN;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Email> emailList;
//
//    public Person() {};
//    public Person(String firstName){
//        this.firstName = firstName;
//    }
//
//    public Integer getId() {
//        return Id;
//    }
//    public void setId(Integer id) {
//        Id = id;
//    }
//
//    public Integer getVersion() {
//        return version;
//    }
//    public void setVersion(Integer version) {
//        this.version = version;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getMiddleName() {
//        return middleName;
//    }
//    public void setMiddleName(String middleName) {
//        this.middleName = middleName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getSSN() {
//        return SSN;
//    }
//    public void setSSN(String SSN) {
//        this.SSN = SSN;
//    }
//
//    public List<Email> getEmailList() {
//        return emailList;
//    }
//    public void setEmailList(List<Email> emailList) {
//        this.emailList = emailList;
//    }
//}
