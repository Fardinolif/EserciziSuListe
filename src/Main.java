public class Main {
	public static void main(String[] args) throws Exception {

		DoublyLinkedList list = new DoublyLinkedList();
		list.insertAtHead(1);
		list.insertAtHead(2);
		list.insertAtHead(3);
		list.insertAtHead(4);
		list.insertAtHead(5);
		list.printList();

		list.swap(list.get(1),list.get(3));
		list.printList();



	}
}