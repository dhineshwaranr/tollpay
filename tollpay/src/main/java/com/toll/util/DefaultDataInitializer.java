package com.toll.util;

import java.util.UUID;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.toll.domain.RfId;
import com.toll.domain.User;
import com.toll.domain.Vehical;
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
	
	private static final String FIRST_NAME = "Test_user_";
	private static final String LAST_NAME = "";
	private static final int AGE = 20;
	
	private static final String VEHICAL_START_LETTER = "TN";
	private static final String VEHICAL_MIDDLE_LETTER = "A";
	private static final Long VEHICAL_END_NUMBER = 0L;

	@Override
	public void afterPropertiesSet() throws Exception {
		runMeFirst();
		runMeSecond();
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
				Vehical vehical = new Vehical();
				RfId rfId = new RfId();
				vehical.setManufacturer("Vehical_"+i);
				vehical.setVehicalNo(VEHICAL_START_LETTER +" "+ i +" "+ VEHICAL_MIDDLE_LETTER +" "+ getVehicalEndNo(i));
				vehical.setUser(user);
				
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
