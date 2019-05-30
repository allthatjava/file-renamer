package brian.app.filerenamer;

import java.io.File;
import java.util.Calendar;

import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

import brian.app.filerenamer.util.StringUtil;

public class FileRenamer {

//	public static final String DIR ="Z:\\Videos\\Home_Video\\Ashelys_Wedding";

	String dirPath = null;
	String startWith = null;
	String endWith = null;
	String replaceWith = null;
	boolean addCreatedDate = false;
	
	private JTextArea textAreaLog;
	
	public FileRenamer(String dirPath,
			String startWith,
			String endWith,
			boolean addCreatedDate,
			String replaceWith,
			JTextArea textAreaLog
	)
	{
		this.dirPath = dirPath;
		this.startWith = startWith;
		this.endWith = endWith;
		this.addCreatedDate = addCreatedDate;
		this.replaceWith = replaceWith;
		this.textAreaLog = textAreaLog;

		// Following two lines make TextArea automatically scroll down when something added to it.
		DefaultCaret caret = (DefaultCaret)textAreaLog.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
	}
	
	public String getNewFileName(String originalFileName)
	{
		String newFileName = originalFileName;
		
		// Replace with given text 
		// Both "Start With" and "End with" were given
		if( (startWith != null && startWith.length() > 0)
			&& (endWith != null && endWith.length() > 0) )
		{
			if( originalFileName.startsWith(startWith) )
			{
				// Remove File name from Start to End
				int endIndex = originalFileName.indexOf(endWith);
				newFileName = originalFileName.substring(endIndex+endWith.length()+1);

				// Replace with new name
				newFileName = replaceWith + newFileName;
			}
		}
		// Only "Start With" was given
		else if( startWith != null && startWith.length() > 0 )
		{
			if( originalFileName.startsWith(startWith) )
			{
				newFileName = originalFileName.replace(startWith, replaceWith);
			}
		}
		
		if( !originalFileName.equals(newFileName) )
			leaveLog("\nName changed from:"+originalFileName+" to:"+newFileName);
		
		return newFileName;
	}

	public String addPictureTakenDate(String input, Calendar createdTime)
	{
		String newFileName = "";
		
		input = getNewFileName(input);
		
		// Adding Created Date at the beginning of the file name
		if( addCreatedDate )
		{
			int year = createdTime.get(Calendar.YEAR);
			int month = createdTime.get(Calendar.MONTH)+1;
			int date = createdTime.get(Calendar.DATE);
			
			String newDate = (year+"")+padLeft(month+"", "0", 2)
								+""+padLeft(date+"", "0", 2);
			
			newFileName = newDate+"_"+input;

//			textAreaLog.append("\nName changed from:"+input+" to:"+newFileName);
		}
		
		return newFileName;
	}
	
	public void renamerFiles()
	{
		int count=0;
		
		File dir = new File(dirPath);
		if( dir.exists() && dir.isDirectory())
		{
			String[] fileNames = dir.list();
			for (int i = 0; i < fileNames.length; i++) 
			{
				String message = "";
				
				String newFileName = fileNames[i];
				boolean matched = false;
				// Replace with given text ----------------------
				// Has Start and End
				if( ((startWith != null && startWith.length() > 0)
						&& (endWith != null && endWith.length() > 0) ))
				{
					// endWith compare from position 1, because to use endwith
					// there should be at least some word to start with...
					if( fileNames[i].startsWith(startWith)
							&& fileNames[i].lastIndexOf(endWith) > 1) 
					{
						matched = true;
					}
				}
				else if(startWith != null && startWith.length() > 0 )
				{
					if( fileNames[i].startsWith(startWith))
						matched = true;
				}else{
					message = "\nNeed start name of original file name";
				}
				
				if( matched )
				{
					newFileName = getNewFileName(fileNames[i]);
				}
				
				// Adding Created Date at the beginning of the file name
				if( ( !StringUtil.isNullOrEmpty(startWith) && matched && addCreatedDate)
					|| (StringUtil.isNullOrEmpty(startWith) && addCreatedDate )
					)
				{
					File f = new File(dirPath, fileNames[i]);
					
					Calendar createdTime = Calendar.getInstance();
					createdTime.setTimeInMillis(f.lastModified());
					
					newFileName = addPictureTakenDate(fileNames[i], createdTime);
				}
				
				if( !newFileName.equals(fileNames[i]))
				{
					File f = new File(dirPath, fileNames[i]);
					String fileName = f.getName();
					
					if(f.isFile() && f.exists())
					{
						if( !newFileName.equals(fileName) )
						{
							if( !f.renameTo( new File(dirPath+File.separator+newFileName)))
							{
								newFileName = renameFileWithNewCopyName(f, newFileName);
							}
								
							message = "\nName changed from:"+fileName+" to:"+newFileName;
							count++;
						}
	
					}
				}
				
				textAreaLog.append(message);
				textAreaLog.update(textAreaLog.getGraphics());	// Update TextArea every time when message has been updated
				
				Thread.yield();
			}// End of for
		}

		textAreaLog.append("\nProcess Finished----------------");
		textAreaLog.append("\n"+count+" file names have been changed.");
	}

	private String renameFileWithNewCopyName(File f, String newFileName) 
	{
		if( new File(dirPath+File.separator+newFileName).exists() )
		{
			int lastIndex = newFileName.lastIndexOf(".");
			if( lastIndex > -1 )
			{
				newFileName = newFileName.substring(0, lastIndex)
									+"_1"+newFileName.substring(lastIndex);
			}

			textAreaLog.append("\nFailed to rename. Trying again with "+newFileName);
			if( !f.renameTo( new File(dirPath+File.separator+newFileName)) )
				renameFileWithNewCopyName(f, newFileName); 
		}else{
			int lastIndex = newFileName.lastIndexOf(".");
			newFileName = newFileName.substring(0, lastIndex)
									+"_1"+newFileName.substring(lastIndex);
			
			renameFileWithNewCopyName(f, newFileName); 
			
			textAreaLog.append("\nFailed to rename with unknown reason. Giving up on this file.");
		}
		return newFileName;
	}
	
	private String padLeft(String str, String padStr, int length)
	{
		String returnStr = str;
		while(returnStr.length() < length)
		{
			returnStr = padStr+returnStr;
		}
		return returnStr;
	}
	
	private void leaveLog(final String logText)
	{
		new Thread(new LogInTextArea(logText)).start();
//        SwingWorker<String, JTextArea> worker = new SwingWorker<String, JTextArea>()  
//        {  
//            public String doInBackground()  
//            {  
//                textAreaLog.append(logText);
//                publish(textAreaLog);
//                return "";  
//            }  
//        };
//             
//       // execute the background thread  
//       worker.execute();  
	}
	
	class LogInTextArea implements Runnable
	{
		String logText;
		LogInTextArea(String logText)
		{
			this.logText = logText;
		}
		
		@Override
		public void run() 
		{
			textAreaLog.append(logText+"\n");  
		}
		
	}
}
