package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.store.Store.Store;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.*;
import java.awt.*;

import java.io.IOException;

public class CartScreen extends JFrame {
    private Cart cart;
    private Store store;

    public CartScreen(Cart cart, Store store){
        super();

        this.cart = cart;
        this.store = store;

        // Setup Panel
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setSize(new Dimension(1024, 768));
        this.setVisible(true);
        Runnable windowCloser = () -> SwingUtilities.invokeLater(
                () -> this.setVisible(false)
        );
        // Run
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass()
                            .getResource("cart.fxml"));
                    CartScreenController controller =
                            new CartScreenController(store, cart, this);
                    loader.setController(controller);
                    controller.setWindowCloser(windowCloser);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    // This class is just for test!
    public static void main(String[] args) {
        Cart cart = new Cart();
        Store store = new Store();
        new CartScreen(cart, store);
    }
}
