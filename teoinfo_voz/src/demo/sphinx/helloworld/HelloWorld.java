package demo.sphinx.helloworld;

import edu.cmu.sphinx.frontend.DataProcessingException;
import edu.cmu.sphinx.frontend.util.Microphone;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.ConfigurationManager;
import edu.cmu.sphinx.util.props.PropertyException;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import categories.WordInsertionProbability;

public class HelloWorld {

    public static void main(String[] args) {
        try {
            URL url;
            if (args.length > 0) {
                url = new File(args[0]).toURI().toURL();
            } else {
                url = HelloWorld.class.getResource("helloworld.config.xml");
            }

            System.out.println("Cargando...");

            ConfigurationManager cm = new ConfigurationManager(url);

	    Recognizer recognizer = (Recognizer) cm.lookup("recognizer");
	    Microphone microphone = (Microphone) cm.lookup("microphone");


            recognizer.allocate();

	    if (microphone.startRecording()) {

		System.out.println
		    ("Listo");

		while (true) {
		    System.out.println
			("Di algo >>.\n");

		    Result result = recognizer.recognize();
		    
		    if (result != null) {
			String resultText = result.getBestFinalResultNoFiller();
			System.out.println("Has dicho: " + resultText + "\n");
			System.out.println(microphone.getAudioFormat());
			System.out.println(microphone.getData());
			new WordInsertionProbability().obtenerData(microphone);
			System.out.println("Toma de señal / segundo (framerate): "+microphone.getAudioFormat().getFrameRate());
			System.out.println("Longitud de señal: "+(microphone.getAudioFormat().getFrameSize()*8)+" bits por cuadro");
		    } else {
			System.out.println("No he podido escuchar.\n");
		    }
		}
	    } else {
		System.out.println("No puedo iniciar el microfono.");
		recognizer.deallocate();
		System.exit(1);
	    }
        } catch (IOException e) {
            System.err.println("Problema cargando archivo de configuracion: " + e);
            e.printStackTrace();
        } catch (PropertyException e) {
            System.err.println("Problem configurando el microfono: " + e);
            e.printStackTrace();
        } catch (InstantiationException e) {
            System.err.println("Problema creando archivo de configuracion: " + e);
            e.printStackTrace();
        } catch (DataProcessingException e) {
			e.printStackTrace();
		}
    }
}
