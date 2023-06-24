package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
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

    public CartScreen(Cart cart){
        super();

        this.cart = cart;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setSize(new Dimension(1024, 768));
        this.setVisible(true);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass()
                            .getResource("cart.fxml"));
                    CartScreenController controller =
                            new CartScreenController(cart);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public static void main(String[] args) {
        Cart cart = new Cart();
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

//         Add media to cart
        cart.addMedia(book1);
        cart.addMedia(book2);
        cart.addMedia(book3);
        cart.addMedia(cd1);
        cart.addMedia(cd2);
        cart.addMedia(cd3);
        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);
        new CartScreen(cart);
    }
}
