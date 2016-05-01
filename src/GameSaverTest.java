import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GameSaverTest {

	public static void main(String[] args) {
		GameCharacter one = new GameCharacter(50, "Elf", new String[]{"bow","sword","dust"});
		GameCharacter two = new GameCharacter(200, "Troll", new String[]{"bow","sword","dust"});
		GameCharacter three = new GameCharacter(120, "Magician", new String[]{"bow","sword","dust"});
		
		try{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Game.ser"));
			oos.writeObject(one);
			oos.writeObject(two);
			oos.writeObject(three);
			oos.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		one = null;
		two = null;
		three = null;
		
		try{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Game.ser"));
			GameCharacter oneRestore = (GameCharacter) ois.readObject();
			GameCharacter twoRestore = (GameCharacter) ois.readObject();
			GameCharacter threeRestore = (GameCharacter) ois.readObject();
			
			System.out.println("One's type is: " + oneRestore.getType());
			System.out.println("Two's type is: " + twoRestore.getType());
			System.out.println("Three's type is: " + threeRestore.getType());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
