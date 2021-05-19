package assignment.readfile.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;

import assignment.readfile.dto.DataResponseDto;
import assignment.readfile.model.Data;

@Service
public class DataServiceImpl implements DataService{

	public DataResponseDto dataToDataResponseDto(Data data) {
		return DataResponseDto.builder().docType(data.getDocType()).companyId(data.getCompanyId())
				.date(data.getDate()).docId(data.getDocId()).sign(data.getSign()).amount(data.getAmount())
				.build();
	}
	@Override
	public List<DataResponseDto> getAllData() {
		try(BufferedReader br = new BufferedReader(new FileReader("data.txt"))){
			Data data = new Data();
			List<Data> dataList = new ArrayList<>();
			dataList = data.readFileData(br);
			return dataList
					.stream()
					.map(this::dataToDataResponseDto)
					.collect(Collectors.toList());
						
		}catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
