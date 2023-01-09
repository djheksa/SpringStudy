package org.zerock.iamport;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

import lombok.extern.log4j.Log4j;

@Component
@Log4j
public class ImportPaymentCheck {
	private IamportClient impApi;
	
	public ImportPaymentCheck() {
		this.impApi = new IamportClient("5645704686815415", "BU0w3bHUA4xQVqTIx3fOYHvtPzIk0CrI0eabk5em05x4iAXLYJYOtuyYgeQvshRK4ET0dflulSBfSvDW");
	}
	
	public IamportResponse<Payment> paymentCheck(String imp_uid)throws IamportResponseException, IOException{
		log.info(imp_uid);
		return impApi.paymentByImpUid(imp_uid);
	}
}
