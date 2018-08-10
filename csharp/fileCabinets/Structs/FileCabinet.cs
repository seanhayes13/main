using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using csFileCabinets.Structs.Arrays;

namespace csFileCabinets.Structs
{
    class FileCabinet
    {
        private string fcName;
        private List<Drawer> drawers;
        private StringArray drawerList;
        private Drawer drawerConfig;
        private Drawer activeDrawer;
        private string activeFolder;
        private Page activePage;
        private BaseNode activeNode;

        public FileCabinet()
        {
            drawers = new List<Drawer>();
            drawerList = new StringArray("drawerNames", new List<String>());
            drawerConfig = new Drawer("drawerConfigs");
        }

        public FileCabinet(string name)
        {
            drawers = new List<Drawer>();
            drawerList = new StringArray("drawerNames", new List<string>());
            drawerConfig = new Drawer("drawerConfigs");
            fcName = name;
            System.IO.Directory.CreateDirectory("fcRepo/"+name);
            //COPPERHEAD - Come back to this after figuring out how to work with files
            //File f = new File("fcRepo//" + fcName);
            //if (!f.exists())
            //{
            //    Console.WriteLine("directory does not exist, yet...");
            //    f.mkdir();
            //    Console.WriteLine("now it does...");
            //}
            //else
            //{
            //    Console.WriteLine("directory already exists...");
            //}
            //LogTracker.initLog(fcName);
        }

        public void addDrawer(Drawer d)
        {
            drawers.Add(d);
            drawerList.add(d.DrawerName);
        }

        public void clearActiveDrawer()
        {
            if (activeDrawer != null) activeDrawer = null;
        }

        public void clearActiveNode()
        {
            if (activeNode != null) activeNode = null;
        }

        public void clearActivePage()
        {
            if (activePage != null) activePage = null;
        }

        public void clearAllActiveFolder()
        {
            if (activeFolder != null) activeFolder = null;
        }

        public void clearOneActiveFolder()
        {
            //This will need to check if the size of temp is 0 after removing the last
            //If size is zero, set activeFolder to null
            if (activeFolder != null)
            {
                //COPPERHEAD - commenting this out until I write the ParseCommand utility
                //List<string> temp = ParseCommand.parseFolderInput(activeFolder);
                List<String> temp = new List<string>();
                StringBuilder sb = new StringBuilder();
                temp.RemoveAt(temp.Count - 1);
                if (temp.Count == 0)
                {
                    activeFolder = null;
                }
                else
                {
                    sb.Append(temp[0]);
                    temp.RemoveAt(0);
                    if (temp.Count >= 1)
                    {
                        foreach (String s in temp)
                        {
                            sb.Append("|" + s);
                        }
                    }
                    activeFolder = sb.ToString();
                }
            }
            else
            {
                Console.WriteLine("The activeFolder has already been cleared");
            }
        }

        public Boolean deleteDrawer(String tgt)
        {
            Boolean confirm = false;
            int found = -1;
            if (drawers.Count == 0)
            {
                Console.WriteLine("Nothing to delete...");
            }
            else
            {
                for (int i = 0; i < drawers.Count; i++)
                {
                    if (drawers[i].DrawerName.Equals(tgt))
                    {
                        found = i;
                    }
                }
                //COPPERHEAD - Come back to this after figuring out how to work with files
                //confirm = new File("fcRepo\\" + fcName + "//" + drawers.get(found).getDrawerName() + ".xml").delete();
                drawers.RemoveAt(found);
                updateConfigs();

            }
            Console.WriteLine(tgt + " found at index " + found);
            return confirm;
        }

        /**
         * Deletes a Page with the specified ID value. As with the other delete functions, confirming the action
         * is done before this function is called.
         * @param i The ID value of the Page that needs to be deleted.
         * @return True if the Page was deleted, false if not
         */
        public Boolean deleteFolder(String s)
        {
            Boolean confirm = false;
            confirm = activeDrawer.deleteFolder(s);
            if (confirm)
            {
                //saveFileCabinet();
                confirm = true;
            }
            return confirm;
        }

        /**
         * Deletes a Node with a specific nKey. As with the other delete functions, confirming the action
         * is done before this function is called.
         * @param s The nKey value of the Node to delete
         * @return Returns true if the Node was found and deleted; false if not
         */
        public Boolean deleteNode(String s)
        {
            Boolean confirm = false;
            confirm = activePage.deleteNodeByKey(s);
            return confirm;
        }

