package assignment.readfile.dto;

import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataResponseDto {
	String docType;
	int companyId;
	LocalDate date;
	int docId;
	String sign;
	int amount;
}
