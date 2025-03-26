package com.lmd.web.restServices;

//@RestController
//@Slf4j
public class MultipartWS {

	//@Autowired
	//UtilService uServ;
	/**
	 * To download images
	 */
	
	
	//@GetMapping("/downloadFile")
	/*public ResponseEntity<?> downloadFiles(@RequestParam("path") String fileName, HttpServletRequest request) {
		// Load file as Resource
		//System.err.println(fileName);
		log.info(fileName);
		Resource resource = uServ.loadFileAsResource(fileName.substring(fileName.lastIndexOf(Media.SEPARATOR) + 1),
				fileName.substring(0, fileName.lastIndexOf(Media.SEPARATOR)));
		// Try to determine file's content type
		String contentType = null;
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		} catch (IOException ex) {
			log.info("Could not determine file type.");
		}

		// Fallback to the default content type if type could not be determined
		if (contentType == null) {
			contentType = "application/octet-stream";
		}

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION,
						Media.HEAD_I.concat(resource.getFilename()))
				.body(resource);
	}*/
}
