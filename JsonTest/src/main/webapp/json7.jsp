<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(function() {
		let jsonStr = `{
			"data": [{
			    		"type": "articles",
			    		"id": "1",
			    		"attributes": {
			      			"title": "JSON:API paints my bikeshed!",
			      			"body": "The shortest article. Ever.",
			      			"created": "2015-05-22T14:56:29.000Z",
			      			"updated": "2015-05-22T14:56:28.000Z"
			    		},
			    		"relationships": {
			    	  		"author": {
			        			"data": {"id": "42", "type": "people"}
			      			}
			    		}
			  		}
			  	],
			"included": [{
			      			"type": "people",
			      			"id": "42",
			      			"attributes": {
			        			"name": "John",
			        			"age": 80,
			        			"gender": "male"
			      			}
			    		}]
		}`;
			
		//- JSON 데이터 parse 처리해서 가져오기
		//ex) included의 attributes 가져오기
		let jsonObj = JSON.parse(jsonStr);
		let included = jsonObj.included;
		let included_0 = included[0];
		let attributes = included_0.attributes;
		console.log(attributes.name);
		console.log(attributes.age);
		console.log(attributes.gender);
		
		//ex) data의 relationships의 author의 data 가져오기
		let data = jsonObj.data[0].relationships.author.data;
		console.log(data.id);
		console.log(data.type);
	
		
		//- JSON 데이터 백앤드로 보낸 후 백앤드에서 parse 처리
		$.ajax({
			url:'json7',
			type:'post',
			async:true,
			data:{data:jsonStr},
			success:function(result){
				
			}
		})
	})
</script>
</head>
<body>

</body>
</html>