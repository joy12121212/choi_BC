package model.dto;

public class BoardDto { // 게시물 , 카테고리 같이 씀
	// 필드
	
	private int bno;
	private String btitle;
	private String bcontent;
	private String bfile;
	private String bdate;
	private int bview;
	private int mno;
	private int bcno;
	
	//게시물에 추가적으로 표시할 필드
	private String mid;  // 작성자 아이디
	private String bcname;  // 카테고리명
	private String mimg;	// 게시글 등록 이미지
	
	// 조회자 , 작성자 일치여부 확인
	private boolean ishost;
	
	
	
	
	public boolean isIshost() {
		return ishost;
	}


	public void setIshost(boolean ishost) {
		this.ishost = ishost;
	}


	public String getMimg() {
		return mimg;
	}


	public void setMimg(String mimg) {
		this.mimg = mimg;
	}


	public BoardDto() {
		// TODO Auto-generated constructor stub
	}


	public int getBno() {
		return bno;
	}


	public void setBno(int bno) {
		this.bno = bno;
	}


	public String getBtitle() {
		return btitle;
	}


	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}


	public String getBcontent() {
		return bcontent;
	}


	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}


	public String getBfile() {
		return bfile;
	}


	public void setBfile(String bfile) {
		this.bfile = bfile;
	}


	public String getBdate() {
		return bdate;
	}


	public void setBdate(String bdate) {
		this.bdate = bdate;
	}


	public int getBview() {
		return bview;
	}


	public void setBview(int bview) {
		this.bview = bview;
	}


	public int getMno() {
		return mno;
	}


	public void setMno(int mno) {
		this.mno = mno;
	}


	public int getBcno() {
		return bcno;
	}


	public void setBcno(int bcno) {
		this.bcno = bcno;
	}


	public String getMid() {
		return mid;
	}


	public void setMid(String mid) {
		this.mid = mid;
	}


	public String getBcname() {
		return bcname;
	}


	public void setBcname(String bcname) {
		this.bcname = bcname;
	}


	@Override
	public String toString() {
		return "BoardDto [bno=" + bno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bfile=" + bfile
				+ ", bdate=" + bdate + ", bview=" + bview + ", mno=" + mno + ", bcno=" + bcno + ", mid=" + mid
				+ ", bcname=" + bcname + ", mimg=" + mimg + "]";
	}


	//글등록 생성자
	public BoardDto(String btitle, String bcontent, String bfile, int mno, int bcno) {
		super();
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.mno = mno;
		this.bcno = bcno;
	}

	//게시글 모든글 출력 생성자
	public BoardDto(int bno, String btitle, String bcontent, String bfile, String bdate, int bview, int mno, int bcno,
			String mid, String bcname, String mimg) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.bdate = bdate;
		this.bview = bview;
		this.mno = mno;
		this.bcno = bcno;
		this.mid = mid;
		this.bcname = bcname;
		this.mimg = mimg;
	}


	//수정 생성자

	public BoardDto(int bno, String btitle, String bcontent, String bfile, int bcno) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.bcno = bcno;
	}


	
	
	
	
	
	
	
	
	
	
	
	

}
