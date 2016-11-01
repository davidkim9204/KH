package qwetrd;

public class MemberDTO {
   
   
    
    private String name;
    private String gender;
    private String email;
    private String birth_date;
    private String id;    
    private String pwd;
    
    
 
    //이클립스팁 : Getter/Setter 만들기
    //             우클릭 -> source->Generate Getters And Setters-> [Select AlL] -> [OK]
   
   
   
   
    //DTO 객체 확인
    //이클립스팁 : toString() 자동생성: 우클릭 -> source -> Generate toString->[OK]
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
    public String toString() {
        return "MemberDTO [id=" + id + ", pwd=" + pwd + ", name=" + name
                + ", tel=" + tel + ", addr=" + addr + ", birth=" + birth
                + ", job=" + job + ", gender=" + gender + ", email=" + email
                + ", intro=" + intro + "]";
    }
}
 
[출처] [Java] 예제 - 데이터베이스(JDBC) 를 이용한 GUI 회원관리프로그램 [기본 v2]|작성자 자바킹