        /**
         * Deletes a Page with the specified ID value. As with the other delete functions, confirming the action
         * is done before this function is called.
         * @param i The ID value of the Page that needs to be deleted.
         * @return True if the Page was deleted, false if not
         */
        public Boolean deletePage(int i)
        {
            Boolean confirm = false;
            confirm = activeDrawer.deletePage(i);
            if (confirm)
            {
                //saveFileCabinet();
                confirm = true;
            }
            return confirm;
        }

        public Drawer getDrawer(string s)
        {
            foreach (Drawer d in drawers)
            {
                if (d.DrawerName.Equals(s)) return d;
            }
            return null;
        }

        public List<string> getDrawerNames()
        {
            List<string> result = new List<string>();
            foreach (Page p in drawerConfig.Pages)
            {
                foreach (BaseNode i in p.getNodes())
                {
                    result.Add(i.NKey);
                }
            }
            return result;
        }

        public int getDrawerSize()
        {
            return drawers.Count;
        }

        /*COPPERHEAD - Commenting this out until I figure out how to work with files, write the 
         * ReadWrite and Logger utilities, and determine if the program even needs this anymore
        */
        //public void loadAllDrawers()
        //{
        //    for (Page p : drawerConfig.getPages())
        //    {
        //        for (BaseNode i : p.getNodes())
        //        {
        //            Drawer d = ReadWrite.readFromXml(fcName, i.getnKey() + ".xml");
        //            System.out.println("FileCabinet::Loading Drawer: " + d.getDrawerName());
        //            LogTracker.updateLog(fcName, "FileCabinet::Loading Drawer: " + d.getDrawerName());
        //            drawers.add(d);
        //        }
        //    }
        //}

        //public void loadConfigs(String input)
        //{
        //    fcName = input;
        //    drawerConfig = new Drawer("drawerConfigs");
        //    if (new File("fcRepo\\" + fcName + "\\drawerConfigs.xml").exists())
        //    {
        //        System.out.println("Found drawer configuration settings...\nLoading drawer configuration settings...");
        //        LogTracker.updateLog(fcName, "Found drawer configuration settings...Loading drawer configuration settings...");
        //        drawerConfig = ReadWrite.readFromXml(fcName, "drawerConfigs.xml");
        //        //			for(Page p : drawerConfig.getPages()){
        //        //				for(BaseNode bn : p.getNodes()){
        //        //					System.out.println(bn.getnKey()+":"+bn.getnValue());
        //        //				}
        //        //			}
        //    }
        //    else
        //    {
        //        System.out.println("No drawer configuration setting file found...");
        //    }
        //}

        //COPPERHEAD - Commenting out until I figure out how to work with files and threads
        //public void saveFileCabinet()
        //{
        //    updateConfigs();
        //    for (Drawer d : drawers)
        //    {
        //        //writeToXml(d);
        //        WriteThread.execute(fcName, d);
        //    }
        //}

        public Boolean setActiveDrawer(String dn)
        {
            activeDrawer = null;
            foreach (Drawer d in drawers)
            {
                if (d.DrawerName.Equals(dn))
                {
                    activeDrawer = d;
                    return true;
                }
            }
            return false;
        }

        //COPPERHEAD - Commenting out until I write the ParseCommand utility
        //public Boolean setActiveFolder(String fn)
        //{
        //    //activeFolder = null;
        //    List<string> temp = ParseCommand.parseFolderInput(fn);
        //    Folder check = activeDrawer.getFolder(temp);
        //    if (check != null)
        //    {
        //        activeFolder = fn;
        //        return true;
        //    }
        //    else
        //    {
        //        return false;
        //    }
        //}

        public void updateConfigs()
        {
            if (drawers != null && drawers.Count > 0)
            {
                drawerConfig = new Drawer("drawerConfigs");
                foreach (Drawer d in drawers)
                {
                    Page p = new Page(drawerConfig.PageCount);
                    p.addNode(new IntegerNode(d.DrawerName, d.PageCount));
                    drawerConfig.addPage(p);
                }
                //COPPERHEAD - Commenting this out until I write the WriteThread utility
                //WriteThread.execute(fcName, drawerConfig);
            }
        }
        
        public override string ToString()
        {
            return "FileCabinet: " + fcName;
        }
        //Getters and Setters

        public string FcName { get => fcName; set => fcName = value; }

        public List<Drawer> Drawers {
            get => drawers;
            set {
                if (drawers == null) {
                    drawers = new List<Drawer>();
                }
                drawers = value;
            }
        }
    }
}
