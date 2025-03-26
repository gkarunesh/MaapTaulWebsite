package com.lmd.web.restServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmd.web.entity.GrievanceModel;
import com.lmd.web.service.GrievanceService;
import com.lmd.web.service.MessagingService;

import lombok.extern.slf4j.Slf4j;

//@RestController
//@RequestMapping("/grievance")
//@Slf4j
public class GrievanceRestCtrl {

	//@Autowired
	//GrievanceService grievanceService;

	//@Autowired
	//MessagingService mSer;

	// private EmailService emailService; javamailsender

	// public GrievanceRestCtrl(EmailService emailService) {
	// this.emailService = emailService;
	// }

	/***************View All Grievance ******************* */
	/*@GetMapping("/view-grievance/{page}")
	public Page<GrievanceModel> grievance(@PathVariable int page) throws Exception {
		//System.out.println("start..."); 
		Page<GrievanceModel> data = grievanceService.allGrievance(page); 
		//System.err.println("All : "+data);
		return data; 
	}*/
	 
	/*************** Grievance Entry API ********************/
	/*
	 * @PostMapping(value = "/submitGrievances") public MyResponse<?>
	 * saveGrievance(@RequestBody GrievanceModel grievanceData, HttpServletResponse
	 * response) {
	 * 
	 * try { if (grievanceData != null) { //Get Local IP Addredss InetAddress
	 * localhost = InetAddress.getLocalHost(); String RemoteAddress =
	 * localhost.getHostAddress().trim();
	 * grievanceData.setAckno(grievanceData.getOtp().concat(String.valueOf(Math.
	 * round(Math.random()*(9999-1000)+1000))));
	 * grievanceData.setRemarks(RemoteAddress);
	 * grievanceData.setEntrydate(LocalDateTime.now());
	 * grievanceData.setStatus('C');
	 * grievanceData=grievanceService.grievanceData(grievanceData);
	 *//******** Create Document *************/
	/*
	 * Document document = new Document(PageSize.A4);
	 * PdfWriter.getInstance(document, response.getOutputStream()); PdfWriter writer
	 * = PdfWriter.getInstance(document, new
	 * FileOutputStream("/docupload/wmdocx/grievance/"+grievanceData.getAckno()+
	 * ".pdf")); document.open(); Font fontTiltle =
	 * FontFactory.getFont(FontFactory.TIMES_ROMAN);
	 * fontTiltle.setColor(CMYKColor.RED); fontTiltle.setSize(15); Paragraph
	 * paragraph1 = new Paragraph("Consumer Grievance", fontTiltle);
	 * paragraph1.setAlignment(Paragraph.ALIGN_CENTER); document.add(paragraph1);
	 * Paragraph paragraph2 = new Paragraph();
	 * paragraph2.setAlignment(Paragraph.ALIGN_CENTER); paragraph2.add(
	 * "---------------------------------------------------------------------------------------"
	 * ); fontTiltle.setColor(CMYKColor.RED); document.add(paragraph2);
	 * GrievanceModel grivanceAck = grievanceData; Font ackFont = new
	 * Font(Font.HELVETICA, 11, Font.BOLD, Color.DARK_GRAY); Paragraph ackParagraph
	 * = new Paragraph("Acknowledgement No : "+grivanceAck.getAckno(), ackFont);
	 * document.add(ackParagraph); Paragraph topSpace = new Paragraph(" ");
	 * document.add(topSpace); Font name1 = new Font(Font.HELVETICA, 12); Paragraph
	 * name = new Paragraph("Name of Applicant : "+grivanceAck.getName(), name1);
	 * document.add(name); Paragraph mobile = new
	 * Paragraph("Mobile Number : "+grivanceAck.getMobile()); document.add(mobile);
	 * Paragraph email = new Paragraph("Email : "+grivanceAck.getEmail());
	 * document.add(email); Paragraph address = new
	 * Paragraph("Address : "+grivanceAck.getAddress()); document.add(address);
	 * Paragraph bottomSpace = new Paragraph(" "); document.add(bottomSpace); Font
	 * font = new Font(Font.HELVETICA, 12, Font.BOLD); Paragraph grievance = new
	 * Paragraph("Grievance Details : ", font); document.add(grievance); Font gFont
	 * = new Font(Font.HELVETICA, 11, Font.NORMAL); Paragraph grievance1 = new
	 * Paragraph(grivanceAck.getGrievance(), gFont); document.add(grievance1);
	 * Paragraph dateSpace = new Paragraph(" "); document.add(dateSpace); Paragraph
	 * date2Space = new Paragraph(" "); document.add(date2Space); DateTimeFormatter
	 * formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"); String
	 * formatDateTime = grivanceAck.getEntrydate().format(formatter); Paragraph date
	 * = new Paragraph("Date : "+formatDateTime);
	 * date.setAlignment(Paragraph.ALIGN_RIGHT); document.add(date); writer.open();
	 * document.close(); writer.close();
	 *//*****************************//*
										 * //emailService.sendMailWithAttachment(grievanceData); if(grievanceData!=null)
										 * { try { mSer.sendText(MessagingModel.builder()
										 * .host(Store.requestUrlSms.val()) //.userName(Store.userName.val())
										 * .senderId(Store.senderIdSms.val()) .serviceType(Store.serviceTypeSms.val())
										 * .password(Store.passSms.val()) .mobileNo(grievanceData.getMobile())
										 * .content("You have successfully logged your grievance.\nThe grievance has been taken and forwarded to concern officer.\nIt will be commuincated within 15 working days.\n AckNo: "
										 * +grievanceData.getAckno()) .build()); // mSer.dbtText( //
										 * Params.builder().arg1(grievanceData.getMobile()) //
										 * .arg2(String.valueOf(KeyEnum.CER_APP_SUB.getTemplateId())).arg3(KeyEnum.
										 * CER_APP_SUB // .getMessage().replace("#", vendor.getVendorId()).replace("@",
										 * staffName)) // .build()); }catch (Exception e) { e.printStackTrace();
										 * log.error(e.getMessage()); return
										 * MyResponse.builder().data(grievanceData).statusCode(Http.ACCEPTED)
										 * .status("Your grievance has been sent, we will contact you soon").build(); }
										 * 
										 * } return MyResponse.builder().data(grievanceData).statusCode(Http.OK)
										 * .status("Your grievance has been sent, we will contact you soon").build(); }
										 * else { return
										 * MyResponse.builder().data("data not saved !").statusCode(Http.EXCEPTION).
										 * status(Http.FAILURE) .build(); } } catch (Exception e) { e.printStackTrace();
										 * return
										 * MyResponse.builder().data(e.getMessage()).statusCode(Http.EXCEPTION).status(
										 * Http.FAILURE).build(); } }
										 */

