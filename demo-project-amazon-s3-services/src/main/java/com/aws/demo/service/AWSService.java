package com.aws.demo.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service("AWSService")
public class AWSService {

    private AmazonS3 s3;
    @PostConstruct
    public void init()
    {
        s3= AmazonS3ClientBuilder.standard().build();
    }
    public List<Bucket> getBucket()
    {
        List<Bucket> bucket=s3.listBuckets();
       return   bucket;
    }
    public S3Object getObject(String bucketName,String key)
    {
        S3Object object=s3.getObject(bucketName,key);
        return object;
    }
    public Bucket createBucket(String bucketName)
    {
        return s3.createBucket(bucketName);
    }
}
