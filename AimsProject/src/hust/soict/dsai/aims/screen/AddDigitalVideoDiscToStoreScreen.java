package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.store.Store.Store;
import hust.soict.dsai.aims.cart.Cart.Cart;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.*;
import java.awt.*;

import java.io.IOException;

public class AddDigitalVideoDiscToStoreScreen extends JFrame {
    private Store store;
    private Cart cart;

    public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart) {
        super();

        this.store = store;
        this.cart = cart;
        // Setup panel
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Add Digital Video Disc");
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
                            .getResource("addDVD.fxml"));
                    AddDigitalVideoDiscToScreenController controller = new
                            AddDigitalVideoDiscToScreenController(store, cart);
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