package problemList;
import java.io.*;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
public class Music{
	public static void main(String[] args)throws Exception,IOException {
		AudioInputStream audioInputStream;
		AudioFormat audioFormat;
		SourceDataLine sourceDataLine;
		File file = new File("C:\\Users\\27378\\Desktop\\baijindisike.wav");
		audioInputStream = AudioSystem.getAudioInputStream(file);
		audioFormat = audioInputStream.getFormat();
		if (audioFormat.getEncoding() != AudioFormat.Encoding.PCM_SIGNED) {
			audioFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
			audioFormat.getSampleRate(), 16, audioFormat.getChannels(),
			audioFormat.getChannels() * 2, audioFormat.getSampleRate(),
			false);
			audioInputStream = AudioSystem.getAudioInputStream(audioFormat,
			audioInputStream);
		}
		DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class,
		audioFormat, AudioSystem.NOT_SPECIFIED);
		sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
		sourceDataLine.open(audioFormat);
		sourceDataLine.start(); // 允许某一数据行执行数据I/O
		byte tempBuffer[] = new byte[320];
		try {
			int cnt;
			while ((cnt = audioInputStream.read(tempBuffer, 0,
					tempBuffer.length)) != -1) {
				if (cnt > 0) {
					sourceDataLine.write(tempBuffer, 0, cnt); // 通过此源数据行将音频数据写入混频器
				}
			}
		sourceDataLine.drain();
		sourceDataLine.close();
		} catch (Exception e) {
		e.printStackTrace();
		System.exit(0);
		}
	}
}
