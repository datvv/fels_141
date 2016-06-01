package framgiavn.project01.web.ulti;

import com.timgroup.jgravatar.Gravatar;

public class AvatarUtils {
	
	public static final	String A404 = "404";
	public static final String MM = "mm";
	public static final String IDENTICON = "identicon";
	public static final String MONSTERID = "monsterid";
	public static final String WAVATAR = "wavatar";
	public static final String RETRO = "retro";
	public static final String BLANK = "blank";
	
	public static String getAvatarURL(String email){
		Gravatar gravatar = new Gravatar();
		String url = gravatar.getUrl(email);
		System.out.println("url before=" + url + "=");
		int length = url.length();
		StringBuilder sb = new StringBuilder(url);		
		if(sb.substring(length - 3, length).equals(A404)){
			url = sb.replace(length - 3, length, RETRO).toString();
		}	
		return url;
	}
}