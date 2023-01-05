<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- jQuery -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<!-- iamport.payment.js -->
<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
<script type="text/javascript">
	const IMP = window.IMP; // 생략 가능
	IMP.init("imp82348088"); // 예: imp00000000a
	function importTest() {
		IMP.request_pay({
			pg: "kcp.T0000",
			//pg : "kakaopay.TC0ONETIME",
			pay_method : "card",
			merchant_uid : "ORD20180131-0000011", // 주문번호
			name : "노르웨이 회전 의자",
			amount : 10, // 숫자 타입
			buyer_email : "gildong@gmail.com",
			buyer_name : "홍길동",
			buyer_tel : "010-4242-4242",
			buyer_addr : "서울특별시 강남구 신사동",
			buyer_postcode : "01181"
		}, function (rsp) { // callback
		      $.ajax({
		    	  method: "post",
		    	  url: "importEnd",
		    	  headers: { "Content-Type": "application/json" },
		    	  data:{
		    		  imp_uid: rsp.imp_uid,
			          merchant_uid: rsp.merchant_uid
		    	  }
		      }).done(function (data)){
		    	  console.log(data);
			        if(rsp.paid_amount == data.response.amount){
				       	alert("결제 및 결제검증완료");
			        } else {
			        	alert("결제 실패");
			        }
		}.fail(function (err)){
			alert("결제검증 실패"+err.error)
		}
			})
		}
</script>
<title>Insert title here</title>
</head>
<body>
	<button onclick='importTest()'>결제 테스트</button>
</body>
</html>