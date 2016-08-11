package Serilaze;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

public class io {

	
		public static Object read(String FileName) throws FileNotFoundException{
		
			
			//Vector3d retrievedObject=null;
			FileName="./res/test/rp.ser";
			Input input = new Input( new FileInputStream(FileName));
			Kryo kryo=new Kryo();
	        return kryo.readClassAndObject(input);
			//retrievedObject=(Vector3d)kryo.readClassAndObject(input);
		}
		
		//        Vector3d someObject=new Vector3d(1,2,3);
		public static void write(Object someObject, String FileName) throws FileNotFoundException{
			FileName="./res/test/rp.ser";
			Output output = new Output(new FileOutputStream(FileName));
	        Kryo kryo=new Kryo();
	        kryo.writeClassAndObject(output, someObject);
		}
}
