package com.toll.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.dandelion.datatables.core.ajax.DataSet;
import com.github.dandelion.datatables.core.ajax.DatatablesCriterias;
import com.github.dandelion.datatables.core.ajax.DatatablesResponse;
import com.github.dandelion.datatables.extras.spring3.ajax.DatatablesParams;
import com.toll.domain.User;
import com.toll.dto.UserDto;
import com.toll.repository.UserRepository;
import com.toll.service.UserService;
import com.toll.util.DandelionHelper;

@Controller("userController")
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;	
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public DatatablesResponse<UserDto> list(@DatatablesParams DatatablesCriterias datatablesCriterias) {
			System.out.println(datatablesCriterias);
			Page<User> page = null;
			Pageable pageable = DandelionHelper.buildPageable(datatablesCriterias);
			page = userRepository.findAll(pageable);
	        
	        System.out.println("PsgSiz :"+page.getSize());
	        DataSet<UserDto> userDataSet = new DataSet<>(getUserDtoList(page.getContent()), page.getTotalElements(), page.getTotalElements());
	        return DatatablesResponse.build(userDataSet, datatablesCriterias);
		
    }
	
	@RequestMapping(value = "/get-user-by-rfid", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void GetByRfId(@RequestParam("rfid") Long id) {
			//return null;
		
    }
	
	private List<UserDto> getUserDtoList(List<User> users) {
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : users) {
        	System.out.println(user.getFirstName());
            UserDto userDto = new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getAge());
            userDtoList.add(userDto);
        }
        return userDtoList;
    }
	
}
