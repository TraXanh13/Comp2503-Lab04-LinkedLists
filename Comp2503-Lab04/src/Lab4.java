public class Lab4 {
	private Node<String> head;
	private Node<String> tail;

	public void addHead(Node<String> n) {
		// add a node to the head of the list.
		if (head == null) {
			head = n;
			tail = n;
		} else {
			n.setNext(head);
			head = n;
		}
	}

	public void addTail(Node<String> n) {
		if (head == null) {
			head = n;
			tail = n;
		} else {
			tail.setNext(n);
			tail = n;
		}
	}
	

	public Node<String> find(String key) {
		Node<String> ptr = head;
		while (ptr.getNext().getData() != null) {
			if (ptr.getData().equals(key)) {
				return ptr;
			} else {
				ptr = ptr.getNext();
			}
		}
		return null;
	}

	public Node<String> delete(String key) {
		Node<String> ptr = head;
		if (head.getData().equals(key)) {
			head = head.getNext();
		} else {
			while (ptr.getNext() != null) {
				if (ptr.getNext().getData().equals(key)) {
					ptr.setNext(ptr.getNext().getNext());
					break;
				} else {
					ptr = ptr.getNext();
				}
			}
		}
		return null;
	}

	public void printList() {
		System.out.println();
		Node<String> currentNode = head;
		if (head == null) {
			System.out.println("\nThe list is empty");
		}
		while (currentNode != null) {
			// Visit the node. In this case, print it out.
			System.out.println(currentNode.toString());
			currentNode = currentNode.getNext();
		}
	}

	public void emptyList() {
		head = null;
		tail = null;
	}

	public void addInOrder(Node<String> n) {
		Node<String> currentNode = head;
		if(head == null || head.getData().compareTo(n.getData()) > 0) {
			addHead(n);
		} else {
			while (currentNode.getNext() != null) {
				if (currentNode.getData().compareTo(n.getData()) < 0) {
					n.setNext(currentNode.getNext());
					currentNode.setNext(n);
					break;
				}
				currentNode = currentNode.getNext();
			}
		}
	}

	public void run() {
		Node<String> a = new Node<String>("Athabasca");
		Node<String> b = new Node<String>("Andromeda");
		Node<String> c = new Node<String>("Hector");
		Node<String> d = new Node<String>("Victoria");
		System.out.println("Add everyone to the list");
		addHead(b);
		addTail(c);
		addTail(a);
		addHead(d);
		printList();
		System.out.println("\nRemove Hector");
		delete("Hector");
		printList();
		emptyList();
		printList();
		System.out.println("Add in order");
		addInOrder(a);
		addInOrder(c);
		addInOrder(d);
		addInOrder(b);
		printList();
	}

	public static void main(String[] args) {
		Lab4 l = new Lab4();
		l.run();
	}
}
