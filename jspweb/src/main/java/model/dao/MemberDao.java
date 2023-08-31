package model.dao;

import java.time.LocalDateTime;

import model.dto.MemberDto;

public class MemberDao extends Dao{
	private static MemberDao memberDao = new MemberDao();
	public static MemberDao getInstance () {return memberDao;}
	private MemberDao() {}
	
	

	
	
	// 1. 회원가입
	
	public boolean signup(MemberDto dto) {
		try {
			String sql = "insert into member(mid , mpwd , memail , mimg) values (? , ? , ? ,?);";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getMid());
			ps.setString(2, dto.getMpwd());
			ps.setString(3, dto.getMemail());
			ps.setString(4, dto.getMimg());
			
			int row = ps.executeUpdate();
			
			if (row == 1) {
				return true;
			}return false;
			
		} catch (Exception e) {
			System.out.println("오류발생 singup : " + e);
		}
			return false;
	}
	
	// 2. 로그인
	public boolean login (String mid , String mpwd) {
		try {
			String sql = "select * from member where mid = ? and mpwd = ?;";
			ps = conn.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2,mpwd);
			rs = ps.executeQuery();
			
			if (rs.next()) {return true;}
		} catch (Exception e) {System.out.println(e);	}
		
		return false;
	}
	
	
	// 3. 아이디 찾기
	
	// 4. 비밀번호 찾기
	
	// 5. 내정보 호출
	
	public MemberDto info (String mid) {
		try {
			String sql = "select mno , mid , memail , mimg from member where mid = ?;";
			ps=conn.prepareStatement(sql);
			ps.setString(1, mid);
			rs=ps.executeQuery();
			
			if (rs.next()) {
				MemberDto memberDto = new MemberDto(
						rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), LocalDateTime.now().toString());
				return memberDto;
			}
			
			
		} catch (Exception e) {	}
		return null;
	}
	
	// 6. 아이디 / 이메일 중복 검사
	
	public boolean findIdOrEmail (String type, String data) {
		
		try {
			String sql = "select * from member where "+ type +" = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, data);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				return true; // true 면 중복이라는 소리임
			}return false;
		} catch (Exception e) {
			System.out.println("findid 오류 " + e);
		}
	return false;	
	}
	
	// 7. 회원정보 수정
	
	public boolean mupdate(int mno , String mimg) {
		
		System.out.println("회원정보sql mno : " + mno);
		System.out.println("회원정보sql mimg : " + mimg);
		
		String sql = "update member set mimg = ? where mno = ?;";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, mimg);
			ps.setInt(2, mno);
			int count = ps.executeUpdate();
			
			if (count == 1) {
				return true;
			}
			
		} catch (Exception e) {
		System.out.println("회원정보수정 sql 오류 : " + e );
		}return false;
	}
	
	
	
	
	
	
	// 8. 회원 탈퇴
	
	public boolean mdelete (int mno , String mpwd) {
		try {
			String sql = "delete from member where mno = ? and mpwd = ?;";
			
			ps=conn.prepareStatement(sql);
			ps.setInt(1, mno);
			ps.setString(2, mpwd);
			int row = ps.executeUpdate();
			
			if (row ==1) {return true;}			
		} catch (Exception e) {System.out.println("삭제 트라이에서 오류 : " + e);}	
		return false;	
	}
	
	
	
	
	
	
	
}
