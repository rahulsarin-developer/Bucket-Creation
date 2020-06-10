package com.example.project.bucketcreation.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.bucketcreation.service.TxnDocumentService;

@RestController
@RequestMapping("/api/v1/aws")
public class TxnDocumentController {

	@Autowired
	private TxnDocumentService txnDocumentService;
	
	@PostMapping(value = "/createBucket")
	public Map<String, Object> createBucket(@RequestParam("bucketName") String bucketName) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Status", txnDocumentService.createBucket(bucketName));
		return map;
	}
}