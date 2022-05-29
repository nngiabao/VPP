/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class LeftMenu extends JPanel implements MouseListener{
    private JLabel lbName,icon;
    private Color hover = new Color(100, 113, 140);
    private Color normal = new Color(67, 76, 94);
    //private Color normal = new Color(100, 113, 140);
    private boolean active ;
    private String name,img,imgActive,imgHover;
    private Rectangle rec = new Rectangle();
    public LeftMenu(String ten,Rectangle size,String img,String imgActive )
    {
        name = ten;
        lbName = new JLabel(name);
        this.img = img;
        this.imgActive = imgActive;
        this.imgHover = this.img;
        this.icon = new JLabel();
        rec = size;
        init();
    }
    public LeftMenu(String ten,Rectangle size,String img,String imgActive,String imgHover,Color hover)
    {
        name = ten;
        lbName = new JLabel(name);
        this.img = img;
        this.imgActive = imgActive;
        this.imgHover = imgHover;
        this.icon = new JLabel();
        rec = size;
        this.hover = hover;
        init();
    }
    public LeftMenu(String s,Rectangle r)
    {
        lbName = new JLabel(s);
        icon = new JLabel();
        rec = r;
        init();
    }
    
    public void setColorNormal(Color color)
    {
        this.normal = color;
        setBackground(normal);
        repaint();   
    }
    
    public JPanel isButton()
    {
        icon.setBounds(new Rectangle(0 , 8, 50, 30));
        normal = null;
        setBackground(normal);
//        repaint();
        return this;
    }
    public JPanel isLogout()
    {
        icon.setBounds(new Rectangle(0 , 6, 50, 34));
        normal = null;
        setBackground(normal);
//        repaint();
        return this;
    }
    public JPanel isLogin()
    {
        icon.setBounds(new Rectangle(0 , 0, 50, 46));
        normal = null;
        setBackground(normal);
//        repaint();
        return this;
    }
    public void init()
    {

        addMouseListener(this);
        Font font = new Font("Arials",Font.BOLD,15);
        setLayout(null);
        setBounds(rec);
        
        icon.setIcon(new ImageIcon("./src/img/"+img));
        //icon.setBackground(Color.white);
        icon.setBounds(new Rectangle(15 , 5, 50, 40));
        
        lbName.setFont(font);
        lbName.setForeground(Color.white);
        lbName.setBounds(new Rectangle(rec.width/4+4, rec.height/4, 150, 30));
           
        if(active)
        {
            setBackground(Color.WHITE);
        }
        else
        {
            setBackground(normal);
        } 
        add(icon);
        add(lbName);
        
    }
    public void setActive(boolean a)
    {
        active = a;
        
    }

    public String getName() {
        return name;
    }
    
    public void doActive()
    {
        active = true;
        icon.setIcon(new ImageIcon("./src/img/"+imgActive));
        lbName.setForeground(Color.BLACK);
        setBackground(Color.WHITE);
    }
    public void noActive()
    {
        active = false;
        icon.setIcon(new ImageIcon("./src/img/"+img));
        lbName.setForeground(Color.WHITE);
        setBackground(normal);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(!active)
        {
            setBackground(hover);
            icon.setIcon(new ImageIcon("./src/img/"+imgHover));
        }
    }

    @Override
    public void mouseExited(MouseEvent e){
        if(!active)
        {
            setBackground(normal);
            icon.setIcon(new ImageIcon("./src/img/"+img));
        }
    }
}
