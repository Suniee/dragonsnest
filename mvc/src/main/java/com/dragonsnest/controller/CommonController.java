package com.dragonsnest.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class CommonController {
	
	@RequestMapping(value="/upload.nest", method=RequestMethod.GET)
	public String provideUpload() {
		return "upload";
	}
	
	@RequestMapping(value="/upload.nest", method=RequestMethod.POST)
	public @ResponseBody String handleFileUpload(
			HttpServletRequest request,
//			@RequestParam Map<String, Object> params,
			@RequestParam("file") MultipartFile file ,@RequestParam("filename") String filename,
			ModelMap model) {
		
//		MultipartFile file = (MultipartFile)params.get("file");
		System.out.println("file [" +file + "]");
//		String filename = (String)params.get("filename");
		System.out.println("filename ["+filename+"]");
		
		if(!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				BufferedOutputStream outStream = new BufferedOutputStream(new FileOutputStream(new File(filename + "upload")));
				outStream.write(bytes);
				outStream.close();
				model.addAttribute("result", "Succeeded to upload " + filename);
				
			} catch (Exception e) {
				model.addAttribute("result", "Failed to upload " + filename + "["+e.getMessage()+"]");
			}
		}
		
		return "upload";
	}
}
