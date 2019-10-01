public class Lab4 {
	private Node<String> head;
	private Node<String> tail;

	public void addHead(Node<String> n) {
		// add a node to the head of the list.
		if (head == null) {
			head = n;
			tail = n;
		} else {
			head.setNext(n);
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
		boolean isAdded = false;
		if (head == null) {
			head = n;
			tail = n;
		} else {
			if (head.getData().compareTo(n.getData()) > 0) {
				addHead(n);
			} else {
				while (currentNode.getNext() != null) {
					if (currentNode.getNext().getData().compareTo(n.getData()) > 0) {
						n.setNext(currentNode.getNext());
						currentNode = n;
						isAdded = true;
						break;
					}else {
						currentNode = currentNode.getNext();
					}
				}
				if(!isAdded) {
					addTail(n);
				}
			}
		}
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
		// implement delete
		return null;
	}

	public void printList() {
		System.out.println();
		Node<String> currentNode = head;
		while (currentNode != null) {
			// Visit the node. In this case, print it out.
			System.out.println(currentNode.toString());
			currentNode = currentNode.getNext();
		}
	}

	public void emptyList() {

	}

	public void run() {
		Node<String> a = new Node<String>("Athabasca");
		Node<String> c = new Node<String>("Andromeda");
		Node<String> b = new Node<String>("Hector");
		Node<String> d = new Node<String>("Victoria");
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
