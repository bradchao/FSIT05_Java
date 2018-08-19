package tw.org.iii.mytest;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MySign extends JFrame {
	private JButton clear, undo, redo, saveJPG, saveObject, loadObject;
	private MyView myView;
	
	public MySign() {
		super("簽名");
	
		setLayout(new BorderLayout());
		JPanel top = new JPanel(new FlowLayout());
		clear = new JButton("Clear");
		undo = new JButton("Undo");
		redo = new JButton("Redo");
		saveJPG = new JButton("Save JPEG");
		saveObject = new JButton("Save Object");
		loadObject = new JButton("Load Object");
		top.add(clear); top.add(undo);top.add(redo);
		top.add(saveJPG); top.add(saveObject); top.add(loadObject);
		add(top, BorderLayout.NORTH);
		
		myView = new MyView();
		add(myView, BorderLayout.CENTER);
		
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myView.clear();
			}
		});
		undo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myView.undo();
			}
		});
		redo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myView.redo();
			}
		});
		
		saveJPG.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//saveJPEG();
				myView.saveJPEG();
			}
		});
		saveObject.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveObject();
			}
		});
		loadObject.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loadObject();
			}
		});
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void saveJPEG() {
		BufferedImage imagebuf = null;
		
		try {
	        imagebuf = new Robot().createScreenCapture(myView.bounds());
	    } catch (AWTException e1) {
	        // TODO Auto-generated catch block
	        e1.printStackTrace();
	    } 
		Graphics2D graphics2D = imagebuf.createGraphics();
	    myView.paint(graphics2D);
		
		try {
			ImageIO.write(imagebuf,"jpeg", new File("dir1/save1.jpeg"));
			
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	private void saveObject() {
		LinkedList<LinkedList<MyPoint>> lines = myView.getLines();
		try {
			ObjectOutputStream oout =
				new ObjectOutputStream(
					new FileOutputStream("dir1/brad.obj"));
			oout.writeObject(lines);
			oout.flush();
			oout.close();
			JOptionPane.showMessageDialog(this, "Save OK");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	private void loadObject() {
		try {
			ObjectInputStream oin = 
				new ObjectInputStream(
					new FileInputStream("dir1/brad.obj"));
			LinkedList<LinkedList<MyPoint>> lines = 
				(LinkedList<LinkedList<MyPoint>>)oin.readObject();
			oin.close();
			myView.setLines(lines);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
	}
	
	public static void main(String[] args) {
		new MySign();
	}	

}
