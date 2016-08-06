package backupMain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*Thanks to the following websites:
 * https://www.mkyong.com/java/how-to-copy-directory-in-java/
 * http://beginnersbook.com/2013/12/hashmap-in-java-with-example/
 */
public class backUpMain {
	public static void main(String[] args){
		HashMap<String,String> dirList = new HashMap<String,String>();
		//dirList.put("test", "C:\\test");
		dirList.put("python", "removed");
		dirList.put("csharp-cplusplus", "removed");
		dirList.put("android", "removed");
		dirList.put("java", "removed");
		dirList.put("webdev", "removed");
		LocalDate dNow = LocalDate.now();
		LocalDateTime dtNow = LocalDateTime.now();
		DateTimeFormatter df2 = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
		String test2 = df2.format(dtNow);
		System.out.println(test2);
		File newDir = new File("E:\\backups\\"+test2);
		newDir.mkdir();
		Set set = dirList.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()){
			Map.Entry item = (Map.Entry)it.next();
			System.out.println("Key: " + item.getKey() + "\tValue: " + item.getValue());
			File orig = new File((String) item.getValue());
			File newDir2 = new File("E:\\backups\\"+test2 + "\\" + (String) item.getKey());
			if(orig.exists()){
				System.out.println("Found it");
			}
			try {
				copyFolder(orig, newDir2, (String)item.getKey());
				System.out.println("Done");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.exit(0);
			}
		}
	}
	public static void copyFolder(File in, File out, String loc)
		throws IOException{
		Set<String> folderList = new HashSet<String>(Arrays.asList(new String[]
				{"htdocs","css","php","js","login","*."}));
		
		if(in.isDirectory()){
			if (loc == "webdev" && folderList.contains(in.getName())){ //only needed for webdev
					if(!out.exists()){
						out.mkdir();
					}				
			} else {
				if(!out.exists()){
					out.mkdir();
				}
			}
			String files[] = in.list();
			for (String file : files){
				if (loc == "webdev" && folderList.contains(in.getName())){ //only needed for webdev
					File oldFile = new File(in, file);
					File newFile = new File(out,file);
					copyFolder(oldFile, newFile, loc);
				} else {
					File oldFile = new File(in, file);
					File newFile = new File(out,file);
					copyFolder(oldFile, newFile, loc);
				}
			}
		}
		else{
			InputStream oldFile = new FileInputStream(in);
			OutputStream newFile = new FileOutputStream(out);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = oldFile.read(buffer))> 0){
				newFile.write(buffer,0,length);
			}
			oldFile.close();
			newFile.close();
		}
	}
}
