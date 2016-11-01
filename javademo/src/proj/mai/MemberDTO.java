package proj.mai;

import java.sql.Date;
import java.util.HashMap;

public class MemberDTO {
	private int member_num;
	private String name;
	private String gender;
	private String email;
	private Date birth_date;
	private String member_id;
	private String password;
	// 키값으로 카페명을 가지고오도록
	private HashMap<Integer, String> cafe_map = new HashMap<Integer, String>();

	private static MemberDTO dto = new MemberDTO();

	private MemberDTO() {
	}

	public static MemberDTO getInstance() {
		if (dto == null)
			dto = new MemberDTO();
		return dto;
	}

	public int getMember_num() {
		return member_num;
	}

	public void setMember_num(int member_num) {
		this.member_num = member_num;
	}

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

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public HashMap<Integer, String> getCafe_map() {
		return cafe_map;
	}

	public void setCafe_map(HashMap<Integer, String> cafe_map) {
		this.cafe_map = cafe_map;
	}

}
