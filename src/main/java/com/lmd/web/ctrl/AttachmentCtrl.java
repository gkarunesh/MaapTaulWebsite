package com.lmd.web.ctrl;

//@RestController
//@RequestMapping("/api")
//@CrossOrigin("*")
//public class AttachmentCtrl {
	
	//@Autowired
	//private AttachmentService attachmentService;
	
	/*@GetMapping("/all") 
	  public MyResponse<?> attachments() throws Exception {
		 List<Attachments> data = attachmentService.allAttachments();
		 //System.out.println(data); 
		return MyResponse.builder().statusCode(Http.OK).size(data.size()).data(data).build(); 
	}*/
	
	/*@GetMapping("/event") 
	  public MyResponse<?> eventAttachments() throws Exception {
		 String  event = "events";
		 List<Attachments> data = attachmentService.getAttachments(event);
		 //System.out.println("Attachment Data : "+data); 
		return MyResponse.builder().statusCode(Http.OK).size(data.size()).data(data).build(); 
	}*/
	
	/*@GetMapping("/{docs}") 
	public MyResponse<?> kindOf(@PathVariable(name = "docs") String kindOf) {
		//System.out.println("Data variable: "+kindOf);
		try {
			List<Attachments> data = attachmentService.getAttachments(kindOf);
			//System.out.println("Page Data :"+data);
			return MyResponse.builder().statusCode(Http.OK).status(Http.SUCCESS).size(data.size()).data(data).build();
		} catch (Exception e) {
			e.printStackTrace();
			return MyResponse.builder().statusCode(Http.EXCEPTION).status(Http.FAILURE).size(0).data(e.getMessage())
					.build();
		}
	}*/
//}
