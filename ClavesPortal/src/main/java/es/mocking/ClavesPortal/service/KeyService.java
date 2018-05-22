package es.mocking.ClavesPortal.service;

import org.springframework.stereotype.Service;

/**
 * The Class DeviceService.
 */
@Service("keyService")
public class KeyService {

	/**
	 * Get the new key
	 * @param key
	 * @param key2 
	 * @return
	 */
	public String get(String user, String key) {
		String salida = null;
		if (user.length()==5 && key.length()==5) {
			String token = "U:" + user.toUpperCase() + " K:" + key.toUpperCase();
			salida = MD5(token).toUpperCase();
		} 
		return salida;
	}
	
	/**
	 * 
	 * @param md5
	 * @return
	 */
	private String MD5(String md5) {
		   try {
		        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
		        byte[] array = md.digest(md5.getBytes());
		        StringBuffer sb = new StringBuffer();
		        for (int i = 0; i < array.length; ++i) {
		          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
		       }
		        return sb.toString();
		    } catch (java.security.NoSuchAlgorithmException e) {
		    }
		    return null;
		}

	/**
	 * 
	 * @param user
	 * @param portal
	 * @return
	 */
	public String valid(String user, String portal) {
		String salida = null;
		if (portal.length() == 8) {
			salida = "OK: It's a info message";
		}
		return salida;
	}

	/**
	 * 
	 * @param portal
	 * @return
	 */
	public String search(String portal) {
		String salida = null;
		if (portal.length() == "7291466E0F486CBDC1AF567FC9AD78D7".length()) {
			salida = "OK: It's a info message";
		}
		return salida;
	}	
	

}
