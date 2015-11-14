import java.io.File;

import javax.sound.midi.*;
import javax.sound.midi.spi.*;
import javax.sound.midi.Track;


public class MmidiDG1 {
	
	
	public static final int NOTE_ON=0x90;
	public static final int note_off=0x80;
	public static final String[]note_name={"C","C#","D","D#","E","F","F#","G","G#","A","A#","B"};
	public static final int mat1[][]=new int[6][16];
	
	
	public static void main(String[] args) throws Exception{
		
		Sequence s1= MidiSystem.getSequence(new File("c:/midi/s1.mid"));
		Sequence s2=MidiSystem.getSequence(new File("c:/midi/s2.mid"));
		Sequence s3=MidiSystem.getSequence(new File("c:/midi/s3.mid"));
		Sequence s4=MidiSystem.getSequence(new File("c:/midi/s4.mid"));
		Sequence s5=MidiSystem.getSequence(new File("c:/midi/s5.mid"));
		Sequence s6=MidiSystem.getSequence(new File("c:/midi/s6.mid"));
		
		int trknum=0;
		int j=0;
		for(Track st6: s6.getTracks()){
			
			if(st6.size()>4)
			{
				for(int i=0; i<st6.size();i++)
				{
					
					MidiEvent oneno=st6.get(i);
					MidiMessage notem=oneno.getMessage();
					if(notem instanceof ShortMessage)
					{
						ShortMessage shnote=(ShortMessage) notem;
						
						int da=shnote.getData1();
						int oct=(da/12)+1;
						int anote=da%12;
						if(shnote.getCommand()==NOTE_ON)
						{
							mat1[0][j]=(da*10)+oct;
							j++;
						}
						
					}
				}
			}
	
		}
		
		j=0;
		for(Track st5: s5.getTracks()){
			
			if(st5.size()>4)
			{
			
				for(int i=0; i<st5.size();i++)
				{
					
					MidiEvent oneno=st5.get(i);
					MidiMessage notem=oneno.getMessage();
					if(notem instanceof ShortMessage)
					{
						ShortMessage shnote=(ShortMessage) notem;
						int da=shnote.getData1();
						int oct=(da/12)+1;
						int anote=da%12;
						if(shnote.getCommand()==NOTE_ON)
						{
							mat1[1][j]=(da*10)+oct;
							j++;
						}

					}
						
				}
			}
	
		}
		
		j=0;
		for(Track st4: s4.getTracks()){
			if(st4.size()>4)
			{
				
				for(int i=0; i<st4.size();i++)
				{
					
					MidiEvent oneno=st4.get(i);
					MidiMessage notem=oneno.getMessage();
					if(notem instanceof ShortMessage)
					{
						ShortMessage shnote=(ShortMessage) notem;
						int da=shnote.getData1();
						int oct=(da/12)+1;
						int anote=da%12;
						if(shnote.getCommand()==NOTE_ON)
						{
							mat1[2][j]=(da*10)+oct;
							j++;
						}
					}
				}
			}
		}
	
		j=0;
		
		for(Track st3: s3.getTracks()){
			if(st3.size()>4)
			{
				
				for(int i=0; i<st3.size();i++)
				{
					MidiEvent oneno=st3.get(i);
					MidiMessage notem=oneno.getMessage();
					if(notem instanceof ShortMessage)
					{
						ShortMessage shnote=(ShortMessage) notem;
						int da=shnote.getData1();
						int oct=(da/12)+1;
						int anote=da%12;
						if(shnote.getCommand()==NOTE_ON)
						{
							mat1[3][j]=(da*10)+oct;
							j++;
						}
					}
				}
			}
		}
		j=0;
		
		for(Track st2: s2.getTracks()){
			if(st2.size()>4)
			{
				
				for(int i=0; i<st2.size();i++)
				{
				
					MidiEvent oneno=st2.get(i);
					MidiMessage notem=oneno.getMessage();
					if(notem instanceof ShortMessage)
					{
						ShortMessage shnote=(ShortMessage) notem;
						
						int da=shnote.getData1();
						int oct=(da/12)+1;
						int anote=da%12;
						if(shnote.getCommand()==NOTE_ON)
						{
							mat1[4][j]=(da*10)+oct;
							j++;
						}
					}
				}
			}
		}

		j=0;
		
		for(Track st1: s1.getTracks()){
			
			if(st1.size()>4)
			{
				
				for(int i=0; i<st1.size();i++)
				{
					MidiEvent oneno=st1.get(i);
					MidiMessage notem=oneno.getMessage();
					if(notem instanceof ShortMessage)
					{
						ShortMessage shnote=(ShortMessage) notem;
						
						int da=shnote.getData1();
						int oct=(da/12)+1;
						int anote=da%12;
						int sda=shnote.getData2();
						if(shnote.getCommand()==NOTE_ON)
						{
						    mat1[5][j]=(da*10)+oct;
						    j++;
						}
					}
				} 
			}
		}
		int count=6;
		for(int i=0;i<6;i++)
		{
			System.out.print("st num "+count+" ");
			for(j=0;j<16;j++)
			{
				System.out.print(mat1[i][j]+", ");
			}
			count--;
			System.out.println();
		}
		
	}
		
}


