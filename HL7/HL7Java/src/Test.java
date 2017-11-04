
import com.hl7.domain.Mainroot;
import com.hl7.util.HL7ParserUtils;

public class Test {
	
	
	public static void main(String args[]){
		String filePath = "G:\\workspace\\Hadoop\\HL7Java\\src\\binding\\72_ADT_A08_24-02-16_15-32-40.263.xml";
		HL7ParserUtils utils = HL7ParserUtils.getInstance();
		Mainroot root = utils.unMarshall(filePath);
	    System.out.println("Employee as XML String:"+utils.marshall(root));
	}
}
 