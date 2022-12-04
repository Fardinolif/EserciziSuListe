// DoublyLinkedList.java
public class DoublyLinkedList {
	private IListPosition head;
	private IListPosition tail;
	private int n;
	public DoublyLinkedList() {
		head = tail = null;
		n = 0;
	}

	public void insertAtHead(Object o) {
		ListPosition newPosition = new ListPosition(o, head, null);
		head = newPosition;
		if(tail == null) { // la lista era vuota (tail -> null)
			tail = newPosition;
		} else { // esisteva una head e quindi aggiorno il suo prev
			newPosition.next().setPrev(newPosition); // !!!
		}
		n++;
	}

	public void printList(){
		IListPosition elem = this.head;
		while(elem != null){
			System.out.print(elem.value() + " --> ");
			elem = elem.next();
		}
		System.out.println(" X");
	}

	//Esercizio 2
	public void swap(IListPosition a, IListPosition b){
		/*System.out.println("value of a: " + a.value());
		System.out.println("value of b: " + b.value());
		IListPosition c = a;
		a = b;
		b = c;

		System.out.println("value of a: " + a.value());
		System.out.println("value of b: " + b.value());*/
		IListPosition c = a;
		a.prev().setNext(b);



	}

	//esercizo 1
	public IListPosition get(int i) throws Exception {
		if (i > this.n-1){
			throw new Exception("Posizione inesitente");
		}
		IListPosition elem = this.head;
		while(i != 0){
			elem = elem.next();
			i--;
		}
		return elem;
	}
}