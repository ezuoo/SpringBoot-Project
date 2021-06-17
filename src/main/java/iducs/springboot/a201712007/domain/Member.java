package iducs.springboot.a201712007.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Member {
    private int no;
    private String id;
    private String pw;
    private String name;
    private String reg_date;

    public int getNo() {
        return no;
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public String getName() {
        return name;
    }

    public String getReg_date() {
        return reg_date;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReg_date(String reg_date) {
        this.reg_date = reg_date;
    }
}
