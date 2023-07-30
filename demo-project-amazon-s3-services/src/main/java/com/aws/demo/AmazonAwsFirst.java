package com.aws.demo;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class AmazonAwsFirst
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

      //  final AmazonS3 amazons3= AmazonS3ClientBuilder.standard().build();
        BasicAWSCredentials awsCredentials=new BasicAWSCredentials("acceskey","secretkey");
        final AmazonS3ClientBuilder amazons3=AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(awsCredentials));
        final AmazonS3 amazons= amazons3.build();
        List<Bucket> bucket=amazons.listBuckets();
        bucket.stream().forEach(buck->{
            System.out.println("bucketname:"+buck.getName()+",bucketowner "+buck.getOwner().getDisplayName()+",bucket creationdate"+buck.getCreationDate());
        });
    }
}
