package com.mycompany.hotelmanagement.utils;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class HoverImageHelper {

    private static final String ICON_PATH = "/com/mycompany/hotelmanagement/icons/";

    public static void setupHoverEffect(Button button, ImageView imageView, String normalIconFile, String hoverIconFile) {
        if (button != null || imageView != null) {
            Image normalImage = loadImage(normalIconFile);
            Image hoverImage = loadImage(hoverIconFile);

            imageView.setImage(normalImage);

            // hover vào
            button.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> imageView.setImage(hoverImage));

            // hover ra
            button.addEventHandler(MouseEvent.MOUSE_EXITED, event -> imageView.setImage(normalImage));
        } else {
            System.err.println("HoverImageHelper: button và imageView đang null!");
        }
    }

    private static Image loadImage(String fileName) {
        return new Image(HoverImageHelper.class.getResource(ICON_PATH + fileName).toExternalForm());
    }
    
    
}
