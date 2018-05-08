package com.nish.salesprocessor.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Message class to be used for API response.
 * 
 * @author Nishanth Mathew Joy
 */
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Message implements Serializable {
	private static final long serialVersionUID = -1L;
	private String msgCode;
	private String msgDesc;
}
