console.log('키오스크열리니')


// ------------------------ 샘플 데이터 ---------------------- //
	// 1. 광고 이미지 여러개 = 배열
let bimhList = ['himg1.png' , 'himg2.png' , 'himg3.jpg' , 'himg4.png' , 'himg5.png']
	// 2. 카테고리 여러개를 저장하는 배열
let categoryList = ['신제품(New' , '프리미엄' ,'와퍼&주니어' ,'치킨&슈림프버거' , '올데이킹&킹모닝' ]
	// 3. 제품 여러개 저장하는 배열 [ 서로 다른 데이터 여러개 저장 = 객체{}]
		// 동일한 유형들의 데이터 여러개 저장 = 배열 / 리스트 []
		// ex) 버거 이름, 버거 가격, 버거 이미지, 버거 카테고리 - 객체{}
		// ex) 버거1 버거2 버거3 버거4 - 배열[ ]
		// 다른 배열이나 객체의 연관관계
		// 카테고리 (상위) --> 제품(하위)  // 카테고리식별값  --> 제품에 저장 [pk  --> fk]
let burgerList = [ 
		{name : '헬로디아블로와퍼' , price : 9500 , img : '헬로디아블로와퍼.png' , category : 0},
		{name : '블랙바비큐와퍼' , price : 10100 , img : '블랙바비큐와퍼.png' , category : 1},
		{name : '통새우와퍼' , price : 7500 , img : '통새우와퍼.png' , category : 2}
				]

	// 4. 선택된 버거들이 저장되는 배열
		// 버거 객체 ?? 버거의 식별=중복x // 중복되지 않는 절대값 무언가가 필요 //보통은 제품번호(고유번호)로 식별
let cartList = []
	// 5. 주문 내역 저장
		// 주문내역에는 종류, 수량, 총 가격, 주문시각
		
		// 주문 { 주문번호 : , 주문날짜 ; , 결제금액 : , 주문제품들 : [] , 상태 : true[주문]/false[완료] - 취소or확정or완료or대기...}
let orderList = [
	{ono : 1 , date : '2023-07-05-13:30:45' , pay : 30000 , products : [0 , 0 , 2] , state : 0 }	
]



// ------------------------ 샘플 데이터 ---------------------- //

// 1. 광고이지미 변경

	// 2. 특정 시간마다 src 변경 하기
		// - setInterval(함수 , 밀리초) : 1/1000초
		// 1. function , function 익명 , ()=>{} 익명 화살표  /  익명, 화살표는 함수 안에서만 사용
		//setInterval( ()=> {}, 2000 ) ; // 2초마다 코드가 실행 된다

let viewhimg = 0; // 현재 출력중인 광고이미지 인덱스 저장하고있는 변수

setInterval ( ()=> {
	// 1. 해당 이미지 태그 객체 호출	
	let himg = document.querySelector('.himg');    
	// 2. 호출된 객체 에서 src 속성 대입( 변경 )
	viewhimg ++; // 인덱스 증가 [다음이미지로 변경]
	// 배열의 마지막 인덱스 보다 viewhimg 가 크거나 같으면 viewhimg 를 0 으로 돌린다 - 첫번째 이미지
	if(viewhimg >= bimhList.length){viewhimg = 0;}
	himg.src = `../img/${bimhList[viewhimg]}`;// 이미지 파일을 넣을거다 bimhList 배열에 있는 배열대로/01234
} , 2000);


// 2. 카테고리 출력[어디에 무엇을 출력할 것인가?] 함수



	// 2. 카테고리를 출력하는 함수 정의 [ 실행 조건 : 1. 페이지 열렸을때]
categoryPrint(0);//최초 1번 실행 [가장 앞에 있는 카테고리를 선택했다고 가정]
function categoryPrint(selectNo) {
	// 1. 어디에
	let categorymenu = document.querySelector('.categorymenu')
	// 2. 무엇을
	let html = ``;
		// html 구성 : 배열 내 모든 데이터 (for) 를 li 형식으로 출력
	for( let i = 0; i <categoryList.length; i++){
		if(i == selectNo){
			html += `<li onclick="categoryselect(${i})" class = "categoryselect">${categoryList[i]}</li>`;
		}else{html += `<li onclick="categoryselect(${i})">${categoryList[i]}</li>`;}
	}
	categorymenu.innerHTML = html;
	productPrint( selectNo );
}

// 3. 케테고리 클릭 함수 [실행 조건 : li 에서 클릭 했을때]
function categoryselect(selectNo){ // 클릭시 들어오는 인덱스 값 == selectNo -> 파라미터
	// <li> 는 여러개 존재 한다 // 무엇을 선택 했는지 식별 해야 된다

	let categoryli = document.querySelectorAll('.categorymenu li') // ul 안에 모든 li 호출
	console.log(categoryli)
	
	// 해당 선택된 인덱스의 class 추가 // js에서 class 추가 / 삭제 가능
	for( let i = 0; i <categoryList.length; i++){
		// 2. 선택된 카테고리 selectNo 의 i번째 카테고리 찾기
		if (selectNo ==i ){
			// 해당 li에 class 추가  //dom객체명.classList.add ('새로운 클래스 명')
			categoryli[i].classList.add('categoryselect')
		}else{
			// 해당 li에 class 삭제  //dom객체명.classList.remove ('삭제할 클래스 명')
			categoryli[i].classList.remove('categoryselect')
		}//if
	}//for
	productPrint( selectNo );
}


