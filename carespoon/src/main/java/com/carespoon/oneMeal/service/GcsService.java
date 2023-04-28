package com.carespoon.oneMeal.service;

import com.google.api.client.util.Value;
import com.google.cloud.WriteChannel;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.ByteBuffer;

@Service
public class GcsService {
    private static final String BUCKET_NAME = "care-spoon-82c78.appspot.com";
    private static final String FOLDER_NAME = "photos/";

    private final Storage storage;

    @Value("${cloud.gcp.storage.credentials.location:.classpath}")
    private String bucketName;

    public GcsService(){
        storage = StorageOptions.getDefaultInstance().getService();
    }

    public String uploadImage(MultipartFile file) throws IOException{
        String fileName = file.getOriginalFilename();
        BlobId blobId = BlobId.of(BUCKET_NAME, FOLDER_NAME + fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType(file.getContentType()).build();
        byte[] bytes = file.getBytes();
        try(WriteChannel writer = storage.writer(blobInfo)){
            writer.write(ByteBuffer.wrap(bytes, 0 , bytes.length));
        }
        return storage.get(bucketName).get(bucketName).getMediaLink();
    }
}
