package editor;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.Font.*;
import java.awt.*;
class Test extends JFrame implements ActionListener
{
	JTextArea ta=new JTextArea();
	JMenuItem filenew=new JMenuItem("新建（N）");
	JMenuItem fileopen=new JMenuItem("打开（O）");
	JMenuItem filesave=new JMenuItem("保存（S）");
	JMenuItem filesaveother=new JMenuItem("另存为（A）");
	JMenuItem filepagesetup=new JMenuItem("页面设置（U）");
	JMenuItem fileprint=new JMenuItem("打印（P）");
	JMenuItem fileexit=new JMenuItem("退出（X）");
	JMenuItem editcancel=new JMenuItem("撤销（U）");
	JMenuItem editcut=new JMenuItem("剪切（T）");
	JMenuItem editcopy=new JMenuItem("复制（C）");
	JMenuItem editpaste=new JMenuItem("粘贴（P）");
	JMenuItem editdelete=new JMenuItem("删除（L）");
	JMenuItem editsearch=new JMenuItem("查找（F）");
	JMenuItem editchange=new JMenuItem("替换（R）");
	JMenuItem editturn=new JMenuItem("转到（G）");
	
	JMenuItem editallselect=new JMenuItem("全选（A）");
	JMenuItem edittime=new JMenuItem("时间/日期（P）");
	JMenuItem formlinewrap=new JMenuItem("自动换行（W）");
	JMenuItem formfont=new JMenuItem("字体（F）");
	
	JMenuItem lookstatus=new JMenuItem("状态栏（S）");
	JMenuItem helplook=new JMenuItem("查看帮助（H）");
	JMenuItem helpabout=new JMenuItem("关于记事本（A）");
Test()
{
super("记事本");
JMenu file=new JMenu("文件（F）");
file.add(filenew);filenew.setEnabled(true);
file.add(fileopen);fileopen.setEnabled(true);
file.add(filesave);filesave.setEnabled(true);
file.add(filesaveother);filesaveother.setEnabled(true);
file.addSeparator();
file.add(filepagesetup);filepagesetup.setEnabled(true);
file.add(fileprint);fileprint.setEnabled(true);
file.addSeparator();
file.add(fileexit);fileexit.setEnabled(true);
JMenu edit=new JMenu("编辑（E）");
edit.add(editcancel);editcancel.setEnabled(true);
edit.addSeparator();
edit.add(editcut);editcut.setEnabled(true);
edit.add(editcopy);editcopy.setEnabled(true);
edit.add(editpaste);editpaste.setEnabled(true);
edit.add(editdelete);editdelete.setEnabled(true);
edit.addSeparator();
edit.add(editsearch);editsearch.setEnabled(true);
edit.add(editchange);editchange.setEnabled(true);
edit.add(editturn);editchange.setEnabled(false);

edit.addSeparator();
edit.add(editallselect);editallselect.setEnabled(true);
edit.add(edittime);edittime.setEnabled(true);
JMenu form=new JMenu("格式（O）");
form.add(formlinewrap);formlinewrap.setEnabled(true);
form.add(formfont);formfont.setEnabled(true);
JMenu look=new JMenu("查看（V）");
look.add(lookstatus);lookstatus.setEnabled(false);
JMenu help=new JMenu("帮助（H）");
help.add(helplook);helplook.setEnabled(true);
help.add(helpabout);helpabout.setEnabled(true);
JMenuBar bar=new JMenuBar();
setJMenuBar(bar);
bar.add(file);
bar.add(edit);
bar.add(form);
bar.add(look);
bar.add(help);
add(new JScrollPane(ta));

fileexit.addActionListener(this);
editchange.addActionListener(this);
editsearch.addActionListener(this);
formfont.addActionListener(this);
setSize(950,880);
setVisible(true);
setDefaultCloseOperation(EXIT_ON_CLOSE);
}
public void actionPerformed(ActionEvent e) {
	// TODO 自动生成的方法存根
	if(e.getSource()==fileexit)
	{
		System.exit(0);
	}
	if(e.getSource()==formfont)
	{
		
		fontDialog dia=new fontDialog(ta);
		dia.setVisible(true);
		
	}
}
}
class fontDialog extends JDialog implements ActionListener,ListSelectionListener,ItemListener
{
	JButton btn1=new JButton("确定");
	JButton btn2=new JButton("取消");
	JTextField txt1=new JTextField(20);
	JTextField txt2=new JTextField(10);
	JTextField txt3=new JTextField(4);
	JTextField ta1=new JTextField(10);
	JComboBox jc=new JComboBox();
	String name="宋体";
	int style=Font.PLAIN;
	int size=12;
	GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
	String[] fontname=ge.getAvailableFontFamilyNames();
	String[] fontstyle={"常规","粗体","倾斜","粗体倾斜"};
	String[] fontsize={"8","9","10","11","12","14","16","18","20","22","24","26","28","36","48","72","初号","小初","一号","小一","二号","小二","三号","小三","四号","小四","五号","小五","六号","小六","七号","八号"};
	JLabel la1=new JLabel("字体（F）：");
	JLabel la2=new JLabel("字形（Y）：");
	JLabel la3=new JLabel("大小（S）：");
	JLabel la4=new JLabel("脚本（R）：");
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JPanel p3=new JPanel();
	JPanel p21=new JPanel();
	JPanel p22=new JPanel();
	JPanel p23=new JPanel();
	JPanel p31=new JPanel();
	JPanel p32=new JPanel();
	JPanel p33=new JPanel();
	JPanel p4=new JPanel();
	JList list1=new JList(fontname);
	JList list2=new JList(fontstyle);
	JList list3=new JList(fontsize);
	JScrollPane jsp1=new JScrollPane(list1);
	JScrollPane jsp2=new JScrollPane(list2);
	JScrollPane jsp3=new JScrollPane(list3);
	



