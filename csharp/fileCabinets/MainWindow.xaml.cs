using System;
using System.Windows;
using System.Windows.Controls;
using csFileCabinets.Structs;
using csFileCabinets.Engine;
using csFileCabinets.Utility;
using System.Windows.Media;

namespace csFileCabinets
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private FileCabinetEngine fce;
        public MainWindow()
        {
            InitializeComponent();
            /*
             * look into moving this TreeViewItem to a class member to allow
             * for searching through it later
             */
            TreeViewItem tvi = null;
            fce = new FileCabinetEngine(this);
            /*
             * Now, like with the Java version, call methods 
             * from the engine and keep this file small
             */

            tvi = new TreeViewItem();
            tvi.Header = "root";
            tvi.MouseLeftButtonUp += getSelectedItem;
            myTree.Items.Add(tvi);
            addFileCabinetBtn.IsEnabled = false;
            addPageBtn.IsEnabled = false;
            addNodeBtn.IsEnabled = false;
            /*
             * Need to add functionality to read FileCabinets in from file,
             * and load them into the tvi
             */
        }

        private void addPageBtn_Click(object sender, RoutedEventArgs e)
        {
            fce.addPage();
        }

        private void addNodeBtn_Click(object sender, RoutedEventArgs e)
        {
            fce.addNode();
            errorMsg.Text = "Added Node";
        }

        public void getSelectedItem(object sender, RoutedEventArgs e)
        {
            if (((TreeViewItem)(myTree.SelectedItem)).Header.Equals("root"))
            {
                //errorMsg.Text = "A: root";
                activeElementDisp.Text = "Active Element: root";
                addFileCabinetBtn.IsEnabled = true;
                addDrawerBtn.IsEnabled = true;
                addPageBtn.IsEnabled = false;
                addNodeBtn.IsEnabled = false;
                saveDrawerBtn.IsEnabled = false;
            }
            else if (((TreeViewItem)(myTree.SelectedItem)).DataContext.GetType().Name.ToString().Equals("Page"))
            {
                int displayText = ((Structs.Page)((TreeViewItem)(myTree.SelectedItem)).DataContext).Id;
                activeElementDisp.Text = "Active Element: Page - " + displayText;
                addFileCabinetBtn.IsEnabled = false;
                addPageBtn.IsEnabled = false;
                addNodeBtn.IsEnabled = true;
                saveDrawerBtn.IsEnabled = false;
            }
            else if (((TreeViewItem)(myTree.SelectedItem)).DataContext.GetType().Name.ToString().Equals("Drawer"))
            {
                string displayText = ((Drawer)((TreeViewItem)(myTree.SelectedItem)).DataContext).DrawerName;
                activeElementDisp.Text = "Active Element: Drawer - "+ displayText;
                addFileCabinetBtn.IsEnabled = false;
                addDrawerBtn.IsEnabled = false;
                addPageBtn.IsEnabled = true;
                addNodeBtn.IsEnabled = false;
                saveDrawerBtn.IsEnabled = true;
            }
            else
            {
                saveDrawerBtn.IsEnabled = false;
                errorMsg.Text = "ummm: " + ((TreeViewItem)(myTree.SelectedItem)).DataContext.GetType().Name.ToString();
            }
        }

        private void addFileCabinetBtn_Click(object sender, RoutedEventArgs e)
        {
            string value = valueInput.Text;
            FileCabinet fc = new FileCabinet(value);
            string msg = "Successfully added FileCabinet";
            updateMessage(msg, Constants.SUCCESS_MSG_COLOR);
            //TreeViewItem tvi = null;
            //tvi = new TreeViewItem();
            //tvi.MouseLeftButtonUp += getSelectedItem;
            //myTree.Items.Add(tvi);
        }

        private void addDrawerBtn_Click(object sender, RoutedEventArgs e)
        {
            if (fce.addDrawer())
            {
                errorMsg.Foreground = new SolidColorBrush(Colors.Black);
                errorMsg.Text = "Successfully added Drawer";
            }
        }

        private void testPopupBtn_Click(object sender, RoutedEventArgs e)
        {
            TestPopup tp = new TestPopup();
            tp.Owner = this;
            tp.Show();
        }

        private void saveTestBtn_Click(object sender, RoutedEventArgs e)
        {
            Drawer d = new Drawer("sampleDrawer");
            msgBox.Text += "Created drawer\n";
            Structs.Page p = new Structs.Page(d.incrementID());
            msgBox.Text += "Created Page\n";
            if (p.addNode(new StringNode("firstName", "Sean"))) msgBox.Text += "Added firstName - Node Count: " + p.getNodes().Count+"\n";
            if (p.addNode(new StringNode("lastName", "Hayes"))) msgBox.Text += "Added lastName - Node Count: " + p.getNodes().Count + "\n";
            if (p.addNode(new DoubleNode("longestRun", 13.1))) msgBox.Text += "Added longestRun - Node Count: " + p.getNodes().Count + "\n";
            if (p.addNode(new IntegerNode("age", 32))) msgBox.Text += "Added age - Node Count: " + p.getNodes().Count + "\n";
            d.addPage(p);
            Folder f = new Folder("sampleFolder1");
            p = new Structs.Page(f.idIncrement());
            p.addNode(new StringNode("firstName", "Anne"));
            f.addPage(p);
            p = new Structs.Page(f.idIncrement());
            p.addNode(new StringNode("firstName", "Alex"));
            f.addPage(p);
            d.addFolder(f);
            msgBox.Text += "Created drawer\n";
            msgBox.Text += d.Pages.Count+"\n";
            ReadWrite.writeToXml(d);
            msgBox.Text += "Created drawer\n";
        }

        private void saveDrawerBtn_Click(object sender, RoutedEventArgs e)
        {
            ReadWrite.writeToXml((Drawer)(((TreeViewItem)myTree.SelectedItem).DataContext));
            string msg = "Drawer " + ((Drawer)(((TreeViewItem)myTree.SelectedItem).DataContext)).DrawerName + " saved successfully";
            updateMessage(msg, Constants.SUCCESS_MSG_COLOR);

        }

        public void updateMessage(string s, SolidColorBrush scb)
        {
            errorMsg.Foreground = scb;
            errorMsg.Text = s;
        }

        private void buildTree()
        {
            /*
             * Emulate the populate tree method in the java version
             * to iterate through the fcRepo's folders (the File
             * Cabinets) and then through each of the .xml files
             * within those folders to build out the tree.
             */
        }
    }
}
