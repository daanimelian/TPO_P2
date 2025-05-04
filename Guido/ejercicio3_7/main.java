package stack;

public class main {

	public static void main(String[] args) {
		LinkedStack <Character> guido = new LinkedStack<>();
		System.out.println(parentesisOk("(sf)sf(asf)sf(efs)"));
		System.out.println(guido.isCapicua("neuquen"));


	}
	public static boolean parentesisOk(String frase) {
		 int longitud = frase.length();
		 LinkedStack <Character> fraseStack = new LinkedStack<Character>();
		 for (int i = 0; i <longitud;i++) {
			 if(frase.charAt(i) == '('){
				 fraseStack.push(frase.charAt(i));
			 }
			 else{
				 if(frase.charAt(i) == ')') {
					 if(fraseStack.isEmpty())
						 return false;
					 fraseStack.pop();
				 }
			 }
		 }
		 return fraseStack.isEmpty();
	 }
}
