package com.example.project.bucketcreation.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CreateBucketRequest;
import com.amazonaws.services.s3.model.GetBucketLocationRequest;

@Component
public class S3Utility {

	@Autowired
	private AmazonS3 s3Client;

	/**
	 * createBucket
	 * 
	 * @param bucketName
	 */
	public String createBucket(String bucketName) {
		if(!s3Client.doesBucketExistV2(bucketName)) {
			s3Client.createBucket(new CreateBucketRequest(bucketName));
			s3Client.getBucketLocation(new GetBucketLocationRequest(bucketName));
			return "Bucket Created";
		}
		return "Bucket Already Exist";
	}
}
