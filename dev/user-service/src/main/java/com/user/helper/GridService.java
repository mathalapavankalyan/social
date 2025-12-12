package com.user.helper;

import java.io.IOException;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;


import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GridService {
	
	
	private final GridFsTemplate gridFsTemplate;
	
	public ObjectId saveFile(MultipartFile profilepictureFile) {
		
		try {
			ObjectId fileId = gridFsTemplate.store(
					profilepictureFile.getInputStream(),
					profilepictureFile.getOriginalFilename(),
					profilepictureFile.getContentType());
				return fileId;
			
		} catch (IOException e) {
			throw new RuntimeException("Failed to store file", e);
		}
		
	}
	
	public GridFsResource getFile(ObjectId fileId) {
		var gridFsFile = gridFsTemplate.findOne(query(where("_id").is(fileId)));
		
		 if (gridFsFile == null) {
		        throw new RuntimeException("File not found: " + fileId);
		    }

		    return gridFsTemplate.getResource(gridFsFile);
	}
	
	public void deleteFile(ObjectId fileId) {
	    gridFsTemplate.delete(
	            query(where("_id").is(fileId))
	    );
	}


}
