package assignment.readfile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import assignment.readfile.service.DataService;
import assignment.redfile.dto.DataResponseDto;


@RestController
public class DataController {
	
	@Autowired
	DataService dataService;


	@GetMapping("/data")
	public List <DataResponseDto> getAllDataResponseDtos() {
		System.out.println("controler");
		return dataService.getAllData();
	}


}
