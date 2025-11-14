package test.demo;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFieldDetails  {

    public static FormDetailModel[] readData(String filePath) throws IOException {
    	XSSFWorkbook book = new XSSFWorkbook(filePath);
        XSSFSheet sheet1 = book.getSheetAt(0);

        int rowNum1 = sheet1.getLastRowNum()+1;
        System.out.println("rownum:" +rowNum1);
        
        String[] url = new String[rowNum1-1];
        Map<String, FormDetailModel> models = new LinkedHashMap<>();
        for (int i = 1; i < rowNum1; i++) {
            XSSFRow row = sheet1.getRow(i);
            XSSFCell formurlcell = row.getCell(1);
            String formurl = formurlcell.getStringCellValue();
            XSSFCell idcell = row.getCell(2);
            String id = idcell.getStringCellValue();
            
            if(!formurl.isEmpty()) {
            	 
                url[i-1] = formurl;
            
            }
            FormDetailModel formModel = new FormDetailModel();
            formModel.setUrl(formurl);
            formModel.setId(id);
            models.put(id, formModel);
            System.out.println("URL" +url[i-1]);
        }
        XSSFSheet sheet2 = book.getSheetAt(1);

        int rowNum2 = sheet2.getLastRowNum()+1;
        System.out.println("rownum:" +rowNum2);
        
        String[] formfieldkey = new String[rowNum2-1];
        String[] formfieldtype = new String[rowNum2-1];

        for (int i = 1; i < rowNum2; i++) {
            XSSFRow row = sheet2.getRow(i);
            XSSFCell fieldKeycell = row.getCell(0);
            String fieldKey = fieldKeycell.getStringCellValue();
            if(!fieldKey.isEmpty()) {
            	 formfieldkey[i-1] = fieldKey;
            	 XSSFCell fieldtypecell= row.getCell(1);
		         String fieldtype = fieldtypecell.getStringCellValue();
	             formfieldtype[i-1] = fieldtype;
	             XSSFCell formidcell = row.getCell(2);
	             String formid = formidcell.getStringCellValue();
	             XSSFCell fieldvaluecell = row.getCell(3);
	             String fieldvalue = fieldvaluecell.getStringCellValue();
	             
	             FormDetailModel formModel = models.get(formid);
	             List<FieldDetails> fieldDetails = formModel.getfieldDetils();
	             FieldDetails aField = new FieldDetails();
	             aField.setFieldKeys(fieldKey);
	             aField.setFieldValues(fieldvalue);
	             aField.setFileldTypes(fieldtype);
	             fieldDetails.add(aField);
	            } 
            System.out.println("key:" +formfieldkey[i-1]);
            System.out.println("type: " +formfieldtype[i-1]);
         } 
       
                book.close();
        FormDetailModel[] modelsArray = new FormDetailModel[models.size()];
        int index = 0;
        Iterator<String> formIds = models.keySet().iterator();
        while (formIds.hasNext()) {
        	FormDetailModel aModel = models.get(formIds.next());
        	modelsArray[index] = aModel;
        	index++;
        }
        
        return modelsArray;

            }
    
}
