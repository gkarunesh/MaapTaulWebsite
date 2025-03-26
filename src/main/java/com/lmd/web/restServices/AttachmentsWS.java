package com.lmd.web.restServices;

//@RestController
//@RequestMapping("/attachment")
public class AttachmentsWS {
	
	//@Autowired
	//AttachmentService attachmentServ;
	
	//@Autowired
	//LmdWebSequnce LmdWebSequnce;
	
	//@Autowired
	//UtilService<?> uServ;
	
	//@Autowired
	//ExecutiveDashboardService hOfficialServ;
	
	//@Autowired
	//GrievanceService grivanceService;
	
	//@Autowired
	//AuthenticateCtrl authenticateCtrl;
	
	//@Autowired
	//StaffService officersService;

	/*public static Instant getDateFromString(String string)
    {
       Instant timestamp = null; 
       timestamp = Instant.parse(string); 
       return timestamp;
    }*/
	
	
	//@RequestMapping(path = "/uploadAttachments", method = RequestMethod.POST, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	/*public MyResponse<?> uploadAttachments(@RequestParam String str, @RequestParam String date, @RequestPart MultipartFile file, HttpSession session) {
		MyResponse<?> response = null;
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String date2=date.split("T")[0];
			LocalDate localDate = LocalDate.parse(date2.replaceAll("\'", "").replaceAll("\"", ""),formatter).plusDays(1);
			Attachments Attachmentsmodel=new Gson().fromJson(str,Attachments.class);
			Attachmentsmodel.setEntryDate(localDate);
			Attachmentsmodel.setAttachmentid(String.valueOf(String.valueOf(Math.round(Math.random() * (999999 - 100000) + 100000))));
			Attachmentsmodel.setIsNew('N');
			Attachmentsmodel.setFileType("pdf");
			//System.out.println(authenticateCtrl.getUser());
			//Attachmentsmodel.setUserId(authenticateCtrl.getUser());
			//Attachments attachmentRes=attachmentServ.addAttachments(Attachmentsmodel);
			
