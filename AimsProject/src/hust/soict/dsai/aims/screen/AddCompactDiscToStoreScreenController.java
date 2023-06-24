package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.store.Store.Store;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

import javax.naming.LimitExceededException;
import java.io.IOException;

public class AddCompactDiscToStoreScreenController {
    private Store store;
    private Cart cart;
    private Runnable windowCloser;

    @FXML
    private Button btnAdd;
    @FXML
    private TextField tfTitle;
    @FXML
    private TextField tfCategory;
    @FXML
    private TextField tfCost;
    @FXML
    private MenuItem viewStore;
    @FXML
    private MenuItem viewCart;
    @FXML
    private MenuItem addBook;
    @FXML
    private MenuItem addDVD;

    public AddCompactDiscToStoreScreenController(Store store, Cart cart){
        super();
        this.store = store;
        this.cart = cart;
    }
    @FXML
    private void initialize(){
        // Add button handlers
        btnAdd.setOnAction(e -> {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            Float cost = Float.parseFloat(tfCost.getText());
            CompactDisc cd = null;
            try {
                cd = new CompactDisc(title, category, cost);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            try {
                store.addMedia(cd);
            } catch (LimitExceededException ex) {
                throw new RuntimeException(ex);
            }
            tfTitle.clear();
            tfCategory.clear();
            tfCost.clear();
        });
        // Menu items handlers
        viewStore.setOnAction(e -> {
            windowCloser.run();
            new StoreScreen(store, cart);
        });
        viewCart.setOnAction(e -> {
            windowCloser.run();
            new CartScreen(cart, store);
        });
        addBook.setOnAction(e -> {
            windowCloser.run();
            new AddBookToStoreScreen(store, cart);
        });
        addDVD.setOnAction(e -> {
            windowCloser.run();
            new AddDigitalVideoDiscToStoreScreen(store, cart);
        });
    }

    // Setup window closer
    public void setWindowCloser(Runnable windowCloser){
        this.windowCloser = windowCloser;
    }
}