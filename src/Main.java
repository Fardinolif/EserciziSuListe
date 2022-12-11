public class Main {
	public static void main(String[] args) throws Exception {
		//test1();

		//test2();
		test3();
	}

	public static void test1() throws Exception{
		DoublyLinkedList list = new DoublyLinkedList();
		list.insertAtHead(1);
		list.insertAtHead(2);
		list.insertAtHead(3);
		list.insertAtHead(4);
		list.insertAtHead(5);
		list.printList();

		//swap
		list.swap(list.get(1),list.get(3));
		list.printList();
		list.swap(list.get(2),list.get(4));
		list.printList();


		//removeBigger
		list.removeBigger(5);
		list.printList();
		list.removeBigger(3);
		list.printList();
		list.removeBigger(1);
		list.printList();
	}

	public static void test2() throws Exception{
		DoublyLinkedList list = new DoublyLinkedList();
		list.insertChain(1).insertChain(6).insertChain(9).insertChain(3).insertChain(0).insertChain(2)
				.insertChain(9).insertChain(10).insertChain(6).insertChain(3).insertChain(4)
				.insertChain(6);
		list.printList();
		System.out.println("valore rimossi: " + list.removeBigger(6));
		list.printList();

		DoublyLinkedList list2 = new DoublyLinkedList();
		list2.insertChain(6).insertChain(6).insertChain(6).insertChain(6).insertChain(6).insertChain(6)
				.insertChain(6).insertChain(6).insertChain(7).insertChain(6).insertChain(6)
				.insertChain(6);
		list2.printList();
		System.out.println("valore rimossi: " + list2.removeBigger(6));
		list2.printList();
	}

	public static void test3()throws Exception{
		DoublyLinkedList list = new DoublyLinkedList();
		list.insertChain(1).insertChain(6).insertChain(9).insertChain(3).insertChain(0).insertChain(2)
				.insertChain(9).insertChain(10).insertChain(6).insertChain(3).insertChain(4)
				.insertChain(6);
		list.printList();

		DoublyLinkedList list2 = new DoublyLinkedList();
		list2.insertChain(6).insertChain(6).insertChain(6).insertChain(6).insertChain(6).insertChain(6)
				.insertChain(6).insertChain(6).insertChain(7).insertChain(6).insertChain(6)
				.insertChain(6);
		list2.printList();

		IListPosition tmp = interLeave(list2.get(0), list.get(0));
		System.out.println(tmp.getStr());

	}


	public static IListPosition interLeave(IListPosition H1, IListPosition H2){
//H1 -> 10 -> 3 -> 0 -> 0 -> null
//H2 -> 1 -> 2 -> null
//R ->10 -> 1 -> 3 -> 2 -> 0 -> 0-> null

//TODO caso almeno una lista vuota
//lista vuota
		IListPosition R = null;
		IListPosition last = null;
		IListPosition it1 = H1;
		IListPosition it2 = H2;

		if(H1 == H2){
			return H1;
		}

		if( H1 == null){
			return H2;
		}

		if(H2 == null){
			return H1;
		}

		while(it1 != null && it2 != null){
			if(last == null){ //risultato ancora vuoto
				last = it1;
				it1 = it1.next();
				last.setNext(null);
				R = last;
			}else{
				last.setNext(it1);
				it1 = it1. next();
				last = last.next();
				last.setNext(null);

			}
			last.setNext(it2);
			it2 = it2. next();
			last = last.next();
			last.setNext(null);
		}

		while(it1 != null){
			last.setNext(it1);
			it1 = it1. next();
			last = last.next();
			last.setNext(null);
		}

		while(it2 != null){
			last.setNext(it2);
			it2 = it2. next();
			last = last.next();
			last.setNext(null);
		}

		return R;

	}
}