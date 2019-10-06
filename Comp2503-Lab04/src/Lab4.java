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
	
	public void addInOrder(Node<String> n) {
		Node<String> currentNode = head;
		System.out.println("Adding: " + n.getData());
		if(head == null) {
			head = n;
			tail = n;
		}else if(head.getData().compareTo(n.getData()) > 0) {
			addHead(n);
		}else {
			while (currentNode.getNext() != null) {
				System.out.println("in the while");
				if (currentNode.getNext().getData().compareTo(n.getData()) > 0) {
					addInMiddle(currentNode, n);
					break;
				}
				currentNode = currentNode.getNext();
			}
		}
	}

	private void addInMiddle(Node<String> curr, Node<String> n) {
		n.setNext(curr);
		curr = n;
	}

	public Node<String> find(String key) {
		Node<String> currentNode = head;
		while (currentNode.getNext().getData() != null) {
			if (currentNode.getData().equals(key)) {
				return currentNode;
			} else {
				currentNode = currentNode.getNext();
			}
		}
		return null;
	}

	public Node<String> delete(String key) {
		Node<String> currentNode = head;
		if (head.getData().equals(key)) {
			head = head.getNext();
		} else {
			while (currentNode.getNext() != null) {
				if (currentNode.getNext().getData().equals(key)) {
					currentNode.setNext(currentNode.getNext().getNext());
					break;
				} else {
					currentNode = currentNode.getNext();
				}
			}
		}
		return null;
	}

	public void printList() {
		System.out.println();
		Node<String> currentNode = head;
		if (head == null) {
			System.out.println("The list is empty");
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
		System.out.println("Remove Hector");
		delete("Hector");
		printList();
		emptyList();
		printList();
		addInOrder(a);
		addInOrder(b);
		addInOrder(c);
		addInOrder(d);
		printList();

	}

	public static void main(String[] args) {
		Lab4 l = new Lab4();
		l.run();
	}
}
