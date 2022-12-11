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

	public DoublyLinkedList insertChain(Object o) {
		ListPosition newPosition = new ListPosition(o, head, null);
		head = newPosition;
		if(tail == null) { // la lista era vuota (tail -> null)
			tail = newPosition;
		} else { // esisteva una head e quindi aggiorno il suo prev

			newPosition.next().setPrev(newPosition); // !!!

		}
		n++;
		
		return this;
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
		IListPosition x = a.prev();
		IListPosition y = a.next();
		IListPosition z = b.prev();
		IListPosition w = b.next();

		b.setPrev(x);
		b.setNext(y);
		a.setPrev(z);
		a.setNext(w);

		if(x != null){
			x.setNext(b);
		}
		if(y != null){
			y.setPrev(b);
		}
		if(z != null){
			z.setNext(a);
		}
		if(w != null){
			w.setPrev(a);
		}

		if( tail == a ){
			tail = b;
		}else{
			if( tail == b ){
				tail = a;
			}
		}
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

	public int removeBigger(int v){
		int removed = 0;
		IListPosition tmp = head;
		while(tmp != null){
			if (tmp.value().equals(v)){
				if (tmp == head){
					IListPosition x = tmp.next();
					x.setPrev(null);
					head = x;
				}else if(tmp == tail){
					IListPosition x = tmp.prev();
					x.setNext(null);
					tail = x;
				}else{
					IListPosition x = tmp.next();
					IListPosition y = tmp.prev();
					y.setNext(x);
					x.setPrev(y);
					tmp.setNext(null);
					tmp.setPrev(null);
					tmp = y;
				}
				removed ++;
			}
			tmp = tmp.next();
		}
		this.n -= removed;
		return removed;
	}




}