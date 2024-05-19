package com.datapulse;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class LambdaHandler implements RequestHandler<S3Event, String> {
    private static final String DATABRICKS_API_URL = "https://adb-1944762585075355.15.azuredatabricks.net/api/2.0/jobs/run-now";
    private static final String DATABRICKS_TOKEN = "dapifec0e2a895bba07f937c25f6071272fa-3";
    private static final String JOB_ID = "783293893384398";

    @Override
    public String handleRequest(S3Event s3Event, Context context) {
        try {
            // Get the S3 bucket and object information from the event
            String bucketName = s3Event.getRecords().get(0).getS3().getBucket().getName();
            String objectKey = s3Event.getRecords().get(0).getS3().getObject().getKey();
            context.getLogger().log("BucketName ::: " + bucketName);
            context.getLogger().log("ObjectKey ::: " + objectKey);

            if (objectKey.contains("predicted")) {

                context.getLogger().log("ObjectKey ::: " + objectKey + " Process Completed...");

            }
            else {
                // Set up Databricks job details
                String runEndpoint = DATABRICKS_API_URL;
                String requestBody = "{ \"job_id\": " + JOB_ID + " }";

                // Initialize Amazon S3 client
                AmazonS3 s3client = AmazonS3ClientBuilder.defaultClient();

                // Retrieve the S3 object content
                S3Object s3Object = s3client.getObject(bucketName, objectKey);
                InputStream objectContent = s3Object.getObjectContent();
                String content = IOUtils.toString(objectContent, StandardCharsets.UTF_8);
                context.getLogger().log("File content: " + content);

                // Create an HTTP client to trigger the Databricks job
                try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
                    HttpPost httpPost = new HttpPost(runEndpoint);
                    httpPost.addHeader("Authorization", "Bearer " + DATABRICKS_TOKEN);
                    httpPost.addHeader("Content-Type", "application/json");
                    httpPost.setEntity(new ByteArrayEntity(requestBody.getBytes(StandardCharsets.UTF_8)));

                    // Execute the HTTP request to trigger the Databricks job
                    HttpEntity responseEntity = httpClient.execute(httpPost).getEntity();

                    if (responseEntity != null) {
                        String responseString = EntityUtils.toString(responseEntity);
                        context.getLogger().log("Databricks job triggered for S3 object: s3://" + bucketName + "/" + objectKey);
                        return "Databricks job triggered for S3 object: s3://" + bucketName + "/" + objectKey;
                    } else {
                        return "Failed to trigger Databricks job";
                    }
                } catch (IOException e) {
                    context.getLogger().log("Error triggering Databricks job: " + e.getMessage());
                    return "Error triggering Databricks job: " + e.getMessage();
                }
            }
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
        return "Process Done.";
    }
}

