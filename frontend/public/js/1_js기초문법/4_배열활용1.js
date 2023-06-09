
// 1. 배열선언 : 학생 리스트 배열명으로 빈 배열 선언
let 학생리스트 = [] // 초기에는 배열에 아무것도 없음

// 2. 이벤트 : 무엇인가 실행, 발생 
	//onclick : 온클릭 이벤트 [ 클릭하면 실행 됨 ]
	//이벤트 함수 [코드들이 모여있는 주머니/공간]
	// 함수형태 : function 함수명(매개변수) {   }
	//함:상자 수:숫자 => 숫자들이 든 상자 => 미리 정의된 수 => 미리정의된 코드
		
function 추가함수(){
	alert('함수 실행했기')
	
	// 1. input 객체 호출
	let snameInput = document.querySelector(".sname")
		// document : html 문서 (dom 객체)
		// query : 쿼리(질의하다)
			// document.querySelector(".sname") sname이라는 class가 가진 input 객체 호출
			// 호출된 input 객체를 'sname' 변수에 담았다.
	// 2. 입력받은 데이터 가져오기
	let name = snameInput.value
			// 변수명.value : 입력된 값 호출
	// 3. 입력받은 데이터를 배열에 추가
	// * 유효성검사 : 배열에 이미 존재하면 push 안함, 배열에 존재하지 않으며 push
	학생리스트.indexOf(name) != -1 ? alert('이미 존재하는 학생명 입니다') : 학생리스트.push(name)

		
	let slistUl = document.querySelector(".slist")
		// 2. 해당 ul 객체에 쓰기
	slistUl.innerHTML = '<li>' + 학생리스트 + '</li>'
			// innerHTML : <> (inner) </>
	// * 현재 <input> 객체 입력값 초기화
	snameInput.value = ''

			
}

// 3. 삭제 함수

function 삭제함수() {
	
	// * 입력받은 데이터 삭제
	
	// 1. input 객체 호출
	let snameInput = document.querySelector('.sname')
	// 2. input 객체의 value 속성 호출
	let name = snameInput.value
	// *삭제할려면 인덱스 필요
	// 3. 삭제할 데이터의 인덱스(저장된 순서,번호) 찾자
	let  index =  학생리스트.indexOf( name )
		// 해당 데이터가 배열에 존재하면 0~찾을번호 알려줌 / 없으면 -1
	// 4. 배열내 인덱스를 이용한 데이터 삭제
	// * 유효성검사 : 데이터가 개발자가 원하는 데이터인지 검사
	index != -1 ? 학생리스트.splice(index , 1 ) : alert('없는데이터 입니다')
	
	//결과물 출력
	// 5. 배열 출력
	let slistUl = document.querySelector('.slist')	
	slistUl.innerHTML = '<li>' + 학생리스트 + '</li>'
	// * 현재 <input> 객체 입력값 초기화
	snameInput.value = ''
}































