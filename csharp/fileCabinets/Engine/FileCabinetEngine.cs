using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using csFileCabinets.Structs;
using System.Windows.Controls;
using csFileCabinets.Utility;
using System.Windows.Media;
//using csFileCabinets.Utility;

namespace csFileCabinets.Engine
{
    /*
     * Like with the Java version, MainWindow.xaml.cs will
     * call to this class and the bulk of the work will be
     * done here.
     */ 
    class FileCabinetEngine
    {
        private MainWindow mw;

        private List<FileCabinet> cabinets;

        public FileCabinetEngine(MainWindow main)
        {
            mw = main;
            cabinets = new List<FileCabinet>();
        }

        public bool addDrawer()
        {
            if (mw.valueInput.Text.Length > 0)
            {
                Drawer d = new Drawer(mw.valueInput.Text);
                TreeViewItem tvi = null;
                tvi = new TreeViewItem();
                tvi.Header = d.DrawerName;
                tvi.DataContext = d;
                tvi.MouseLeftButtonUp += mw.getSelectedItem;
                ((TreeViewItem)(mw.myTree.SelectedItem)).Items.Add(tvi);
                return true;
            }
            else
            {
                string msg = "Please enter the name of the new Drawer into the value field above.";
                mw.updateMessage(msg, Constants.FAIL_MSG_COLOR);
                return false;
            }
        }

        public bool addFileCabinet()
        {
            if (mw.valueInput.Text.Length > 0)
            {
                string value = mw.valueInput.Text;
                FileCabinet fc = new FileCabinet(value);
                string msg = "Successfully added FileCabinet";
                mw.updateMessage(msg, Constants.SUCCESS_MSG_COLOR);
                return true;
            }
            else
            {
                return false;
            }
        }

        public bool addNode()
        {
            if (mw.keyInput.Text.Length>0 && mw.valueInput.Text.Length > 0)
            {
                string key = mw.keyInput.Text;
                string value = mw.valueInput.Text;
                BaseNode newNode = RedirectInput.redirectInput(key, value);
                TreeViewItem tvi = (TreeViewItem)mw.myTree.SelectedItem;
                tvi.MouseLeftButtonUp += mw.getSelectedItem;
                Structs.Page p = (Structs.Page)tvi.DataContext;
                if (p.addNode(newNode))
                {
                    ((TreeViewItem)mw.myTree.SelectedItem).Items.Add(new TreeViewItem() { Header = newNode.ToString(), DataContext = newNode });

                    return true;
                }
                else
                {
                    mw.errorMsg.Text = "Nuts";
                    return false;
                }
            }
            else
            {
                return false;
            }
        }

        public bool addPage()
        {
            Structs.Page p = new Structs.Page(((Drawer)(((TreeViewItem)mw.myTree.SelectedItem).DataContext)).incrementID());
            ((Drawer)(((TreeViewItem)mw.myTree.SelectedItem).DataContext)).addPage(p);
            TreeViewItem tvi = new TreeViewItem();
            tvi.MouseLeftButtonUp += mw.getSelectedItem;
            tvi.Header = "Page: " + p.Id;
            tvi.DataContext = p;
            ((TreeViewItem)(mw.myTree.SelectedItem)).Items.Add(tvi);
            return true;
        }
    }
}
