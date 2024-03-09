package Controller;

import Model.Magnet;
import Model.ObjectsInGame;

import java.awt.*;

public class Intersection {

    // ToDO: explain why adding this
    private Magnet magnet;

    public Intersection(Magnet magnet) {
        this.magnet = magnet;
    }


    // A method that takes two Rectangle objects as parameters and returns a String that indicates the direction of the intersection, or "none" if there is no intersection
    public void intersect(ObjectsInGame object1, ObjectsInGame object2) {
        // Get the width, height, x, and y coordinates of the objects
        int object1Width = object1.getWidth();
        int object1Height = object1.getHeight();
        int object2Width = object2.getWidth();
        int object2Height = object2.getHeight();
        int object1X = object1.getX();
        int object1Y = object1.getY();
        int object2X = object2.getX();
        int object2Y = object2.getY();

        // Check if the objects have positive width and height, and return "none" if not
        if (object2Width <= 0 || object2Height <= 0 || object1Width <= 0 || object1Height <= 0) {
            return;
        }

        // Calculate the right and bottom coordinates of the objects
        object2Width += object2X;
        object2Height += object2Y;
        object1Width += object1X;
        object1Height += object1Y;

        // Check if the objects overlap, and return "none" if not
        if ((object2Width < object2X || object2Width > object1X) &&
                (object2Height < object2Y || object2Height > object1Y) &&
                (object1Width < object1X || object1Width > object2X) &&
                (object1Height < object1Y || object1Height > object2Y)) {

            // Check the direction of the intersection by comparing the x and y coordinates of the objects

            if ((object1Width >= object2X || object2Width >= object1X) &&
                    object2Height >= object1Y && object2Y <= object1Y) {

                // The top edge of object1 intersects with the bottom edge of object2
                magnet.setMagnetHitUp(true);
            } else {
                magnet.setMagnetHitUp(false);
            }
            if ((object1Width >= object2X || object2Width >= object1X) &&
                    object1Height >= object2Y && object2Y >= object1Y) {

                // The bottom edge of object1 intersects with the top edge of object2
                magnet.setMagnetHitDown(true);
            } else {
                magnet.setMagnetHitDown(false);
            }

            if ((object2Height >= object1Y + 25 && object1Height - 25 > object2Y) &&
                    object2Width >= object1X && object2X <= object1X) {
                // The left edge of object1 intersects with the right edge of object2
                magnet.setMagnetHitLeft(true);
            } else {
                magnet.setMagnetHitLeft(false);
            }
            if ((object2Height >= object1Y + 25 && object1Height - 25 >= object2Y) &&
                    object1Width >= object2X && object2X >= object1X) {
                // The right edge of object1 intersects with the left edge of object2
                magnet.setMagnetHitRight(true);
            } else {
                magnet.setMagnetHitRight(false);
            }

        } else {
            magnet.setMagnetHitDown(false);
            magnet.setMagnetHitUp(false);
            magnet.setMagnetHitLeft(false);
            magnet.setMagnetHitRight(false);

        }

    }

    public boolean intersectTop(ObjectsInGame object1, ObjectsInGame object2) {
        // Get the width, height, x, and y coordinates of the objects
        int object1Width = object1.getWidth();
        int object1Height = object1.getHeight();
        int object2Width = object2.getWidth();
        int object2Height = object2.getHeight();
        int object1X = object1.getX();
        int object1Y = object1.getY();
        int object2X = object2.getX();
        int object2Y = object2.getY();

        // Check if the objects have positive width and height, and return "none" if not
        if (object2Width <= 0 || object2Height <= 0 || object1Width <= 0 || object1Height <= 0) {
            return false;
        }

        // Calculate the right and bottom coordinates of the objects
        object2Width += object2X;
        object2Height += object2Y;
        object1Width += object1X;
        object1Height += object1Y;

        // Check if the objects overlap, and return "none" if not
        if ((object2Width < object2X || object2Width > object1X) &&
                (object2Height < object2Y || object2Height > object1Y) &&
                (object1Width < object1X || object1Width > object2X) &&
                (object1Height < object1Y || object1Height > object2Y)) {

            // Check the direction of the intersection by comparing the x and y coordinates of the objects

            if ((object1Width >= object2X || object2Width >= object1X) &&
                    object2Height >= object1Y && object2Y <= object1Y) {

                // The top edge of object1 intersects with the bottom edge of object2
                return true;
            }

        }
        return false;
    }

    public Magnet getMagnet() {
        return magnet;
    }

    public void setMagnet(Magnet magnet) {
        this.magnet = magnet;
    }
}
