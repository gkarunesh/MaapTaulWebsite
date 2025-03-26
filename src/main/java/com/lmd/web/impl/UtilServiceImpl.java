/**
 * 
 */
package com.lmd.web.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lmd.web.dto.UploadedFileResponse;
import com.lmd.web.enums.Message;
import com.lmd.web.exceptions.FileStorageException;
import com.lmd.web.exceptions.MyFileNotFoundException;
import com.lmd.web.service.UtilService;


/**
 * @author sudhakar
 *
 */

@Service
public class UtilServiceImpl<T> implements UtilService<T>{

	
	private static final long serialVersionUID = -6744409361521910230L;


	
	@Override
	public UploadedFileResponse copyFile(MultipartFile file, String uploadedFileLocation) throws IOException {
		// Normalize file name
		System.err.println(file.getSize());
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            
            File directory = new File(uploadedFileLocation);
            if (!directory.exists()){
            	directory.canWrite();
                directory.mkdirs();
            }
            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = Paths.get(uploadedFileLocation).resolve(fileName);
            //System.out.println(targetLocation.toAbsolutePath());
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);            
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/downloadFile/")
                    .path(fileName)
                    .toUriString();

            return UploadedFileResponse.builder()
            		.fileName(fileName).fileDownloadUri(fileDownloadUri)
            		.fileType(file.getContentType())
            		.size(file.getSize())
            		.remarks("successfully uploaded...")
            		.build();
        } catch (IOException ex) {
        	ex.printStackTrace();
            throw new FileStorageException(Message.COULD_NOT_STORE.concat(fileName).concat(Message.TRY_AGAIN), ex.getCause());
        }	       
	}
	@Override
	public UploadedFileResponse copyFile(MultipartFile file, String uploadedFileLocation,String uploadedFileName) throws IOException {
		// Normalize file name
		System.err.println(file.getSize());
        try {
            File directory = new File(uploadedFileLocation);
            if (!directory.exists()){
            	directory.canWrite();
                directory.mkdirs();
            }
            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = Paths.get(uploadedFileLocation).resolve(uploadedFileName);
            //System.out.println(targetLocation.toAbsolutePath());
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);            
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/downloadFile/")
                    .path(uploadedFileName)
                    .toUriString();

            return UploadedFileResponse.builder()
            		.fileName(uploadedFileName).fileDownloadUri(fileDownloadUri)
            		.fileType(file.getContentType())
            		.size(file.getSize())
            		.remarks("success")
            		.build();
        } catch (IOException ex) {
        	ex.printStackTrace();
            throw new FileStorageException(Message.COULD_NOT_STORE.concat(uploadedFileName).concat(Message.TRY_AGAIN), ex.getCause());
        }	       
	} 
	
	
	
	@Override
    public Resource loadFileAsResource(String fileName, String location) {
        try {
        	System.err.println(location);
            Path filePath = Paths.get(location).resolve(fileName).normalize();
            System.err.println(filePath.toAbsolutePath());
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException(Message.FILE_NOT_FOUND.concat(fileName));
            }
        } catch (MalformedURLException ex) {
        	ex.printStackTrace();
            throw new MyFileNotFoundException(Message.FILE_NOT_FOUND.concat(fileName));
        }
    }
	
	@Override
	public Optional<T> castIntoOptional(Object obj) {
		if (obj.getClass().isInstance(obj))
			return Optional.of((T) obj);
		else
			return Optional.empty();
	}
	
	@Override
	public Stream<T> castIntoStream(Object obj) {
		if (obj.getClass().isInstance(obj))
			return Stream.of((T) obj);
		else
			return Stream.empty();
	}

	@Override
	public UploadedFileResponse copyFile(byte[] bytearray, String uploadedFileLocation, String uploadedFileName)
			throws IOException {
//        try (
//            FileOutputStream fileOutStream = new FileOutputStream(uploadedFileLocation + uploadedFileName)) {
//            fileOutStream.write(bytearray);
//            fileOutStream.flush();
//        }
        try {
            File directory = new File(uploadedFileLocation);
            if (!directory.exists()){
            	directory.canWrite();
                directory.mkdirs();
            }
            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = Paths.get(uploadedFileLocation).resolve(uploadedFileName);
            System.out.println(targetLocation.toAbsolutePath());
            InputStream targetStream = new ByteArrayInputStream(bytearray);
            
            Files.copy(targetStream, targetLocation, StandardCopyOption.REPLACE_EXISTING);            
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/downloadFile/")
                    .path(uploadedFileName)
                    .toUriString();

            return UploadedFileResponse.builder()
            		.fileName(uploadedFileName).fileDownloadUri(fileDownloadUri)
            		.remarks("success")
            		.build();
        } catch (IOException ex) {
        	ex.printStackTrace();
            throw new FileStorageException(Message.COULD_NOT_STORE.concat(uploadedFileName).concat(Message.TRY_AGAIN) , ex.getCause());
        }
	}
	
	
	@Override
	public boolean isAuthentic(String data, String input) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public BufferedImage createQR(String data) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
