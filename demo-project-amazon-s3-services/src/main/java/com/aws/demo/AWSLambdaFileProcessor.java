package com.aws.demo;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class AWSLambdaFileProcessor  implements RequestHandler<S3Event,String> {
    public static String BUCKET_NAME = "testbucket123";
    public static String BUCKET_NAME_USING_CODE = "testbucket12323";

    @Override
    public String handleRequest(S3Event s3Event, Context context) {
        String  result="fails";
        final AmazonS3 amazons3 = AmazonS3ClientBuilder.standard().build();
        S3Object s3ob = amazons3.getObject(BUCKET_NAME, "file.txt");
        S3ObjectInputStream inputStream = s3ob.getObjectContent();
        ObjectMapper mapper = new ObjectMapper();
        try {
            //getting content from the bucket
            DemoUser user = mapper.readValue(inputStream, DemoUser.class);
            //create bucket
            if (!amazons3.doesBucketExistV2(BUCKET_NAME_USING_CODE))
                amazons3.createBucket(BUCKET_NAME_USING_CODE);
            user.setFirstName("Bob");
            user.setLastName("Mariya");
            user.setLocation("UseEast2");
            File output = new File("test.txt");
            mapper.writeValue(output, user);
            amazons3.putObject(BUCKET_NAME_USING_CODE, "test.txt", output);
            //deleteing the bucket
            amazons3.deleteObject(BUCKET_NAME_USING_CODE, "test.txt");
            amazons3.deleteBucket(BUCKET_NAME_USING_CODE);

result="success";
        } catch (Exception ex) {
            ex.printStackTrace();
            result="fail";
        }

return result;
    }
}