	/***************
	 * Grievance Count API******************* @GetMapping("/grievanceCount") public
	 * MyResponse<?> complaintCount(){ try { //List<GrivanceCounterDto> data =
	 * grievanceService.complaintCounter(); //System.out.println(data); String
	 * data="Nothing"; return
	 * MyResponse.builder().statusCode(Http.OK).data(data).build(); }catch(Exception
	 * e){ e.printStackTrace(); return
	 * MyResponse.builder().statusCode(Http.EXCEPTION).size(0).data(null).remarks(e.getMessage()).build();
	 * } }
	 */

	/***********
	 * Send Mail************ @PostMapping("/sendEmail") public String
	 * sendEmail(@RequestBody GrievanceModel grievanceData) {
	 * System.out.println(grievanceData); String status =
	 * emailService.sendSimpleMail(grievanceData); return status;
	 * } @PostMapping("/sendMailWithAttachment") public String
	 * sendMailWithAttachment(@RequestBody GrievanceModel grievanceData) { String
	 * status = emailService.sendMailWithAttachment(grievanceData); return status; }
	 */

	/**************** Save Grievance Document ******************/

	/*
	 * private static void saveGrievanceDocument() {
	 * //System.out.println("Grievance Docs : "); final String uri =
	 * "http://localhost:8585/lmd/attachment/upload"; RestTemplate restTemplate =
	 * new RestTemplate(); String result = restTemplate.getForObject(uri,
	 * String.class); //System.out.println(result); }
	 */
}
