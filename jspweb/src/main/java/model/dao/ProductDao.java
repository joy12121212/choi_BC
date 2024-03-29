package model.dao;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.dto.ProductDto;

public class ProductDao extends Dao{
	private static ProductDao productDao = new ProductDao();
	private ProductDao () {}
	public static ProductDao getInstance() {return productDao;}
	
	
	public boolean register(ProductDto dto) {
		// 1-1 [제품 등록] 
		try {
			
			String sql = "insert into product( pcno , pname , pcontent , pprice , plat , plng , mno  ) "
					+ "	values( ? , ? , ? , ? , ? , ? , ?  );";
			// * sql insert 후 자동생성[auto_increment]된 pk번호를 반환하는 방법 
				// conn.prepareStatement( sql , Statement.RETURN_GENERATED_KEYS ) 	: 생성된 식별키를 반환
				// ps.getGeneratedKeys() 											: 식별키 반환하는 함수.
			ps = conn.prepareStatement( sql , Statement.RETURN_GENERATED_KEYS ); 
			
			ps.setInt( 1 , dto.getPcno()  );		ps.setString( 2 , dto.getPname() );
			ps.setString( 3 , dto.getPcontent() );	ps.setInt( 4 , dto.getPprice() );
			ps.setString( 5 , dto.getPlat() );		ps.setString( 6 , dto.getPlng() );
			ps.setInt( 7 , dto.getMno() );
			
			int count = ps.executeUpdate();	// 제품 등록 
			
			rs = ps.getGeneratedKeys(); // 제품 등록시 생성된 식별키[pk->pno] 반환해서 resultset[ps]에 대입
			if( rs.next() ) {	// resultset  null ---next()--> 결과레코드1 --next()--> 결과레코드2 
							// 반환된 결과레코드로 1번 이동 [ 하나의 제품 식별키 필요 ]
				if( count == 1 ) { // 만약에 제품등록 1개 등록했으면 
					// 1-2 제품 등록후 생성된 제품pk를 가지고 [이미지 등록] 
						// 1. dto 에 저장된 이미지 개수만큼 insert 실행 
					for( String img : dto.getImgList().values() ) {
						sql = "insert into productimg( pimg , pno ) values( ? , ? )";
						ps = conn.prepareStatement(sql);
						ps.setString( 1 , img  );
						ps.setInt( 2 , rs.getInt( 1 ) ); // ??????????? 위에서 insert 된 제품번호 ????
						ps.executeUpdate();
					} 
					return true; // 제품등록과 이미지 등록 성공 했을때. 
				}
			}
			
		}catch (Exception e) { System.out.println( e ); } return false;
	}

	
	//출력 
		//0 해당 제품의 이미지 출력 함수
	public Map<Integer, String> getProductImg(int pno){
		try {
			// 이미지 텡블에서 현재 레코드의 제품 번호에 해당하는 여러개 이미지 출력해서 map 객체에 담기			
			Map<Integer, String> imglist = new HashMap<>();			
			String sql = "select * from productimg where pno = "+pno;
			// 위에서 먼저 사용중인 rs 에서 이미 사용중으로 while 중복 사용 불가
			// 새로운 rs 만들어서 한번 더 rs 돌리기			
			
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {imglist.put(rs.getInt("pimgno"), rs.getString("pimg"));}
			return imglist;
		} catch (Exception e) {System.out.println(e);} return null;
		
	}
	
	
	// 3. 선택된 제품번호에 해당하는 제품 출력 함수
	public ProductDto findByPno( int pno ){
		
		try {
			String sql = "select * from product p natural join pcategory pc natural join member m where p.pno= " + pno;

			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				ProductDto dto = new ProductDto(
						rs.getInt("pcno"), rs.getString("pcname"), 
						rs.getInt("pno"), rs.getString("pname"), 
						rs.getString("pcontent"), rs.getInt("pprice"), 
						rs.getInt("pstate"), rs.getString("pdate"), 
						rs.getString("plat"), rs.getString("plng"), 
						rs.getInt("mno"), getProductImg(rs.getInt("pno")), rs.getString("mid"));
				return dto;
			}
			
			
			
		} catch (Exception e) {System.out.println("findByPno 에러 : " + e);}
		return null; }
	
	
	// 1. n 개 제품들을 최신순으로 출력 함수
	public List<ProductDto> findByTop( int count ){
		List<ProductDto> list = new ArrayList<>();
		try {
			String sql = "select * from product order by pdate desc limit " + count;
			ps = conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while (rs.next()) {list.add(findByPno(rs.getInt("pno")));}
			return list;
		} catch (Exception e) {System.out.println("findByTop 에러 : " + e);}
	return null; }
	
	
	
	
	
	
	
	// 2. 현재 카카오지도내 보고있는 동서남북 기준내 제품들을 출력 함수
	public List<ProductDto> findByLatLng( String east , String west , String south , String north ){

		try {// 동쪽 경도보다 작고 서쪽 경도보다 크고 남쪽 위도보다 작고 북쭉 위도보다 크고
			List<ProductDto> list = new ArrayList<>();
			String sql = "select * from product where plat <= ? and plat >= ? and plng >= ? and plng <= ? ";

			ps = conn.prepareStatement(sql);
			ps.setString(4, east);
			ps.setString(3, west);
			ps.setString(2, south);
			ps.setString(1, north);
			rs=ps.executeQuery();
			
			while (rs.next()) {list.add(findByPno(rs.getInt("pno")));}
			return list;
			
		} catch (Exception e) {System.out.println("findByLatLng 에러 : " + e);}
	return null; }
	
	
	// 4. 모든 제품들을 출력하는 함수
	public List<ProductDto> findByAll( ){ 
		
		try {
			List<ProductDto> list = new ArrayList<>();			
			String sql = "select pno from product";
			ps = conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while (rs.next()) {list.add(findByPno(rs.getInt("pno")));}
			return list;
		} catch (Exception e) {System.out.println("findByAll 에러 : " + e);}		
	return null; }

	
	
	
	// 제품 찜하기 등록(찜하기 상태가 아닐때=조건에 따른 레코드 없을때) 
	// 취소(찜하기 상태일때 = 조건에 따른 레코드 있을때)
	public boolean setWish(int mno, int pno) {
		
		try {
			String sql = getWish(mno , pno) ? 
				"delete from pwishlist where mno = ? and pno = ?" :
				"insert into pwishlist values( ? , ? )";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mno);
			ps.setInt(2, pno);
		
			int row = ps.executeUpdate();
			//레코드가 있으면 찜하기 이미 등록한거
			//레코드가 없으면 찜하기 등록 안한거
			if(row==1){return true;}

		} catch (Exception e) {
			//e.getStackTrace(); 어디서 오류인지 알려줌
			System.out.println("setWish 오류 : "+ e);}
		return false;
	}
	
	
	// 제품 찜하기 상태 출력
	
	public boolean getWish(int mno , int pno) {
		
		String sql = "select * from pwishlist where mno =? and pno = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mno); ps.setInt(2, pno);
			rs = ps.executeQuery();
			
			if(rs.next()) {return true;}
			
		} catch (Exception e) {
			System.out.println("getWish 오류 : "+ e);}
		return false;
	}
	
	// 현재 로그인된 회원의 찜한 제품 정보 출력
	public List<ProductDto> getWishProductList(int mno){
		List<ProductDto> list = new ArrayList<>();
		
		try {
			
			// 현재 회원이 찜한 제품번호 찾기
			String sql = "select pno from pwishlist where mno = "+mno;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				// 회원이 찜한 pno-제품번호 반환
				// 몇개 인지 모르니까 while 돌리는거고 반환해줄거는 pno 들을 list로 반환해준다 // 프론트로 가서 for 문 이용해 전체 출력
				list.add(findByPno(rs.getInt("pno")));
			}
		} catch (Exception e) {System.out.println("getWishProductList 오류 : "+ e);}
		return list;
	}
	
	
	
	
	
	

}//class
