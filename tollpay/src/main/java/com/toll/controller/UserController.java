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
import com.toll.domain.RfId;
import com.toll.domain.User;
import com.toll.domain.Vehical;
import com.toll.dto.RfIdDto;
import com.toll.dto.UserDto;
import com.toll.repository.RfIdRepository;
import com.toll.repository.UserRepository;
import com.toll.repository.VehicalRepository;
import com.toll.service.UserService;
import com.toll.util.DandelionHelper;

@Controller("userController")
@RequestMapping(value = "/rfId")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private VehicalRepository VehicalRepository;
	
	@Autowired
	private RfIdRepository rfIdRepository;
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public DatatablesResponse<RfIdDto> list(@DatatablesParams DatatablesCriterias datatablesCriterias) {
			Page<RfId> page = null;
			Pageable pageable = DandelionHelper.buildPageable(datatablesCriterias);
			if (!StringUtils.isBlank(datatablesCriterias.getSearch())) {
				page = rfIdRepository.findByVehicalNoLikeIgnoreCase("%"+datatablesCriterias.getSearch().toLowerCase() +"%", pageable); 
			}
			else {
				page = rfIdRepository.findAll(pageable);
			}
			DataSet<RfIdDto> userDataSet = new DataSet<>(getRfIdDtoList(page.getContent()), page.getTotalElements(), page.getTotalElements());
	        return DatatablesResponse.build(userDataSet, datatablesCriterias);
		
    }
	
	@RequestMapping(value = "/get-user-by-rfid", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void GetByRfId(@RequestParam("rfid") Long id) {
			//return null;
		
    }
	
	private List<RfIdDto> getRfIdDtoList(List<RfId> rfIds) {
        List<RfIdDto> rfIdDtoList = new ArrayList<>();
        for (RfId rfId : rfIds) {
        	RfIdDto userDto = new RfIdDto(rfId.getId(), rfId.getRfId(), rfId.getVehical().getVehicalNo());
        	rfIdDtoList.add(userDto);
        }
        return rfIdDtoList;
    }
	
}