	fontDialog(JTextArea ta)
	{
		//super(f,s);
		setSize(720,690);
		setVisible(true);
		
		GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
		
		p31.setBorder(BorderFactory.createTitledBorder("标题"));
		
		p31.add("Center",ta1);ta1.setEditable(false);
		
		p32.add(la4);
		jc.addItem("中文 GB2312");
		jc.addItem("西欧语言");
		jc.addItem("中欧语言");
		jc.addItem("希腊语");
		jc.addItemListener(this);
		p33.add(jc);
		p3.setLayout(null);
		p3.setPreferredSize(new Dimension(700,900));
		p31.setBounds(450,0,150,80);
		p32.setBounds(420,100,150,20);
		p33.setBounds(410,120,200,40);
		/*p32.setLayout(null);
		p32.setPreferredSize(new Dimension(150,110));
		la4.setBounds(0,10,140,20);
		p33.setLayout(null);
		p33.setPreferredSize(new Dimension(150,110));
		jc.setBounds(0,10,140,20);*/
		p3.add(p31);
		p3.add(p32);
		p3.add(p33);
        add(p3);
		
		
		
		
		
		txt1.setEditable(false);
		txt2.setEditable(false);
		txt3.setEditable(false);
		p1.add(btn1);
		p1.add(btn2);
		p1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		add("South",p1);
		
		p21.setLayout(null);
		p21.setPreferredSize(new Dimension(220,250));
		la1.setBounds(0,10,120,20);
		txt1.setBounds(0,30,120,20);
		jsp1.setBounds(0,50,120,120);
		p21.add(la1);
		p21.add(txt1);
		p21.add(jsp1);
		
		
		p22.setLayout(null);
		p22.setPreferredSize(new Dimension(220,250));
		la2.setBounds(0,10,120,20);
		txt2.setBounds(0,30,120,20);
		jsp2.setBounds(0,50,120,120);
		p22.add(la2);
		p22.add(txt2);
		p22.add(jsp2);
		
		p23.setLayout(null);
		p23.setPreferredSize(new Dimension(220,250));
		la3.setBounds(0,10,100,20);
		txt3.setBounds(0,30,100,20);
		jsp3.setBounds(0,50,100,110);	
		p23.add(la3);
		p23.add(txt3);
		p23.add(jsp3);
		
		p2.add("West",p21);
		p2.add("Center",p22);
		p2.add("East",p23);
		p2.setLayout(new FlowLayout());
		add("North",p2);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		//list1.addActionListener(this);
		//list2.addActionListener(this);
		//list3.addActionListener(this);
		validate();
	}
	
	

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btn1)
		{
			
			Font f=new Font(name,style,size);
			ta1.setFont(f);
		}
		if(e.getSource()==btn2)
		{
			setVisible(false);
		}
		
		
	}
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==list1)
			fontname=(String[])list1.getSelectedValue();
		    
		   // txt1.setFont(fontname);
		
		if(e.getSource()==list2)
			fontstyle=(String[])list2.getSelectedValue();
			txt2.setText(""+style);
		
		if(e.getSource()==list3)
			fontsize=(String[])list3.getSelectedValue();
			
		   txt3.setText(""+size);
	}
	public void itemStateChanged(ItemEvent e)
	{
		String s=(String)e.getItem().toString();
	}
}
public class Editor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
new Test();
	}

}