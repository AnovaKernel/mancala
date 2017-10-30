package nl.sogyo.mancala.presentation;

import nl.sogyo.mancala.logic.Bowl;

import javax.swing.*;
import java.awt.*;

/**
 * Project: mancala
 * FQCN: nl.sogyo.mancala.presentation.UI
 * <p>
 * Created by kverlaan
 * on 10/23/2017
 */
public class UI extends JFrame {

    private int width = 400, height = 400;
    private Bowl bowl;

    private UI() throws HeadlessException {

        setBounds(50, 50, width, height);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        bowl = new Bowl();
        bowl.play(1);
        bowl.play(8); //p2
        bowl.play(2); //p1
        bowl.play(3); //p1
        bowl.play(9); //p2 (ends in bowl 1)
        bowl.play(4); //p1
        bowl.play(8); //p2
        bowl.play(6); //p1
        bowl.play(8); //p2
        bowl.play(5); //p1
        bowl.play(8); //p2
        bowl.play(6); //p1 should end up in 1

    }

    public static void main(String... args) {

        new UI();

    }

    public void paint(Graphics gfx) {

        gfx.setColor(Color.WHITE);
        gfx.fillRect(50, 50, width, height);

        int midX, midY, stepY, stepX, sizeX, sizeY;
        midX = width / 2;
        midY = height / 2;
        stepY = height / 10;
        stepX = width / 10; //does this work?
        sizeX = width / 12;
        sizeY = height / 12;

        //player1
        gfx.setColor(Color.GREEN);
        gfx.fillOval(midX - stepX * 3, midY + stepY, sizeX, sizeY);
        gfx.fillOval(midX - stepX * 2, midY + stepY, sizeX, sizeY);
        gfx.fillOval(midX - stepX, midY + stepY, sizeX, sizeY);
        gfx.fillOval(midX + stepX, midY + stepY, sizeX, sizeY);
        gfx.fillOval(midX + stepX * 2, midY + stepY, sizeX, sizeY);
        gfx.fillOval(midX + stepX * 3, midY + stepY, sizeX, sizeY);
        //kalaha
        gfx.fillOval(midX + stepX * 4, midY - stepY / 2, sizeX, sizeY * 2);

        //player2
        gfx.setColor(Color.RED);
        gfx.drawOval(midX + stepX, midY - stepY, sizeX, sizeY);
        gfx.drawOval(midX - stepX, midY - stepY, sizeX, sizeY);
        gfx.drawOval(midX + stepX * 2, midY - stepY, sizeX, sizeY);
        gfx.drawOval(midX - stepX * 2, midY - stepY, sizeX, sizeY);
        gfx.drawOval(midX + stepX * 3, midY - stepY, sizeX, sizeY);
        gfx.drawOval(midX - stepX * 3, midY - stepY, sizeX, sizeY);
        gfx.drawOval(midX - stepX * 4, midY - stepY / 2, sizeX, sizeY * 2);

        gfx.setColor(Color.BLACK);
        gfx.drawString(bowl.getBeads() + "", midX - stepX * 3 + sizeX / 2, midY + stepY + sizeY / 2);
        gfx.drawString(bowl.getNeighbour(1).getBeads() + "", midX - stepX * 2 + sizeX / 2, midY + stepY + sizeY / 2);
        gfx.drawString(bowl.getNeighbour(2).getBeads() + "", midX - stepX + sizeX / 2, midY + stepY + sizeY / 2);
        gfx.drawString(bowl.getNeighbour(3).getBeads() + "", midX + stepX + sizeX / 2, midY + stepY + sizeY / 2);
        gfx.drawString(bowl.getNeighbour(4).getBeads() + "", midX + stepX * 2 + sizeX / 2, midY + stepY + sizeY / 2);
        gfx.drawString(bowl.getNeighbour(5).getBeads() + "", midX + stepX * 3 + sizeX / 2, midY + stepY + sizeY / 2);
        gfx.drawString(bowl.getKalaha().getBeads() + "", midX + stepX * 4 + sizeX, midY - stepY / 2 + sizeY);

        gfx.drawString(bowl.getNeighbour(12).getBeads() + "", midX - stepX * 3 + sizeX / 2, midY - stepY + sizeY / 2);
        gfx.drawString(bowl.getNeighbour(11).getBeads() + "", midX - stepX * 2 + sizeX / 2, midY - stepY + sizeY / 2);
        gfx.drawString(bowl.getNeighbour(10).getBeads() + "", midX - stepX + sizeX / 2, midY - stepY + sizeY / 2);
        gfx.drawString(bowl.getNeighbour(9).getBeads() + "", midX + stepX + sizeX / 2, midY - stepY + sizeY / 2);
        gfx.drawString(bowl.getNeighbour(8).getBeads() + "", midX + stepX * 2 + sizeX / 2, midY - stepY + sizeY / 2);
        gfx.drawString(bowl.getNeighbour(7).getBeads() + "", midX + stepX * 3 + sizeX / 2, midY - stepY + sizeY / 2);
        gfx.drawString(bowl.getOpposite().getKalaha().getBeads() + "", midX - stepX * 4 + sizeX, midY - stepY / 2 + sizeY);

    }
}