			LocalDate cal=LocalDate.now();
			//String dynamicPath = Store.baseUrl.val().concat(String.valueOf(cal.getYear())).concat(Media.SEPARATOR).concat(Attachmentsmodel.getKindOf());
			String dynamicPath = null;
			String fileDestination = dynamicPath;
			String ext = FilenameUtils.getExtension(file.getOriginalFilename());
			String filename = String.valueOf(Attachmentsmodel.getAttachmentid()).concat("." + ext);
			System.out.println("FileDetination :"+fileDestination);
			UploadedFileResponse uResponse = uServ.copyFile(file, fileDestination, filename);
			//attachmentRes.setSourceUrl(Media.DOWNLOAD_URL_PRE.concat(fileDestination)
					//.concat(Media.SEPARATOR).concat(uResponse.getFileName()));
			//Attachments attachments = attachmentServ.addAttachments(attachmentRes);
			//response = MyResponse.builder().data(attachments).status(Http.SUCCESS).remarks("Successfully submited").statusCode(Http.OK).build();
		} catch (Exception e) {
			e.printStackTrace();
			// log.error(e.getMessage());
			response = MyResponse.builder().remarks(e.getMessage()).status("Something went wrong !").statusCode(Http.EXCEPTION).build();
		}
		return response;
	}
	
	//@GetMapping("/view-uploads")
	//public MyResponse<?> GetUploadedData() throws Exception {
		char isNew = 'N'; 
		//List<Attachments> data = attachmentServ.newAttachments(isNew);
		//System.out.println(data);
		//return MyResponse.builder().statusCode(Http.OK).size(data.size()).data(data).build();
		
	//}
	
	/*@PostMapping("/change-attachment-status/{attachmentId}/{status}/{verifier}")
	public MyResponse<?> changeAttachmentStatus(@PathVariable String attachmentId,@PathVariable char status, @PathVariable String verifier ) throws Exception {
		try {
			Attachments attachment=null;
				Optional<Attachments> verData = attachmentServ.findAttachments(attachmentId);
				//System.out.println(verData);
				if(verData.isPresent()) {
					attachment=verData.get();
					attachment.setIsNew(status);
					attachment.setUserId(verifier);
					attachment=attachmentServ.addAttachments(attachment);
					return MyResponse.builder().statusCode(Http.OK).data(attachment).build();
				}else {
					return MyResponse.builder().statusCode(Http.ACCEPTED).data(null).remarks("Attachment data not Found !").build();
				}
				
		}
		catch(Exception e) {
			e.printStackTrace();
				return MyResponse.builder().statusCode(Http.EXCEPTION).data("Error found").remarks(e.getMessage()).build();
		}
		
	}*/
	
	//@RequestMapping(path = "/uploadHigherOfficials", method = RequestMethod.POST, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	/*public MyResponse<?> uploadOfficial(@RequestParam String str,  @RequestPart MultipartFile file) {
		MyResponse<?> response = null;
		try {
			ExecutiveDashboard hOfficials=new Gson().fromJson(str,ExecutiveDashboard.class);
			//hOfficialServ.updatePreviousDesignationStatus('D', hOfficials.getDesignation());
			hOfficials.setFileName(file.getOriginalFilename());
			hOfficials.setFileType(file.getContentType());
			hOfficials.setDate(LocalDateTime.now());
			hOfficials.setStatus('A');
			ExecutiveDashboard hOfficialRes=hOfficialServ.addOfficials(hOfficials);
			LocalDate cal=LocalDate.now();
			String dynamicPath = null;
			//String dynamicPath = Store.baseUrl.val().concat(String.valueOf(cal.getYear())).concat(Media.SEPARATOR).concat(hOfficials.getDesignation());
			String fileDestination = dynamicPath;
			String ext = FilenameUtils.getExtension(file.getOriginalFilename());
			String filename = String.valueOf(hOfficials.getDesignation()).concat("." + ext);
			UploadedFileResponse uResponse = uServ.copyFile(file, fileDestination, filename);
			hOfficialRes.setSourceUrl(Media.DOWNLOAD_URL_PRE.concat(fileDestination).concat(Media.SEPARATOR).concat(uResponse.getFileName()));
			ExecutiveDashboard hOfficialRes1 = hOfficialServ.addOfficials(hOfficialRes);
			response = MyResponse.builder().data(hOfficialRes1).status(Http.SUCCESS).remarks("Successfully submited").statusCode(Http.OK).build();
		} catch (Exception e) {
			e.printStackTrace();
			// log.error(e.getMessage());
			response = MyResponse.builder().remarks(e.getMessage()).status("Something went wrong !").statusCode(Http.EXCEPTION).build();
		}
		return response;
	}
	
	@GetMapping("/getHighOfficials")
	public MyResponse<?> GetOfficialData() throws Exception {
		char status = 'A'; 
		//List<ExecutiveDashboard> data = hOfficialServ.getOfficials(status);
		//System.out.println(data);
		String data = "Nothing";
		return MyResponse.builder().statusCode(Http.OK).data(data).build();
	}
	
	/*@GetMapping("/getAllOfficersHQR")
	public MyResponse<?> GetAllOfficers() throws Exception {
		List<OfficersDtoInterface> data = officersService.officersHQR();
		 //System.err.println(data);
		 return MyResponse.builder().statusCode(Http.OK).data(data).build();
	}*/	
	
	/* @GetMapping("/users/export/pdf/{ackno}")
	 public void generatePdfFile(HttpServletResponse response, @PathVariable String ackno) throws DocumentException, IOException, FileNotFoundException 
	  {
		response.setContentType("application/pdf");
	    String headerkey = "Content-Disposition";
	    String headervalue = "inline; filename="+ ackno +".pdf";
	    response.setHeader(headerkey, headervalue);
	    Optional<GrievanceModel> grivances = grivanceService.findByAckno(ackno);
	    PdfGenerator generator = new PdfGenerator();
	    generator.generate(grivances, response); 	    
	  }*/
}
