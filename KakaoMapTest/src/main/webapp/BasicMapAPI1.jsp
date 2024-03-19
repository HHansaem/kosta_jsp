<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=915b6a231e6d1e690f36f1c4ac84bde8&libraries=services"></script>
</head>
<body>
<button id="currentPos">현재위치 지도 보기</button>
<div id="map" style="width:500px;height:400px;"></div>
<div id="currentAddress"></div>
<script>
	var container = document.getElementById('map');  //지도를 담을 영역의 DOM 레퍼런스
	var geocoder = new kakao.maps.services.Geocoder();  //Geocoder : 현재위치 가져오기 기능 
	
	//버튼 클릭시 현재 위치의 위도와 경도를 얻어와 지도에 반영
	var btn = document.getElementById('currentPos');
	btn.onclick = function() {
		if(!navigator.geolocation) {
			alert("위치 정보가 지원되지 않습니다.");
			return;
		}
		navigator.geolocation.getCurrentPosition(success);  //success함수 호출
	}
	
	//현재 위치의 조회 시간을 파라미터로 가지고 호출되는 함수
	function success({coords, timestamp}) {
		const latitude = coords.latitude;  //위도
		const longitude = coords.longitude;  //경도
		
		console.log(`위도:\${latitude}, 경도:\${longitude}, 위치 반환 시간:\${timestamp}`);
		var coord = new kakao.maps.LatLng(latitude,longitude);
		
		new kakao.maps.Map(container, {center:coord, level:3});
		
		//위도와 경도로 주소 얻어오기
		geocoder.coord2Address(coord.getLng(), coord.getLat(), callback);  //callback함수 호출
	}
	
	//주소값을 파라미터로 가지고 호출되는 함수
	function callback(result, status) {
		if(status===kakao.maps.services.Status.OK) {
			var currentAddress = document.getElementById('currentAddress');
			console.log(result[0].address);
			currentAddress.innerText = result[0].address.address_name;
		}
	}
	
	//처음 실행시 지도에 카카오센터 위치 지정
	var options = { //지도를 생성할 때 필요한 기본 옵션
		center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
		level: 3 //지도의 레벨(확대, 축소 정도)
	};

	var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
	
</script>
</body>
</html>