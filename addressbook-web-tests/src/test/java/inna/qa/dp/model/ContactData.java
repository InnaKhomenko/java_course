package inna.qa.dp.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;
import org.testng.annotations.Test;

import javax.persistence.*;
import java.io.File;
import java.util.SplittableRandom;

@Entity
@Table(name = "addressbook")
public class ContactData {

    @Id
    @Column(name = "id")
    private int id = Integer.MAX_VALUE;

    @Column(name = "firstname")
    @Expose
    private String firstname;

   // @Column(name = "name")
    //@Expose
   // private String name;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (company != null ? !company.equals(that.company) : that.company != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (home != null ? !home.equals(that.home) : that.home != null) return false;
        if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
        if (work != null ? !work.equals(that.work) : that.work != null) return false;
        if (fax != null ? !fax.equals(that.fax) : that.fax != null) return false;
        if (email2 != null ? !email2.equals(that.email2) : that.email2 != null) return false;
        if (email3 != null ? !email3.equals(that.email3) : that.email3 != null) return false;
        return group != null ? group.equals(that.group) : that.group == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (home != null ? home.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (work != null ? work.hashCode() : 0);
        result = 31 * result + (fax != null ? fax.hashCode() : 0);
        result = 31 * result + (email2 != null ? email2.hashCode() : 0);
        result = 31 * result + (email3 != null ? email3.hashCode() : 0);
        result = 31 * result + (group != null ? group.hashCode() : 0);
        return result;
    }

    @Column(name = "lastname")
    @Expose
    private String lastname;

    @Column(name = "nickname")
    @Expose
    private String nickname;

    @Column(name = "title")
    @Expose
    private String title;

    @Column(name = "company")
    @Expose
    private String company;

    @Column(name = "address")
    @Type(type = "text")
    @Expose
    private String address;

    @Column(name = "home")
    @Type(type = "text")
    @Expose
    private String home;

    @Column(name = "mobile")
    @Type(type = "text")
    @Expose
    private String mobile;

    @Column(name = "work")
    @Type(type = "text")
    @Expose
    private String work;

    @Column(name = "fax")
    @Type(type = "text")
    @Expose
    private String fax;

    @Column(name = "phone2")
    @Type(type = "text")
    @Expose
    private String phone2;

    @Column(name = "email")
    @Type(type = "text")
    @Expose
    private String email1;

    @Column(name = "email2")
    @Type(type = "text")
    @Expose
    private String email2;

    @Column(name = "email3")
    @Type(type = "text")
    @Expose
    private String email3;

    @Column(name = "notes")
    @Type(type = "text")
    @Expose
    private String notes;

    @Transient
    @Expose
    private String group;

   // @Column(name = "middlename")
   // @Expose
  //  private String middlename;

    @Transient
    @Expose
    private String allNames;

    @Transient
    @Expose
    private String allPhones;

    @Transient
    @Expose
    private String allAddress;

    @Transient
    @Expose
    private String allEmails;

    @Transient
    @Expose
    private String allContent;

    @Column(name = "photo")
    @Type(type = "text")
    private String photo;


    public ContactData withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }

    public File getPhoto() {
        return new File(photo);
    }

    public String AllEmails() {
        return allEmails;
    }

    public String getAllAddress() {
        return allAddress;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public String getAllNames() {
        return allNames;
    }

  //  public String getMiddlename() {
    //    return middlename;
   // }

    public String getFirstname() {

        return firstname;
    }

    //public String getName() {
       // return name;
   // }

    public String getLastname() {
        return lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getHome() {
        return home;
    }

    public String getMobile() {
        return mobile;
    }

    public String getWork() {
        return work;
    }

    public String getFax() {
        return fax;
    }

    public String getEmail1() {
        return email1;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getNotes() {
        return notes;
    }

    public String getPhone2() {
        return phone2;
    }

    public String getAllEmails() {
        return allEmails;
    }

    public int getId() {
        return id;
    }

    public String getGroup() {
        return group;
    }


    public String getAllContent() {
        return allContent;

    }

    public ContactData withAllContent(String allContent) {
        this.allContent = allContent;
        return this;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    //public ContactData withName(String name) {
     //   this.name = name;
      //  return this;
    //}

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public ContactData withTitle(String title) {
        this.title = title;
        return this;
    }

    public ContactData withCompany(String company) {
        this.company = company;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withPhone2(String phone2) {
        this.phone2 = phone2;
        return this;
    }

    public ContactData withAllAddress(String allAddress) {
        this.allAddress = allAddress;
        return this;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactData withAllNames(String allNames) {
        this.allNames = allNames;
        return this;
    }

    public ContactData withHome(String home) {
        this.home = home;
        return this;
    }

    public ContactData withMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public ContactData withWork(String work) {
        this.work = work;
        return this;
    }

    public ContactData withFax(String fax) {
        this.fax = fax;
        return this;
    }

    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public ContactData withEmail1(String email1) {
        this.email1 = email1;
        return this;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

   // public ContactData withMiddlename(String middlename) {
    //    this.middlename = middlename;
   //     return this;
   // }

    public ContactData withNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }


}
