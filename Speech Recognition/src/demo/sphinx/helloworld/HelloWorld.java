package demo.sphinx.helloworld;

import edu.cmu.sphinx.frontend.util.Microphone;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.util.props.ConfigurationManager;
import edu.cmu.sphinx.util.props.PropertyException;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

public class HelloWorld {

	public static final String config = "helloworld.config.xml";
	
	public static void main(String[] args) {
		try {
			URL url;
			if (args.length > 0) {
				url = new File(args[0]).toURI().toURL();
			} else {
				url = HelloWorld.class.getResource(config);
			}

			System.out.println("Iniciando...");

			ConfigurationManager cm = new ConfigurationManager(url);
			Recognizer recognizer = (Recognizer) cm.lookup("recognizer");
			Microphone microphone = (Microphone) cm.lookup("microphone");

			recognizer.allocate();

			if (microphone.startRecording()) {

				microphone.newProperties(null);
				DataLine.Info info = new DataLine.Info(TargetDataLine.class, microphone.);
				TargetDataLine micro = (TargetDataLine)AudioSystem.getLine(info);
				ByteArrayOutputStream ostream = new ByteArrayOutputStream();
				int bytesRead = 0;
				int nBytesRead;
				int CHUNK_SIZE = 1024;
				byte[] data = new byte[micro.getBufferSize()/5];
				
				micro.open();
				micro.start();
				while(bytesRead < 100000) {
					nBytesRead = micro.read(data, 0, CHUNK_SIZE);
					bytesRead += nBytesRead;
					System.out.println(data);
				}
				micro.close();
				
			} else {
				System.out.println("No se puede iniciar el microfono.");
				recognizer.deallocate();
				System.exit(1);
			}
		} catch (IOException e) {
			System.err.println("Problema al cargar el archivo ["+config+"]" + e);
			e.printStackTrace();
		} catch (PropertyException e) {
			System.err.println("Problema al configurar el archivo ["+config+"]" + e);
			e.printStackTrace();
		} catch (InstantiationException e) {
			System.err.println("Problema al crear el archivo ["+config+"]" + e);
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			System.err.println("Problema al obtener el microfono. ¿Esta siendo ocupado por otro programa?\n");
			e.printStackTrace();
		} 
	}
}