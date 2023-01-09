package org.zerock.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.iamport.ImportPaymentCheck;

import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class ImportTestController {
	
	@Inject
	private ImportPaymentCheck impApi;
	
	@GetMapping("/importTest")
	public String importView() {
		
		return "import/Import_kakaopayTest";
	}
	
	@PostMapping("/importEnd/{imp_uid}")
	@ResponseBody
	public IamportResponse<Payment> paymentCheckByImp_Uid(@PathVariable("imp_uid") String imp_uid){
		IamportResponse<Payment> result;
		log.info(impApi);
		try {
			result = impApi.paymentCheck(imp_uid);
			log.info(result.getResponse().getAmount());
		} catch (Exception e) {
			log.error(e);
			return result=null;
		}
		return result;
	}
}
