package hust.soict.dsai.aims.screen;

import javax.swing.*;
import java.awt.*;

import java.util.*;

import hust.soict.dsai.aims.store.Store.Store;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.cart.Cart.*;

public class StoreScreen extends JFrame {
	private Store store;
	private Cart cart;

	// Adding north-side placeholder
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");

		// Set up menus
		JMenu smUpdateStore = new JMenu("Update Store");
		JMenuItem addBook = new JMenuItem("Add Book");
		JMenuItem addCD = new JMenuItem("Add CD");
		JMenuItem addDVD = new JMenuItem("Add DVD");
		smUpdateStore.add(addBook);
		smUpdateStore.add(addCD);
		smUpdateStore.add(addDVD);

		// Menu items event handler
		addBook.addActionListener(e -> new AddBookToStoreScreen(store, cart));
		addCD.addActionListener(e -> new AddCompactDiscToStoreScreen(store, cart));
		addDVD.addActionListener(e -> new AddDigitalVideoDiscToStoreScreen(store, cart));
		menu.add(smUpdateStore);
		JMenuItem viewStore = new JMenuItem("View store");
		JMenuItem viewCart = new JMenuItem("View cart");
		menu.add(viewStore);
		menu.add(viewCart);

		// menu items event handlers
		viewStore.addActionListener(e -> new StoreScreen(store, cart));
		viewCart.addActionListener(e -> new CartScreen(cart, store));

		// Set up menu bar
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}

	// AIMS headers
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		JButton btnCart = new JButton("View cart");
		btnCart.setPreferredSize(new Dimension(100, 50));
		btnCart.setMaximumSize(new Dimension(100, 50));
		btnCart.addActionListener(e -> new CartScreen(cart, store));
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(btnCart);
		header.add(Box.createRigidArea(new Dimension(10,10)));
		
		return header;
	}

	// Make panel for displaying items
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for (int i = 0; i < 9; i++) {
			try {
				MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
				center.add(cell);
			} catch (Exception e){}
		}
		return center;
	}

	// Screen for store
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
}
