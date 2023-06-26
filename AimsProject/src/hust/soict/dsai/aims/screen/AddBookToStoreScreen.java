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

public class AddBookToStoreScreen extends JFrame {
    private Store store;
    private Cart cart;

    public AddBookToStoreScreen(Store store, Cart cart) {
        super();
        this.store = store;
        this.cart = cart;

        // initiate panel
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        // Configure panel
        this.setTitle("Add Book To Store");
        this.setSize(new Dimension(600, 400));
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
                            .getResource("addBook.fxml"));
                    AddBookToStoreScreenController controller = new
                            AddBookToStoreScreenController(store, cart);
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
}
