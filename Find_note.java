import java.io.File;

import javax.sound.midi.*;
import javax.sound.midi.spi.*;
import javax.sound.midi.Track;

public class Find_note extends MmidiDG1 {
	
	public int StringNum=0;
	public int SarigNum=0;
	
	public int BreakSolo(Sequence tsolo)
	{
		for(Track ts: tsolo.getTracks())
		{
			if(ts.size()>4)
			{
				for(int i=0;i<ts.size();i++)
				{
					MidiEvent so1=ts.get(i);
					
					MidiMessage solp1=so1.getMessage();
			
					if(solp1 instanceof ShortMessage)
					{
						ShortMessage note1=(ShortMessage) solp1;
						
						int da1=note1.getData1();
						int NotetoNum1=(da1*10)+((da1/12)+1);
						
						
						if(note1.getCommand()==NOTE_ON)
						{
							FindLoc noteloc=new FindLoc();
							int mat[]=new int[6];
	
						}
					}
				}
			}
		}
		return 0;
	}
}
