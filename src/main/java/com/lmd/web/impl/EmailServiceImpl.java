package com.lmd.web.impl;

/*@Service
public class EmailServiceImpl implements EmailService{
	
	//@Autowired 
	//private JavaMailSender javaMailSender;
	
	//@Value("${spring.mail.username}")
	//private String sender;
	
	
	/*
	 * @Override public String sendSimpleMail(GrievanceModel grievanceData) { try {
	 * 
	 * // Creating a simple mail message SimpleMailMessage mailMessage = new
	 * SimpleMailMessage();
	 * 
	 * // Setting up necessary details mailMessage.setFrom(sender);
	 * mailMessage.setTo(grievanceData.getRecipient());
	 * mailMessage.setSubject(grievanceData.getNature());
	 * mailMessage.setFrom(grievanceData.getName());
	 * mailMessage.setText("Respected Sir/Madam, \n\n" +
	 * "We hope you're having a great day!\n" + grievanceData.getGrievance() +"\n"
	 * +"Your Faithfully,\n" +"Name : "+ grievanceData.getName()+ "\n"
	 * +"Mobile : "+grievanceData.getMobile()+"\n"
	 * +"Email : "+grievanceData.getEmail());
	 * 
	 * // Sending the mail javaMailSender.send(mailMessage); return
	 * "Mail Sent Successfully..."; } catch (Exception e) { return
	 * "Error while Sending Mail"; } }
	 */
	
	/*public String sendMailWithAttachment(GrievanceModel grievanceData)
    {
        // Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
 
        try {
        	mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            //mimeMessageHelper.setTo(grievanceData.getRecipient());
            mimeMessageHelper.setSubject(grievanceData.getNature());
            mimeMessageHelper.setFrom(grievanceData.getName());
            mimeMessageHelper.setText("Respected Sir/Madam, \n\n" 
                    + "We hope you're having a great day!" +"\n"
                    + grievanceData.getGrievance() +"\n\n"
                    +"Your Faithfully,\n"
                    +"Name : "+ grievanceData.getName()+ "\n" 
                    +"Mobile : "+grievanceData.getMobile()+"\n"
                    +"Email : "+grievanceData.getEmail());
            // Adding the attachment
            FileSystemResource file = new FileSystemResource("C:/docupload/wmdocx/grievance/"+grievanceData.getAckno()+".pdf");
            //FileSystemResource file = new FileSystemResource(new File(grievanceData.getAttachment()));
            mimeMessageHelper.addAttachment(file.getFilename(), file);
            // Sending the mail
            javaMailSender.send(mimeMessage);
            return "Your grievance has been sent, we will contact you soon";
        }
        // Catch block to handle MessagingException
        catch (MessagingException e) {
        	return "Error while sending mail!!!";
        }
    }
	
}*/
