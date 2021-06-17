package iducs.springboot.a201712007.domain;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Blog {
    private int no;
    private String member_id;
    private String title;
    private String content;
    private String file;
    private String date;

    public int getNo() {
        return no;
    }

    public String getMember_id() {
        return member_id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }

    public String getFile() {
        return file;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setFile(String file) {
        this.file = file;
    }
}

