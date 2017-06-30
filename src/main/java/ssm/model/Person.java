package ssm.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by hua on 2017/6/25.
 */
public class Person implements Serializable{
    private int id;
    private String longname;
    private String phone;
    private String password;
    private Date createDate;
    private int delflag;

    public Person() {
    }

    public Person(int id, String longname, String phone, String password, Date createDate, int delflag) {
        this.id = id;
        this.longname = longname;
        this.phone = phone;
        this.password = password;
        this.createDate = createDate;
        this.delflag = delflag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLongname() {
        return longname;
    }

    public void setLongname(String longname) {
        this.longname = longname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getDelflag() {
        return delflag;
    }

    public void setDelflag(int delflag) {
        this.delflag = delflag;
    }
}
