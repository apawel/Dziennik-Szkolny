package model;

public class PushNotifications implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idPushNotifications;
	private String pesel;
	private String device;
	public PushNotifications(Integer idPushNotifications, String pesel,
			String device) {
		
		this.idPushNotifications = idPushNotifications;
		this.pesel = pesel;
		this.device = device;
	}
	public Integer getIdPushNotifications() {
		return idPushNotifications;
	}
	public void setIdPushNotifications(Integer idPushNotifications) {
		this.idPushNotifications = idPushNotifications;
	}
	public String getPesel() {
		return pesel;
	}
	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}

	
}
