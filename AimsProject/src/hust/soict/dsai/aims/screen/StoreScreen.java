package hust.soict.dsai.aims.screen;

import javax.swing.*;
import java.awt.*;
import java.util.*;

import hust.soict.dsai.aims.store.Store.Store;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.cart.Cart.*;

public class StoreScreen extends JFrame {
	private Store store;
	private static Cart cart;
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		
		JMenu smUpdateStore = new JMenu("Update Store");
		smUpdateStore.add(new JMenuItem("Add Book"));
		smUpdateStore.add(new JMenuItem("Add CD"));
		smUpdateStore.add(new JMenuItem("Add DVD"));
		
		menu.add(smUpdateStore);
		menu.add(new JMenuItem("View store"));
		menu.add(new JMenuItem("View cart"));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		JButton cart = new JButton("View cart");
		cart.setPreferredSize(new Dimension(100, 50));
		cart.setMaximumSize(new Dimension(100, 50));
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cart);
		header.add(Box.createRigidArea(new Dimension(10,10)));
		
		return header;
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for (int i = 0; i < 9; i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
			center.add(cell);
		}
		return center;
	}
	
	public StoreScreen(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("Store");
		setSize(1024, 768);
	}
	
	public static void main(String[] args) {
		Store store = new Store();
		Cart cart = new Cart();
		// Initiate medias
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Harry Porter",
				"Magic", "JK Rowling", 127, 26.05f);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("IELTS Listening",
				"English", "British Council", 40, 82.05f);

		CompactDisc cd1 =
				new CompactDisc("Making my way", "Pop",
				"Unknown", 5,  18.99f, "Son Tung M-TP");

		CompactDisc cd2 =
				new CompactDisc("Peaches", "Pop",
				"Unknown", 6,  30.99f, "Justin Bieber");

		CompactDisc cd3 =
				new CompactDisc("Kiss Me More", "Pop",
				"Unknown", 4,  30.99f, "Doja cat");

		Book book1 =
				new Book("Star Wars",
				 "George Lucas", 24.95f);

		Book book2 =
				new Book("IELTS Reading",
				 "IDP", 102.95f);

		Book book3 =
				new Book("How to make money",
				 "Jack Ma", 69.95f);

		// Add media to store
		store.addMedia(book1);
		store.addMedia(book2);
		store.addMedia(book3);
		store.addMedia(cd1);
		store.addMedia(cd2);
		store.addMedia(cd3);
		store.addMedia(dvd1);
		store.addMedia(dvd2);
		store.addMedia(dvd3);

		// Initiate GUI
		new StoreScreen(store, cart);
	}
}
