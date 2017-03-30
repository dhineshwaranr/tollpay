package com.toll.util;

import java.util.UUID;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.toll.domain.Address;
import com.toll.domain.RTO;
import com.toll.domain.RfId;
import com.toll.domain.User;
import com.toll.domain.Vehical;
import com.toll.domain.Vehical.VehicalType;
import com.toll.repository.RTORepository;
import com.toll.repository.RfIdRepository;
import com.toll.repository.UserRepository;
import com.toll.repository.VehicalRepository;

@Component
public class DefaultDataInitializer implements InitializingBean{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private VehicalRepository vehicalRepository;
	
	@Autowired
	private RfIdRepository rfIdRepository;
	
	@Autowired
	private RTORepository rtoRepository;
	
	private static final String FIRST_NAME = "Test_user_";
	private static final String LAST_NAME = "";
	private static final int AGE = 20;
	
	private static final String VEHICAL_START_LETTER = "TN";
	private static final String VEHICAL_MIDDLE_LETTER = "A";
	private static final Long VEHICAL_END_NUMBER = 0L;

	@Override
	public void afterPropertiesSet() throws Exception {
		runAddressAndRTO();
		runMeFirst();
		runMeSecond();
	}
	
	private void runAddressAndRTO() {
		RTO isRtoAvailable = rtoRepository.findOne(1L);
		if(isRtoAvailable == null) {
			for(int i = 0 ; i <= 20 ; i++){
				Address address = new Address();
				RTO rto = new RTO();
				address.setLine1("Line 1_"+String.valueOf(i));
				address.setLine2("Line 2_"+String.valueOf(i));
				address.setLine3("Line 3_"+String.valueOf(i));
				address.setLine4("Line 4_"+String.valueOf(i));
				address.setCity("City_"+String.valueOf(i));
				address.setState("State_"+String.valueOf(i));
				address.setCountry("Country_"+String.valueOf(i));
				rto.setAddress(address);
				rtoRepository.save(rto);
			}
		}
	}
	
	private void runMeFirst(){
		User isUserAvailable = userRepository.findOne(1L);
		if(isUserAvailable == null){
			for(int i = 0 ; i <= 20 ; i++){
				User user = new User();
				user.setFirstName(FIRST_NAME+i);
				user.setLastName(String.valueOf(i));
				user.setAge(AGE+i);
				userRepository.save(user);
			}
		}
	}
	
	private void runMeSecond(){
		Vehical isVehicalAvailable = vehicalRepository.findOne(1L);
		if (isVehicalAvailable == null) {
			for(Long i = 0L ; i <= 20 ; i++){
				User user = userRepository.findOne(i+1);
				RTO rto = rtoRepository.findOne(i+1);
				Vehical vehical = new Vehical();
				RfId rfId = new RfId();
				vehical.setManufacturer("Vehical_Manufacture_"+i);
				vehical.setVehicalNo(VEHICAL_START_LETTER +" "+ i +" "+ VEHICAL_MIDDLE_LETTER +" "+ getVehicalEndNo(i));
				vehical.setUser(user);
				vehical.setAllowed(true);
				vehical.setAnyCrimicalCase(true);
				vehical.setTotalCapacity(4L);
				vehical.setType(VehicalType.CAR);
				vehical.setRto(rto);
				
				vehical = vehicalRepository.save(vehical);
				
				rfId.setVehical(vehical);
				rfId.setRfId(generateRandomRfId());
				
				rfIdRepository.save(rfId);
			}
		}
	}
	
	public Long getVehicalEndNo(Long no) {
		return VEHICAL_END_NUMBER + no;
	}
	
	public String generateRandomRfId() {
		return UUID.randomUUID().toString();
	}
}
