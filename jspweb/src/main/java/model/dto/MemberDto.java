package model.dto;

public class MemberDto {
	private int mno;
	private String mid;
	private String mpwd;
	private String memail;
	private String mimg;
	// db없는 필드
	private String loginDatetime;
	
	
	// 로그인 객체를 만들 생성자
	// 패스워드 제외
	

	public MemberDto() {
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public String toString() {
		return "MemberDto [mno=" + mno + ", mid=" + mid + ", mpwd=" + mpwd + ", memail=" + memail + ", mimg=" + mimg
				+ ", loginDatetime=" + loginDatetime + "]";
	}


	// 로그인 객체 생성자
	public MemberDto(int mno, String mid, String memail, String mimg, String loginDatetime) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.memail = memail;
		this.mimg = mimg;
		this.loginDatetime = loginDatetime;
	}


	// 회원가입용 생성자
	public MemberDto(String mid, String mpwd, String memail, String mimg) {
		super();
		this.mid = mid;
		this.mpwd = mpwd;
		this.memail = memail;
		this.mimg = mimg;
	}

	//풀 생성자

	public MemberDto(int mno, String mid, String mpwd, String memail, String mimg, String loginDatetime) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.mpwd = mpwd;
		this.memail = memail;
		this.mimg = mimg;
		this.loginDatetime = loginDatetime;
	}

	public int getMno() {
		return mno;
	}


	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpwd() {
		return mpwd;
	}

	public void setMpwd(String mpwd) {
		this.mpwd = mpwd;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public String getMimg() {
		return mimg;
	}

	public void setMimg(String mimg) {
		this.mimg = mimg;
	}
	
	public String getLoginDatetime() {
		return loginDatetime;
	}
	
	public void setLoginDatetime(String loginDatetime) {
		this.loginDatetime = loginDatetime;
	}
	

}
