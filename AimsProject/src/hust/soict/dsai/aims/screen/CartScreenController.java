package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;


import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CartScreenController {
    private Cart cart;
    private double currentCost = 0;
    private Runnable windowCloser;

    @FXML
    private javafx.scene.control.TableView<Media> tblMedia;
    @FXML
    private javafx.scene.control.TableColumn<Media, String> colMediaTitle;
    @FXML
    private javafx.scene.control.TableColumn<Media, String> colMediacategory;
    @FXML
    private javafx.scene.control.TableColumn<Media, Float> colMediaCost;
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnRemove;
    @FXML
    private ToggleGroup filterCategory;
    @FXML
    private RadioButton radioBtnFilterId;
    @FXML
    private RadioButton radioBtnFilterTitle;
    @FXML
    private TextField tfFilter;
    @FXML
    private Button btnPlaceOrder;
    @FXML
    private Label lblCost;

    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        // Set columns' headers
        colMediaTitle.setCellValueFactory(
                new PropertyValueFactory<Media, String>("title"));
        colMediacategory.setCellValueFactory(
                new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(
                new PropertyValueFactory<Media, Float>("cost"));
        // Display current cart's items
        tblMedia.setItems(this.cart.getItemsOrdered());

        // Set initial state of Play and Remove button
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        // Cost and Total Cost
        currentCost =this.cart.totalCost();
        lblCost.setText(String.format("%.2f", currentCost) + "$");

        // State of Play and Remove button
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>() {
                    @Override
                    public void changed(ObservableValue<? extends Media> observable,
                                        Media oldValue,
                                        Media newValue) {
                        if (newValue != null) {
                            updateButtonBar(newValue);
                        }
                    }
                }
        );

        // remove button clicked
        btnRemove.setOnAction(e -> {
            Media media = tblMedia.getSelectionModel().getSelectedItem();
            cart.removeMedia(media);
            currentCost -= media.getCost();
            lblCost.setText(String.format("%.2f", currentCost) + "$");
        });

        // Filtering actions
        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue,
                                String newValue) {
                showFilteredMedia(newValue);
            }
        });

        // Place order button clicked
        btnPlaceOrder.setOnAction(e -> {
            cart.placeOrder();
            lblCost.setText(Double.toString(cart.totalCost()) + "$");
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Order placed");
            alert.setHeaderText(null);
            alert.setContentText("Your order has been placed!");
            alert.showAndWait();
        });

        // Play button clicked
        btnPlay.setOnAction(e -> {
            Media media = tblMedia.getSelectionModel().getSelectedItem();
            if (media instanceof Playable) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Playing...");
                alert.setHeaderText(null);
                alert.setContentText("The track is currently playing");
                alert.showAndWait();
            }
        });
    }

    // visibility of Play and remove button
    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        }
        else {
            btnPlay.setVisible(false);
        }
    }

    // Show filtered media
    void showFilteredMedia(String s) {
        try {
            if (!s.equals("")) {
                if (radioBtnFilterId.isSelected()) {
                    radioBtnFilterTitle.setSelected(false);
                    tblMedia.setItems(cart.searchForItemByID(Integer.parseInt(s)));
                } else if (radioBtnFilterTitle.isSelected()) {
                    radioBtnFilterId.setSelected(false);
                    tblMedia.setItems(cart.searchForItemByTitle(s));
                }
            } else tblMedia.setItems(cart.getItemsOrdered());
        } catch (Exception e){}
    }
}
