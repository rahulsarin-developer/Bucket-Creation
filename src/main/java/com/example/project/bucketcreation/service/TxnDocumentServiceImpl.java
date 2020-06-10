package com.example.project.bucketcreation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.bucketcreation.utility.S3Utility;

@Service
public class TxnDocumentServiceImpl implements TxnDocumentService {

	@Autowired
	private S3Utility s3Utility;
	
	@Override
	public String createBucket(String bucketName) {
		return s3Utility.createBucket(bucketName.toLowerCase());
	}
}