// 4. 제품 출력 함수 [ 실행 조건 : 1. 카테고리 클릭(변경) 되면 출력 ]

function productPrint( categoryNo ){ // 어떤 카테고리의 제품 출력할건지 ?? 인수 판단
	// 1. 어디에
	let productbox = document.querySelector('.productbox')	
	// 2. 무엇을 [ 선택된 카테고리에 맞는 제품들 만 출력]
	let html = ``;
		// html 구성
		for ( let i = 0 ; i<burgerList.length ; i++){ // 모든 버거 배열 하나씩 확인
			// i 번째 버거의 카테고리 와 선택한 카테고리가 같으면
			if (burgerList[i].category == categoryNo){
				html += `<div onclick="productSelect(${i})" class="product"> 
							<img src="../img/${burgerList[i].img}"/>
							<div class="pinfo"> <!-- pinfo -->
								<div class="pname">${burgerList[i].name}</div>
								<div class="pprice">${burgerList[i].price.toLocaleString()}</div>
							</div>
					 	</div> `
				
			} //if 
		}// for
	// 3. 출력[대입]
	productbox.innerHTML = html
}


// 5. 제품 선택 함수

function productSelect( productNo ){
	console.log(burgerList[productNo].name)
	cartList.push(productNo) ; console.log(cartList)
	cartPrint(); //카트에 저장된거 출력
}


	// carttop에 인덱스 추가 될때마다 수량++ 1~~5 등등 삭제되면 수량--, price + pirce sum 출력 
	// cartbot 아래에 있는 citem 가져와서 inner html 출력
	// x 에 onclick 이벤트 발생시 선택된 제품 삭제 인덱스
	
// 6. 카트 내 버거들을 출력하는 함수 [카트 내 제품이 등록 될때, 카트내 제품 취소 될때]

function cartPrint(){

	// 1. 어디에
	let cartbot = document.querySelector('.cartbot')
	
	// 2 . 무엇을? 카트 내 모든제품(배열) for 문 출력
	let html=``;
		let totalPrice = 0;
		for(let i=0; i<cartList.length; i++){
			
			let burgerIndex = cartList[i]; console.log(burgerList);
			
			html += `<div class="citem">
						<div class="iname">${burgerList[burgerIndex].name}</div>
						<div class="iprice">${burgerList[burgerIndex].price.toLocaleString()}원</div>
						<div onclick="productCancel(${i})" class="icencel">X</div>
					</div>`
			totalPrice += burgerList[burgerIndex].price		
		}//for
	// 출력
	cartbot.innerHTML = html;
	// *카트내 제품수
	document.querySelector('.ccount').innerHTML = `${cartList.length}`
	// *카트내 총가격
	document.querySelector('.ctotal').innerHTML = `${totalPrice.toLocaleString()}원`
	// *카트내 제품이 많아서 가로 스크롤이 활성화 된다면 반대편(끝)으로 이동
	cartbot.scrollLeft = 10000;
}


// 7. 카트 내 부분 취소 버튼 함수 [ 실행조건 : 카트 내, 버거 내 x 버튼 클릭시]

function productCancel(cartIndex){ // 일부분 취소 // 누구를 취소할지 인수 필요
	// 1. 카트 배열 내 인덱스 삭제
	cartList.splice(cartIndex , 1)
	// 2. 화면 업데이트
	cartPrint();
}

// 8. 카트 내 전체 취소 버튼 함수

function cartCancel(){ // 전체 취소라서 인수 필요 없음 / 인덱스 불필요
	// 1. 모두 삭제
	cartList.splice(0)

	// 2. 화면 업데이트
	cartPrint();	
	
}

// 9. 카트내 저장된 버거 주문(등록) 함수 [ 실행조건 : 주문하기 버튼 클릭시]

function productorder(){
	alert('주문 완료')
	
	//주문번호 만들기
	let ono = orderList[orderList.length-1].ono; // 주문배열내 마지막주문의 번호
	// 카트(전역변수) 에 있던 버거인덱스를 새로운 배열에 저장
	// 주문이 들어가는 버거들의 인덱스
	let products = [];
	let totalPrice = 0;
	for(let i = 0; i<cartList.length; i++){
		products.push(cartList[i]); // i번째 버거를 새로운 배열에 저장
		totalPrice += burgerList[cartList[i]].price // 총 금액에 버거 리스트에 카트리스느의 i 번째 인덱스를 더한다
	}
	
	// 1. 주문 객체 생성해서
	let order = { 
		ono : ono+1,			// 주문번호 생성해서 저장 주문번호++;
		date : new Date(),		// 현재 날짜/시간 구해주는 함수 이용해서 자동으로 대입
		pay : totalPrice,				// 카트 내 제품들의 총 가격
		products : products,	// 카트 내 있던 모든 제품들
		state : 0				// 주문객체 생성시 '주문요청'으로 초기상태로 사용 
	}
	
	// 2. 주문 배열에 저장하기
	orderList.push(order); alert('주문이 들어갔습니다')
	// 전체 취소 함수랑 같아서 재호출 // 재사용	
	cartCancel();
	console.log(orderList)
}

















