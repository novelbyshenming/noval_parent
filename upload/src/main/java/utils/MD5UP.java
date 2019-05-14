package utils;


import java.security.MessageDigest;
 
public class MD5UP {
	
	 // MD5鍔犵爜銆�32浣�   
	 public static String MD5(String inStr) {   
	  MessageDigest md5 = null;   
	  try {   
	   md5 = MessageDigest.getInstance("MD5");   
	  } catch (Exception e) {   
	   System.out.println(e.toString());   
	   e.printStackTrace();   
	   return "";   
	  }   
	  char[] charArray = inStr.toCharArray();   
	  byte[] byteArray = new byte[charArray.length];   
	  
	  for (int i = 0; i < charArray.length; i++)   
	   byteArray[i] = (byte) charArray[i];   
	  
	  byte[] md5Bytes = md5.digest(byteArray);   
	  
	  StringBuffer hexValue = new StringBuffer();   
	  
	  for (int i = 0; i < md5Bytes.length; i++) {   
	   int val = ((int) md5Bytes[i]) & 0xff;   
	   if (val < 16)   
	   hexValue.append("0");   
	   hexValue.append(Integer.toHexString(val));   
	  }   
	  
	  return hexValue.toString();   
	 }   
	  
	 // 鍙�嗙殑鍔犲瘑绠楁硶   
	 public static String KL(String inStr) {   
	  // String s = new String(inStr);   
	  char[] a = inStr.toCharArray();   
	  for (int i = 0; i < a.length; i++) {   
	   a[i] = (char) (a[i] ^ 't');   
	  }   
	  String s = new String(a);   
	  return s;   
	 }   
	  
	 // 鍔犲瘑鍚庤В瀵�   
	 public static String JM(String inStr) {   
	  char[] a = inStr.toCharArray();   
	  for (int i = 0; i < a.length; i++) {   
	   a[i] = (char) (a[i] ^ 't');   
	  }   
	  String k = new String(a);   
	  return k;   
	 }   
	    
	 // 娴嬭瘯涓诲嚱鏁�   
	 public static void main(String args[]) {   
	  String s = new String("sa");   
	 /* System.out.println("鍘熷锛�" + s);   
	  System.out.println("MD5鍚庯細" + MD5(s));   
	 
	  System.out.println("MD5鍚庡啀鍔犲瘑锛�" + KL(MD5(s)));   
	  System.out.println("瑙ｅ瘑涓篗D5鍚庣殑锛�" + JM(KL(MD5(s)))); */
	  System.out.println(MD5(s));
	  String ss=MD5(s);
	  System.out.println(KL(ss));
	 }   
}

