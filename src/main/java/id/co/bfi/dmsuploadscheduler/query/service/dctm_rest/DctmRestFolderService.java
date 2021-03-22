package id.co.bfi.dmsuploadscheduler.query.service.dctm_rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import id.co.bfi.dmsuploadscheduler.api.request.DctmUploadRequest;
import id.co.bfi.dmsuploadscheduler.entity.DocumentTypeEntity;
import id.co.bfi.dmsuploadscheduler.query.action.dctm_rest.DctmRestFolderAction;

@Service
public class DctmRestFolderService {

	@Autowired
	private DctmRestFolderAction dctmRestFolderAction;
	
	public String createFolderByPath(String path, List<String> msg)
			throws JsonMappingException, JsonProcessingException {
		String folderId = null;
		if (path.substring(0, 1).equals("/")) {
			folderId = dctmRestFolderAction.createFolderByPath(path, msg);
		}
		return folderId;
	}

	public String generateFolderPath(DctmUploadRequest dctmUploadRequest, DocumentTypeEntity dmsDocType) {
		return dctmRestFolderAction.generateFolderPath(dctmUploadRequest, dmsDocType);
	}

}
