package com.palani.PoultryAssist.Schedular;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.palani.PoultryAssist.Model.HatchingDetails;
import com.palani.PoultryAssist.Repository.HatchingDetailsRepository;
import com.palani.PoultryAssist.Service.AWSSNSService;
import com.palani.PoultryAssist.Service.EmailSendService;

@Component
public class HatchingAlertSchedular {
	
	@Autowired
	private HatchingDetailsRepository hatchingRepo;
	@Autowired
	private AWSSNSService sms;
	@Autowired
	private EmailSendService email;

	@Scheduled(cron = "0 0 9 ? * *")
	public void dailyHatchingAlert()
	{
		java.util.Date hatchingDate = new java.util.Date();
		
		List<HatchingDetails> hatchingDetailsList = hatchingRepo.findByHatchingDate(new Date(hatchingDate.getTime()));
		for(HatchingDetails hatchingDetails:hatchingDetailsList)
		System.out.println(hatchingDetails.toString());
	}
	@Scheduled(cron = "0 */2 * * * *")
	public void dailyLoadingEndAlert()
	{
		java.util.Date hatchingDate = new java.util.Date();
		
		List<HatchingDetails> loadingEndDetailsList = hatchingRepo.findByLoaderEndDate(new Date(hatchingDate.getTime()));
		for(HatchingDetails loadingEndDetails:loadingEndDetailsList)
		{
			//sms.sendSms("+919487994206","Your Egg Loading Date Ends Today breedName: "+loadingEndDetails.getBreedName());
			email.sendMail("desikan1299@gmail.com", "Hi Desikan J,\nKindly transfer "+loadingEndDetails.getBreedName()+" egg from loder to hatcher.\nRegards,PPP Farm.", "Egg Loader End Alert");
		}
	}
}
