/**
 * 
 */
package com.lmd.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sudhakar
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder

public @Data class UploadedFileResponse {
	private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;
    private String remarks;
    private Integer id;
}
