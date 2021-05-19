package assignment.readfile.model;

import java.io.BufferedReader;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.annotation.Id;



import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of= {"docId"})
public class Data {
	String docType;
	int companyId;
	LocalDate date;
	@Id
	int docId;
	String sign;
	int amount;
	
	public Data(String docType, int companyId, LocalDate date, int docId, String sign, int amount) {
		this.docType = docType;
		this.companyId = companyId;
		this.date = date;
		this.docId = docId;
		this.sign = sign;
		this.amount = amount;
	}
	
	
	
	public Data createData(String s) {
		//System.out.println("str: "+s);
		String docType = s.substring(0,1);
		int companyId = Integer.parseInt(s.substring(1, 10));
		LocalDate d = LocalDate.of(Integer.parseInt(s.substring(10, 14)), Integer.parseInt(s.substring(14, 16)), Integer.parseInt(s.substring(16, 18)));
		int docId = Integer.parseInt(s.substring(18, 27));
		String sign = s.substring(27, 28);
		int amount = Integer.parseInt(s.substring(28,38));
		Data data2 = new Data(docType,companyId,d,docId, sign,amount);
		return data2;
	}
	
	public List<Data> readFileData(BufferedReader br) {
		return br.lines()
				.filter(f -> !f.isEmpty())
				.map(s -> createData(s))
				.collect(Collectors.toList());
	}

}