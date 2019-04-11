import java.util.Scanner;
public class datos {
	public void herencia(){
		System.out.print("Ingrese lo que desee: ");
		Scanner scan = new Scanner(System.in);
		System.out.println("Frase ingresada: " + scan.nextLine());
		scan.close();
	}
}
