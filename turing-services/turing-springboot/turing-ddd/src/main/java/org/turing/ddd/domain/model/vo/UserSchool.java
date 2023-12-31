package org.turing.ddd.domain.model.vo;


/**
 * @descri: 
 *
 * @author: lj.michale
 * @date: 2024/1/5 17:56
 */
public class UserSchool {

    private String schoolName;    // 学校名称
    private String schoolAddress; // 学校地址
    private String entranceDate;  // 入学时间
    private String graduationDate;// 毕业时间

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolAddress() {
        return schoolAddress;
    }

    public void setSchoolAddress(String schoolAddress) {
        this.schoolAddress = schoolAddress;
    }

    public String getEntranceDate() {
        return entranceDate;
    }

    public void setEntranceDate(String entranceDate) {
        this.entranceDate = entranceDate;
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }
}