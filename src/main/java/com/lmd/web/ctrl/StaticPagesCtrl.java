package com.lmd.web.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaticPagesCtrl {
	
	@GetMapping("/")
    public String getHomePage(){
        return "home";
    }
	
	@GetMapping("/Introduction")
	public String intro() {
		return "introduction";	
	}
	
	@GetMapping("/OrgChart")
	public String orgChart() {
		return "org-chart";	
	}
	
	@GetMapping("/whoIswho")
	public String officers() {
		return "whoIsWho";	
	}
	
	@GetMapping("/central-lab")
	public String labs() {
		return "centralLab";	
	}
	
	@GetMapping("/circular")
	public String notificationcircular() {
		return "notifications";
	}
	
	@GetMapping("rtps-report")
	public String report() {
		return "rtps_report";	
	}
	
	@GetMapping("/RateUs")
	public String rating() {
		return "rate-us";
	}
	
	@GetMapping("/events")
	public String eventCalendar() {
		return "events";	
	}
	
	@GetMapping("/form")
	public String form() {
		return "forms";	
	}
	
	@GetMapping("/letters")
	public String impLetter() {
		return "importantLetters";	
	}
	
	@GetMapping("/actAndRules")
	public String rules() {
		return "actsAndRules";
	}
	
	@GetMapping("/RTI")
	public String rti() {
		return "RTI";
	}
	
	@GetMapping("/Gallery")
	public String gallery() {
		return "Gallery";
	}
	
	@GetMapping("/lodge-grievance")
	public String grievanceEntry() throws Exception {
		 return "grievance-entry";
	}
	
	@GetMapping("/view-grievances")
	public String grievance() throws Exception {
		 return "view-grivance";
	}
	
	@GetMapping("/complaint-counter")
	public String complaincounter() {
		return "complaint-counter";
	}
	
	@GetMapping("/ViewFedback")
	public String feedback() {
		return "viewFeedback";
	}
	
	@GetMapping("/CompoundingOffense")
	public String offence() {
		return "compoundingOffense";
	}
	
	@GetMapping("/sitemap")
	public String sitemap() {
		return "sitemap";
	}
	
	@GetMapping("/TermsOfUse")
	public String terms() {
		return "termsOfUse";
	}
	
	@GetMapping("/Disclaimer")
	public String disclaimer() {
		return "disclaimer";
	}
	
	@GetMapping("/FAQs")
	public String faq() {
		return "faq";
	}
	
	@GetMapping("/newsClip")
	public String news() {
		return "news";
	}
	
	@GetMapping("/posting")
	public String transfers() {
		return "transfer-posting";
	}
	
	@GetMapping("/sLetter")
	public String sanctionLetters() {
		return "schemeSanctionLetters";
	}
	
	@GetMapping("/Tenders")
	public String tenderInfo() {
		return "tenderInformation";
	}
	
	@GetMapping("/ContactUs")
	public String contact() {
		return "ContactUs";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@GetMapping("/uploadDoc")
	public String AttachmentPage() {
		return "AttachmentEntry";
	}
	
	@GetMapping("/manageAttachment")
	public String verify() {
		return "manager";
	}
	
	@GetMapping("/w&m-certified-service-providers")
	public String dealers() {
		return "service-provider-list";
	}
}
