서버에서 엑셀 파일을 생성하여 다운로드할 경우, DRM 암호화가 적용된 상태로 다운로드 해야하는 경우는 FileUtils의 encryptDrm 메소드를 사용하여 리소스를 암호화하여 반환할 수 있다.

```java
@RestController
@Profile({ ProfileSupport.LOCAL_PROFILE, ProfileSupport.DEV_PROFILE })
public class SampleExcelConversionController {
	
	@Autowired private UstraCodeService codeService;
	@Autowired private FileOperationManager fileOperationManager;
	
	
	@RequestMapping("/api/sample/excel/download")
	public ResponseEntity<?> convertWithDrm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		List<UstraCodeModel> codes = codeService.getCodes("SYS_CD");
		
		ResponseEntity<?> entity = (ResponseEntity<?>)fileOperationManager
				.convert(DataToExcelWebResourceConverter
						.entityBuilder(
								codes,
								UstraCodeModel.class,
								"sample.xlsx",
								request,
								response)
						.option((option)->{
							
							UstraExcelCellInfoModel cell1 = new UstraExcelCellInfoModel();
							cell1.setName("dtlCd");
							cell1.setCol(0);
							cell1.setHeader("코드");
							cell1.setCellType(UstraExcelCellType.TEXT);
							
							UstraExcelCellInfoModel cell2 = new UstraExcelCellInfoModel();
							cell2.setName("cdNm");
							cell2.setCol(1);
							cell2.setHeader("코드 값");
							cell2.setCellType(UstraExcelCellType.TEXT);
							
							option.setCells(Arrays.asList(cell1, cell2));
						})
						.build());
		
		
		Resource encryptedResource = FileUtils.encryptDrm((Resource)entity.getBody());
		
		return ResponseEntity.ok()
				.headers(entity.getHeaders())
				.contentLength(encryptedResource.contentLength())
				.body(encryptedResource);
		
	}
	
}
```
