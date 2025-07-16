package com.maurodegaspari.livroteca.exceptions.handle;

public class ErrosResponseHandle {
	
	private Long timestamp;
	private int status;
	private String error;
	
	public ErrosResponseHandle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErrosResponseHandle(Long timestamp, int status, String error) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	

}
