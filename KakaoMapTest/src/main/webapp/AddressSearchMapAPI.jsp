<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Address Search API</title>
</head>
<body>
<div id="container" style="height:auto;overflow:hidden;width:800px"></div>
<br>
<div id="moreBtn"><button id="moreBtn">더보기</button></div>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=915b6a231e6d1e690f36f1c4ac84bde8&libraries=services"></script>
<script>
	//주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();
	
	function makeMapDiv() {
		const div = document.createElement('div');
		div.style.width = '250px';
		div.style.height = '250px';
		div.style.marginTop = '10px';
		div.style.marginRight = '10px';
		div.style.display = 'inline-block';
		return div;
	}
	
	function addressSearch(address, mapDiv, title) {
		// 주소로 좌표를 검색합니다
		geocoder.addressSearch(address, function(result, status) {
		    // 정상적으로 검색이 완료됐으면 
		     if (status === kakao.maps.services.Status.OK) {
		    	 
		        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
		    	 mapOption = {
    		        center: coords, 
    		        level: 3 
    		    };
				var map = new kakao.maps.Map(mapDiv, mapOption); 
		    	 
		        // 결과값으로 받은 위치를 마커로 표시합니다
		        var marker = new kakao.maps.Marker({
		            map: map,
		            position: coords
		        });
				
		        // 인포윈도우로 장소에 대한 설명을 표시합니다
		        var infowindow = new kakao.maps.InfoWindow({
		            content: `<div style="width:150px;text-align:center;padding:6px 0;">\${title}</div>`
		        });
		        infowindow.open(map, marker);
		        
		        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
		        map.setCenter(coords);
		    } 
		});    
	}
	
	var locs = ${locs};
	
	locs.forEach(function(loc, index) {
		var mapDiv = makeMapDiv();
		if(index != 0 && index % 3 == 0) {
			mapDiv.style.clear = 'both';
		} else {
			mapDiv.style.float = 'left';
		}
		document.querySelector('#container').appendChild(mapDiv);
		addressSearch(loc.address, mapDiv, loc.title);
	})
	
	var page = ${page};
	var maxPage = ${maxPage};
	if(page >= maxPage) {
		document.querySelector('#moreBtn').style.display = 'none';
	}
	
	document.querySelector('#moreBtn').onclick = function() {
		$.ajax({
			url:'moreLocation',
			type:'get',
			async:true,
			data:{page:page+1},
			success:function(result) {
				var locs = JSON.parse(result);
				locs.forEach(function(loc, index) {
					var mapDiv = makeMapDiv();
					document.querySelector('#container').appendChild(mapDiv);
					addressSearch(loc.address, mapDiv, loc.title);
				})
				page++;
				if(page >= maxPage) {
					document.querySelector('#moreBtn').style.display = 'none';
				}
			}
		})
	}
</script>
</body>
</html>
